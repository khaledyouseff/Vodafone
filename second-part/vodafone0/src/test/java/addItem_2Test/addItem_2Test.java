package addItem_2Test;
import Pages.item_2;
import baseTest.baseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import Pages.loginPage;
import Pages.homePage;
import Pages.item_1;
import baseTest.baseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class addItem_2Test extends baseTest {

    @Test
    public void addingItem_1ToCartTest() throws InterruptedException {


        //login
        homePage homePage = new homePage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement cookies = wait.until(ExpectedConditions.elementToBeClickable(By.id("onetrust-accept-btn-handler")));
        homePage.clickAcceptCookies();
        homePage.clickLoginIcon();
        Pages.loginPage loginPage = new loginPage(driver);
        loginPage.setMobileNumber("1140342431");
        loginPage.setPassWord("Khaled1997#");
        // driver.manage().timeouts().implicitlyWait(4 , TimeUnit.SECONDS);
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("submitBtn")));
        loginButton.click();
        ///---------------------------------------------
        //click on item 1
        Thread.sleep(5000);
        homePage.scrollDown();
        Thread.sleep(5000);
        homePage.clickItem_2();

        item_2 item2 = new item_2(driver);
        WebElement addTOCart = wait.until(ExpectedConditions.elementToBeClickable(By.className("add-to-cart")));
        item2.addToCart();
    }
}