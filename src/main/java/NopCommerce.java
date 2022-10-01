import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class NopCommerce {
    //WebDriver driver;
    WebDriver driver;
    @BeforeTest
    void openBrowser(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://demo.nopcommerce.com/");
    }

    @AfterTest
    void closeBrowser() throws InterruptedException {
        Thread.sleep(4000);
        driver.close();
    }
    @Test(priority = 1)
    void homePage() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[1]/a")).click();
        driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[2]/div[1]/div[2]/ul/li[1]/ul/li[1]/a")).click();
        driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[3]/div/div[2]/h2/a")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("add-to-cart-button-3")).click();

    }

    @Test(priority = 2)
    void updateCart() throws InterruptedException {
        driver.findElement(By.className("cart-label")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div/form/div[1]/table/tbody/tr/td[5]/input")).clear();
        driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div/form/div[1]/table/tbody/tr/td[5]/input")).sendKeys("3");

        Thread.sleep(1000);
        driver.findElement(By.id("updatecart")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("termsofservice")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("checkout")).click();
        driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[1]/div[3]/button[1]")).click();
    }

    @Test(priority = 3)
    void checkoutDetails(){
        driver.findElement(By.id("BillingNewAddress_FirstName")).sendKeys("Dhruvisha");
        driver.findElement(By.id("BillingNewAddress_LastName")).sendKeys("Patel");
        driver.findElement(By.id("BillingNewAddress_Email")).sendKeys("Dhruvi786@gmail.com");
        WebElement Country=driver.findElement(By.id("BillingNewAddress_CountryId"));
           Country.sendKeys("United Kingdom");
           driver.findElement(By.id("BillingNewAddress_City")).sendKeys("London");
           driver.findElement(By.id("BillingNewAddress_Address1")).sendKeys("241,Green Street");
           driver.findElement(By.id("BillingNewAddress_ZipPostalCode")).sendKeys("E68QG");
           driver.findElement(By.id("BillingNewAddress_PhoneNumber")).sendKeys("07865421346");
           driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/ol/li[1]/div[2]/div/button[4]")).click();
           driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/ol/li[3]/div[2]/form/div[2]/button")).click();

           driver.findElement(By.id("paymentmethod_1")).click();
           driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/ol/li[4]/div[2]/div/button")).click();

    }
    @Test(priority = 4)
    void paymentMethod(){
        driver.findElement(By.id("CreditCardType")).sendKeys("masterCard");
        driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/ol/li[5]/div[2]/form/div/div/div/div/table/tbody/tr[2]/td[2]/input")).sendKeys("Patel Patel");
        driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/ol/li[5]/div[2]/form/div/div/div/div/table/tbody/tr[3]/td[2]/input")).sendKeys("456787654");
        driver.findElement(By.id("ExpireMonth")).sendKeys("08");
        driver.findElement(By.id("ExpireYear")).sendKeys("2024");
        driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/ol/li[5]/div[2]/form/div/div/div/div/table/tbody/tr[5]/td[2]/input")).sendKeys("345");
        driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/ol/li[5]/div[2]/div/button")).click();

    }

}
