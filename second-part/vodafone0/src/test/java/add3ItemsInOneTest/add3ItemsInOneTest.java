package add3ItemsInOneTest;
import Pages.*;
import baseTest.baseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import baseTest.baseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;



    public class add3ItemsInOneTest extends baseTest {
        @Test
        public void add3ItemsInOneTest() throws InterruptedException {
            //login
            homePage homePage = new homePage(driver);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
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

            WebElement item_1IsClickable = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/vf-root/main/section[2]/vf-la" +
                    "nding-page/vf-ng-main-container[2]/section/div/div[3]/vf-middleware/div[2]/vf-products-contai" +
                    "ner/section/div[2]/div/vf-product-box-featured[2]/div/div[3]/div/div[1]/p")));
            Thread.sleep(5000);
            homePage.clickItem_1();
            //adding item 1 to cart
            WebElement addTOCart = wait.until(ExpectedConditions.elementToBeClickable(By.className("add-to-cart")));
            item_1 item1 = new item_1(driver);
            item1.addToCart();
            Thread.sleep(5000);
            //back to home page
            item1.clickHomePageIcon();

            //click on item 2
            Thread.sleep(5000);
            homePage.scrollDown1();
            Thread.sleep(5000);
            homePage.clickItem_2();
            //adding item 2 to cart
            item_2 item2 = new item_2(driver);
            addTOCart = wait.until(ExpectedConditions.elementToBeClickable(By.className("add-to-cart")));
            item2.addToCart();
            Thread.sleep(5000);
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
            Thread.sleep(5000);
            //assertion for the 3 items
            item3.clickCartIcon();
            cartPage cart = new cartPage(driver);
            Thread.sleep(5000);
            String i1= cart.getItem_1Title();
            Assert.assertEquals("OPPO Smart Phone Reno 10 (5G)" ,i1,  "Text does not match the expected value.");
            String i2= cart.getItem_2Title();
            Assert.assertEquals("OPPO Smart Phone A78" ,i2,  "Text does not match the expected value.");
            //cart.scrollDown();
            Thread.sleep(5000);
            //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"01HN2RXN4B0ZTR061PMB231E1" +
                    //"N\"]/div/div[2]/p")));
            String i3= cart.getItem_3Title();

            Assert.assertEquals("Samsung The Freestyle Portable Projector LSP3B" ,i3,
                    "Text does not match the expected value.");




        }
    }
