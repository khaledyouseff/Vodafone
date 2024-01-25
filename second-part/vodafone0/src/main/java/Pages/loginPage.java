package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginPage {
    private final WebDriver driver;

    public loginPage(WebDriver driver) {
        this.driver = driver;
    }

    By number = By.id("username");
    By password =By.id("password");
    By goToMyAccount =By.id("submitBtn");

    public void mobileNumber(String mobileNumber) {
        driver.findElement(number).sendKeys(mobileNumber);
    }

    public void setPassWord(String passWord) {
        driver.findElement(password).sendKeys(passWord);
    }

    public homePage clickLogIn() {
        driver.findElement(goToMyAccount).click();
        return new homePage(driver);
    }
}