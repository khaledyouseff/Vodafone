package addItem_3Test;
import Pages.*;
import baseTest.baseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import baseTest.baseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class addItem_3Test extends baseTest {
    @Test
    public void addingItem_3ToCartTest() throws InterruptedException {


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
        //search for item 3
        WebElement searchBar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("searchInput")));
        homePage.searchItem_3();
        //WebElement selectSearchedResult = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/vf-root/main/section[1]/vf-nav-bar/nav/div" +
               // "/div[2]/vf-search-engine/div[1]/div[2]/div[3]/div/div[1]/p[1]")));
        Thread.sleep(5000);
        homePage.selectSearchedResult();

        homePage.scrollDown2();
        searchPage searchPage = new searchPage(driver);
       // Thread.sleep(5000);
        WebElement item = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/vf-root/main/section[2]" +
                "/vf-product-list-page/div/div[2]/div[5]/vf-product-box-featured[1]/div/div[2]/img")));
        searchPage.clickItem_3();
        //Thread.sleep(5000);
        item_3 item3 = new item_3(driver);
        WebElement addTOCart = wait.until(ExpectedConditions.elementToBeClickable(By.className("add-to-cart")));
        item3.addToCart();
    }
}
