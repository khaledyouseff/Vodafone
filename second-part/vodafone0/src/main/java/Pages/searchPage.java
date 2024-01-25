package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class searchPage {
    WebDriver driver;

    public searchPage(WebDriver driver) {
        this.driver = driver;
    }

    public item_3 clickItem_3() {
        WebElement item_3 = driver.findElement(By.xpath("/html/body/vf-root/main/section[2]" +
                "/vf-product-list-page/div/div[2]/div[5]/vf-product-box-featured[1]/div/div[2]/img"));
        item_3.click();
        return new item_3(driver);
    }
}