package add3ItemsInOneTest;
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



    public class add3ItemsInOneTest extends baseTest {
        @Test
        public void add3ItemsInOneTest() throws InterruptedException {
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
            homePage.scrollDown1();
           // Thread.sleep(5000);

            WebElement item_1IsVisible = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/vf-root/main/section[2]/vf-la" +
                    "nding-page/vf-ng-main-container[2]/section/div/div[3]/vf-middleware/div[2]/vf-products-contai" +
                    "ner/section/div[2]/div/vf-product-box-featured[2]/div/div[3]/div/div[1]/p")));
            homePage.clickItem_1();
            //adding item 1 to cart
            WebElement addTOCart = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("add-to-cart")));
            item_1 item1 = new item_1(driver);
            item1.addToCart();
            //back to home page
            item1.clickHomePageIcon();

            //click on item 2
            Thread.sleep(5000);
            homePage.scrollDown1();
            Thread.sleep(5000);
            homePage.clickItem_1();
            //adding item 2 to cart
            item_2 item2 = new item_2(driver);
            addTOCart = wait.until(ExpectedConditions.elementToBeClickable(By.className("add-to-cart")));
            item2.addToCart();
            //back to home page
            item2.clickHomePageIcon();
            //searching for item 3
            WebElement searchBar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("searchInput")));
            homePage.searchItem_3();
            Thread.sleep(5000);
            homePage.selectSearchedResult();
            homePage.scrollDown2();
            searchPage searchPage = new searchPage(driver);
            WebElement item = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/vf-root/main/section[2]" +
                    "/vf-product-list-page/div/div[2]/div[5]/vf-product-box-featured[1]/div/div[2]/img")));
            searchPage.clickItem_3();
            item_3 item3 = new item_3(driver);
            addTOCart = wait.until(ExpectedConditions.elementToBeClickable(By.className("add-to-cart")));
            item3.addToCart();





        }
    }
