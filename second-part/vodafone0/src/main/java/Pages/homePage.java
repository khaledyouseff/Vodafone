package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class homePage {
    private final WebDriver driver;

    public homePage(WebDriver driver) {
        this.driver = driver;
    }
public void clickAcceptCookies(){
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
}

    public void scrollDown(){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("scrollBy(0,800)");
    }

    public item_1 clickItem_1(){
        driver.findElement(By.xpath("/html/body/vf-root/main/section[2]/vf-landing-page/vf-ng-main-container[2]/section/div/div[3]/vf-middleware/div[2]/vf-products-container/section/div[2]/div/vf-product-box-featured[2]/div/div[3]/div/div[1]/p")).click();
        return new item_1(driver);
    }
    public loginPage clickLogin(){
        driver.findElement(By.xpath("/html/body/vf-root/main/section[1]/vf-nav-bar/nav/div/vf-user-profile/div/button/img")).click();
        return new loginPage(driver);
    }
}

