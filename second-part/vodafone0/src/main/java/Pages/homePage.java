package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
        js.executeScript("scrollBy(0,1100)");
    }

    public item_1 clickItem_1(){

       WebElement item_1 = driver.findElement(By.xpath("/html/body/vf-root/main/section[2]/vf-landing-page/vf-ng-main-container[2]/section/div/div[3]/vf-middleware/div[2]/vf-products-container/section/div[2]/div/vf-product-box-featured[2]/div/div[3]/div/div[1]/p"));
       item_1.click();
        return new item_1(driver);
    }
    public loginPage clickLoginIcon(){
        driver.findElement(By.id("userProfileMenu")).click();
        return new loginPage(driver);
    }
}

