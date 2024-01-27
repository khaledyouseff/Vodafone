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

import static org.testng.AssertJUnit.assertTrue;

public class addItem_1ToCartSteps {
    WebDriver driver;
    @Given("user open url and go login page and login and go to homePage to select item 1")
    public void user_open_url_and_go_to_login_page() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://eshop.vodafone.com.eg/ar/");

    }

    @When("fill valid mobile number as {string} and password as {string} and click item 1 add to cart")
    public void fill_valid_mobile_number_and_password(String mobile, String password) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//login----------------------------------------------
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
        driver.findElement(By.id("userProfileMenu")).click();
        driver.findElement(By.id("username")).sendKeys(mobile);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("submitBtn")).click();
        Thread.sleep(5000);
        //scroll in home page and click item -------------------------------------
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("scrollBy(0,1200)");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/vf-root/main/section[2]/vf-la" +
                "nding-page/vf-ng-main-container[2]/section/div/div[3]/vf-middleware/div[2]/vf-products-contai" +
                "ner/section/div[2]/div/vf-product-box-featured[2]/div/div[3]/div/div[1]/p")));
        Thread.sleep(5000);
        driver.findElement(By.xpath("/html/body/vf-root/main/section[2]/vf-la" +
                "nding-page/vf-ng-main-container[2]/section/div/div[3]/vf-middleware/div[2]/vf-products-contai" +
                "ner/section/div[2]/div/vf-product-box-featured[2]/div/div[3]/div/div[1]/p")).click();
        //click at add to cart--------------------------------------

        WebElement addTOCart = wait.until(ExpectedConditions.elementToBeClickable(By.className("add-to-cart")));
        driver.findElement(By.className("add-to-cart")).click();
        Thread.sleep(5000);

    }

    @Then("user add item 1 to cart successfully")
    public void user_login_successfully() {
        //assert that the item is added to cart-----------------------------------
        driver.findElement(By.className("cart-icon")).click();
        String item_1Title= driver.findElement(By.xpath("/html/body/vf-root/main/section[2]/vf-my-cart/d" +
                "iv/div/div/div[1]/div[1]/div/div[2]/p")).getText();
        Assert.assertEquals("OPPO Smart Phone Reno 10 (5G)" ,item_1Title,  "Text does not match the expected value.");

    }}