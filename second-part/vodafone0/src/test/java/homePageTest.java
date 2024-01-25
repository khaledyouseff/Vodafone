import baseTest.baseTest;
import Pages.homePage;
import org.testng.annotations.Test;

public class homePageTest extends baseTest{
@Test
    public void openHomePage(){
    homePage homePage = new homePage(driver);
    homePage.clickAcceptCookies();
    homePage.clickLogin();

}
}
