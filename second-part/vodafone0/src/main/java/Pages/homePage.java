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

    public void scrollDown1(){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("scrollBy(0,1200)");
    }
    public void scrollDown2(){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("scrollBy(0,800)");
    }
    public item_1 clickItem_1(){

       WebElement item_1 = driver.findElement(By.xpath("/html/body/vf-root/main/section[2]/vf-la" +
               "nding-page/vf-ng-main-container[2]/section/div/div[3]/vf-middleware/div[2]/vf-products-contai" +
               "ner/section/div[2]/div/vf-product-box-featured[2]/div/div[3]/div/div[1]/p"));
       item_1.click();
        return new item_1(driver);
    }
    public item_2 clickItem_2(){

        WebElement item_1 = driver.findElement(By.xpath("//*[@id=\"01HJ6A5VWGMP4S0EM" +
                "DJ9VT10QJ\"]/vf-product-box-featured[3]/div/div[2]/img"));
        item_1.click();
        return new item_2(driver);
    }
    public void searchItem_3(){
        driver.findElement(By.id("searchInput")).sendKeys("سامسونج");


    }
public searchPage selectSearchedResult(){
    driver.findElement(By.xpath("/html/body/vf-root/main/section[1]/vf-nav-bar/nav/div" +
            "/div[2]/vf-search-engine/div[1]/div[2]/div[3]/div/div[1]/p[1]")).click();
    return new searchPage(driver);
}

    public loginPage clickLoginIcon(){
        driver.findElement(By.id("userProfileMenu")).click();
        return new loginPage(driver);
    }
}

