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

public class loginSteps {
    WebDriver driver;
    @Given("user open url and go to login page")
    public void user_open_url_and_go_to_login_page() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://eshop.vodafone.com.eg/ar/");

    }

    @When("fill valid username and password")
    public void fill_valid_username_and_password() {
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
        driver.findElement(By.id("userProfileMenu")).click();
        driver.findElement(By.id("username")).sendKeys("01140342431");
        driver.findElement(By.id("password")).sendKeys("Khaled1997#");
        driver.findElement(By.id("submitBtn")).click();
    }

    @Then("user login successfully")
    public void user_login_successfully() {
        

    }
}
