package additem_1Test;

import Pages.cartPage;
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
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class addItem_1Test extends baseTest {

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
        homePage.scrollDown1();
        WebElement item_1t   = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/vf-root/main/section[2]/vf-la" +
                "nding-page/vf-ng-main-container[2]/section/div/div[3]/vf-middleware/div[2]/vf-products-contai" +
                "ner/section/div[2]/div/vf-product-box-featured[2]/div/div[3]/div/div[1]/p")));

        Thread.sleep(5000);
        homePage.clickItem_1();
        //adding item 1 to cart
         WebElement addTOCart = wait.until(ExpectedConditions.elementToBeClickable(By.className("add-to-cart")));
        //driver.manage().timeouts().implicitlyWait(10 , TimeUnit.SECONDS);

        item_1 item1 = new item_1(driver);
        item1.addToCart();
        Thread.sleep(5000);
        //Assertion
        item1.clickCartIcon();
       cartPage cart = new cartPage(driver);
        Thread.sleep(5000);
        String i1= cart.getItem_1Title();
        Assert.assertEquals("OPPO Smart Phone Reno 10 (5G)" ,i1,  "Text does not match the expected value.");



    }


}
