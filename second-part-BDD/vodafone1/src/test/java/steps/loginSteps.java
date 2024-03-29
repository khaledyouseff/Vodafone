package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertTrue;

public class loginSteps {
    WebDriver driver;
    @Given("user open url and go to login page")
    public void user_open_url_and_go_to_login_page() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://eshop.vodafone.com.eg/ar/");

    }

    @When("fill valid mobile number as {string} and password as {string}")
    public void fill_valid_mobile_number_and_password(String mobile, String password) {
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
        driver.findElement(By.id("userProfileMenu")).click();
        driver.findElement(By.id("username")).sendKeys(mobile);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("submitBtn")).click();
    }

    @Then("user login successfully")
    public void user_login_successfully() {
        boolean isLoggedIn = driver.findElement(By.xpath("/html/body/vf-root/main/section" +
                "[1]/vf-nav-bar/nav/div/div[1]/p")).isDisplayed();


        assertTrue("User is not logged in successfully", isLoggedIn);

    }
}
