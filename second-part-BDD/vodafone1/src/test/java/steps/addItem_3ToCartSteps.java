package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class addItem_3ToCartSteps {
    WebDriver driver;
    @Given("user open url and go login page and login and go to homePage to select item 3")
    public void user_open_url_and_go_to_login_page() {

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://eshop.vodafone.com.eg/ar/");

    }
    @When("fill valid mobile number as {string} and password as {string} and click item 3 add to cart")
    public void fill_valid_mobile_number_and_password(String mobile, String password) throws InterruptedException {
        //login----------------------------------------------
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("onetrust-accept-btn-handler")));

        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
        driver.findElement(By.id("userProfileMenu")).click();
        driver.findElement(By.id("username")).sendKeys(mobile);
        driver.findElement(By.id("password")).sendKeys(password);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("submitBtn")));
        driver.findElement(By.id("submitBtn")).click();
        //type item name at search bar and select result -------------------------------------

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("searchInput")));
        driver.findElement(By.id("searchInput")).sendKeys("سامسونج");
        Thread.sleep(5000);
        driver.findElement(By.xpath("/html/body/vf-root/main/section[1]/vf-nav-bar/nav/div" +
                "/div[2]/vf-search-engine/div[1]/div[2]/div[3]/div/div[1]/p[1]")).click();
        //go to result page and click on the item-----------------------------------
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("scrollBy(0,800)");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/vf-root/main/section[2]" +
                "/vf-product-list-page/div/div[2]/div[5]/vf-product-box-featured[1]/div/div[2]/img")));
        driver.findElement(By.xpath("/html/body/vf-root/main/section[2]" +
                "/vf-product-list-page/div/div[2]/div[5]/vf-product-box-featured[1]/div/div[2]/img")).click();
        //add the item to cart and go to cart page-------------------------------------
        wait.until(ExpectedConditions.elementToBeClickable(By.className("add-to-cart")));
        driver.findElement(By.className("add-to-cart")).click();
        driver.findElement(By.className("cart-icon")).click();
        Thread.sleep(5000);

    }
    @Then("user add item 3 to cart successfully")
    public void user_login_successfully() {
        //assert that item is added to cart------------------------------
        driver.findElement(By.className("cart-icon")).click();
        String item_2Title= driver.findElement(By.xpath("/html/body/vf-root/main/section[2]/vf-my-car\" +\n" +
                "\"t/div/div/div/div[1]/div[2]/div/div[2]/p")).getText();
        Assert.assertEquals("OPPO Smart Phone A78" ,item_2Title,  "Text does not match the expected value.");

    }
}
