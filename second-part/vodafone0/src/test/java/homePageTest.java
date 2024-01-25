import Pages.loginPage;
import baseTest.baseTest;
import Pages.homePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class homePageTest extends baseTest{
@Test
    public void clickONItem_1() throws InterruptedException {
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
    //WebElement item_1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/vf-root/main/section[1]/vf-nav-bar/nav/div/vf-user-profile/div/button/img")));
   homePage.clickItem_1();

}
}
