package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class addItem_2ToCartSteps {
    WebDriver driver;
    @Given("user open url and go login page and login and go to homePage to select item 2")
    public void user_open_url_and_go_to_login_page() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://eshop.vodafone.com.eg/ar/");

    }
    @When("fill valid mobile number as {string} and password as {string} and click item 2 add to cart")
    public void fill_valid_mobile_number_and_password(String mobile, String password) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("onetrust-accept-btn-handler")));
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
        driver.findElement(By.id("userProfileMenu")).click();
        driver.findElement(By.id("username")).sendKeys(mobile);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("submitBtn")).click();

        Thread.sleep(5000);
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("scrollBy(0,1200)");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/vf-root/main/section[2]/vf-landing-page/vf-ng-main-container[2]/section/div/div[3]/vf-middleware/div[2]/vf-products-container/section/div[2]/div/vf-product-box-featured[3]/div/div[3]/div/div[1]/p")));
        Thread.sleep(5000);
        driver.findElement(By.xpath("/html/body/vf-root/main/section[2]/vf-landing-page/vf-ng-main-container[2]/section/div/div[3]/vf-middleware/div[2]/vf-products-container/section/div[2]/div/vf-product-box-featured[3]/div/div[3]/div/div[1]/p")).click();

        WebElement addTOCart = wait.until(ExpectedConditions.elementToBeClickable(By.className("add-to-cart")));
        driver.findElement(By.className("add-to-cart")).click();
        Thread.sleep(5000);

    }
    @Then("user add item 2 to cart successfully")
    public void user_login_successfully() {
        driver.findElement(By.className("cart-icon")).click();
      String  item_3Title= driver.findElement(By.xpath("/html/body/vf-root/main/section[2]/vf-my" +
                "-cart/div/div/div/div[1]/div[3]/div/div[2]/p")).getText();
        Assert.assertEquals("Samsung The Freestyle Portable Projector LSP3B" ,item_3Title,  "Text does not match the expected value.");

    }
}
