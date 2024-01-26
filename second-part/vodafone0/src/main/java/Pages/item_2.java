package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class item_2 {
    private final WebDriver driver;

    public  item_2(WebDriver driver) {
        this.driver = driver;
    }

    public void addToCart(){
        driver.findElement(By.className("add-to-cart")).click();
    }
    public homePage clickHomePageIcon(){
        driver.findElement(By.cssSelector("p.logo-text")).click();
        return new homePage(driver);
    }
    public cartPage clickCartIcon(){
        driver.findElement(By.className("cart-icon")).click();
        return new cartPage(driver);
    }
}

