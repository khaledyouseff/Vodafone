package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class cartPage {
    WebDriver driver;
    public cartPage(WebDriver driver){
        this.driver=driver;
    }
    public String getItem_1Title(){
     String item_1Title= driver.findElement(By.xpath("/html/body/vf-root/main/section[2]/vf-my-cart/d" +
             "iv/div/div/div[1]/div[1]/div/div[2]/p")).getText();
     return item_1Title;
    }

    public String getItem_2Title(){
        String item_2Title= driver.findElement(By.xpath("/html/body/vf-root/main/section[2]/vf-my-car" +
                "t/div/div/div/div[1]/div[2]/div/div[2]/p")).getText();
        return item_2Title;
    }
    public String getItem_3Title(){
        String item_3Title= driver.findElement(By.xpath("/html/body/vf-root/main/section[2]/vf-my" +
                "-cart/div/div/div/div[1]/div[3]/div/div[2]/p")).getText();
        return item_3Title;
    }
    public void scrollDown(){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("scrollBy(0,800)");
    }
}
