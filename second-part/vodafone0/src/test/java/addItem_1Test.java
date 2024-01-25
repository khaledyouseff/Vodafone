import baseTest.baseTest;
import org.openqa.selenium.WebDriver;
import Pages.loginPage;
import Pages.homePage;
import Pages.item_1;
import baseTest.baseTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class addItem_1Test extends baseTest {

    @Test
    public void addingItem_1ToCartTest(){


        loginPage loginPage = new loginPage(driver);
       // driver.manage().timeouts().implicitlyWait(4,TimeUnit.SECONDS);
        loginPage.setMobileNumber("1140342431");
        loginPage.setPassWord("Khaled1997#");
        homePage homePage= loginPage.clickLogIn();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

       //homePage = new homePage(driver);
        homePage.clickAcceptCookies();
        homePage.scrollDown();
        homePage.clickItem_1();

        item_1 item1 = new item_1(driver);
        item1.addToCart();
    }


}
