package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class item_1 {
    private final WebDriver driver;

    public  item_1(WebDriver driver) {
        this.driver = driver;
    }

public void addToCart(){
        driver.findElement(By.className("add-to-cart")).click();
}
    public homePage clickHomePageIcon(){
        driver.findElement(By.cssSelector("p.logo-text")).click();
        return new homePage(driver);
    }
}

