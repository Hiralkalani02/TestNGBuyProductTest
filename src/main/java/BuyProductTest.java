
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class BuyProductTest {
    WebDriver driver;

    @Test(priority = 1)
    void openBrowser() {
        System.out.println("User is able to open the browser");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://demo.nopcommerce.com/");
    }

    @Test(priority = 2)
    void selectProduct() {
        driver.findElement(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[1]/a")).click();
        driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[1]/div/div[1]/div/h2/a")).click();
        driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[3]/div/div[2]/h2/a")).click();
        driver.findElement(By.id("add-to-cart-button-3")).click();

    }


    @Test(priority = 3)
    void verifyTextMessage() {
        driver.findElement(By.className("bar-notification-container"));

    }


    @Test(priority = 4)
    void updateCartQuantity() {
        driver.findElement(By.className("cart-label")).click();
        driver.findElement(By.className("qty-input")).click();
        driver.findElement(By.className("qty-input")).clear();
        driver.findElement(By.className("qty-input")).sendKeys("3");
        driver.findElement(By.id("updatecart")).click(); //update cart
    }

    @Test(priority = 5)
    void agreeTermsAndCondition() {

        driver.findElement(By.id("termsofservice")).click();
        driver.findElement(By.id("checkout")).click();

    }


    @Test(priority = 6)
    void checkOutAsGuest() {
        driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[1]/div[3]/button[1]")).click();
    }

    @AfterClass
    void closeBrowser() {
        driver.quit();
    }


}


