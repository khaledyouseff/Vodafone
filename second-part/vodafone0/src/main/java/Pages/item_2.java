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
}

