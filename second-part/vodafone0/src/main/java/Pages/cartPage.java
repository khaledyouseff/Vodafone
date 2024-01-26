package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class cartPage {
    WebDriver driver;
    public cartPage(WebDriver driver){
        this.driver=driver;
    }
    public String getItem_1Title(){
     String item_1Title= driver.findElement(By.xpath("/html/body/vf-root/main/section[2]" +
             "/vf-my-cart/div/div/div/div[1]/div/div/div[2]/p")).getText();
     return item_1Title;
    }
}
