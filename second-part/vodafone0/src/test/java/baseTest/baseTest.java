package baseTest;

import Pages.loginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

public class baseTest {
     public WebDriver driver;
    protected loginPage loginPage = new loginPage(driver);
    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://web.vodafone.com.eg/auth/realms/vf-realm/protocol/openid-connect/auth?client_id=eshop&redirect_uri=https%3A%2F%2Feshop.vodafone.com.eg%2Far%2F&state=a44a7794-f363-4774-8e73-3ed45f238738&response_mode=query&response_type=code&scope=openid&nonce=3984ef48-5c0c-40ab-839c-33b6abd3762b&ui_locales=en");
        loginPage=new loginPage(driver);
    }
}
