package loginTest;
import Pages.loginPage;
import Pages.homePage;
import baseTest.baseTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class loginTest extends baseTest {
    @Test
    public void successfulLoginTest(){

        homePage homePage = new homePage(driver);
        homePage.clickAcceptCookies();
        homePage.clickLoginIcon();
        loginPage loginPage = new loginPage(driver);
        loginPage.setMobileNumber("1140342431");
        loginPage.setPassWord("Khaled1997#");
        driver.manage().timeouts().implicitlyWait(4 , TimeUnit.SECONDS);
       // homePage= loginPage.clickLogIn();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("submitBtn")));
        loginButton.click();

        // driver.manage().timeouts().implicitlyWait(4 , TimeUnit.SECONDS);
    }
}
