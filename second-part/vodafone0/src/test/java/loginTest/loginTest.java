package loginTest;
import Pages.loginPage;
import Pages.homePage;
import baseTest.baseTest;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class loginTest extends baseTest {
    @Test
    public void successfulLoginTest(){


        loginPage loginPage = new loginPage(driver);
        loginPage.mobileNumber("01140342431");
        loginPage.setPassWord("Khaled1997#");
        homePage homePage= loginPage.clickLogIn();
    }
}
