package test.java.hw_5_Wait;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class WaitTest {

    WebDriver driver;

    By enterToAccountBy = By.xpath("//*[@class='header-topline__user-link link-dashed']");
    By registerButtonOnEnterScreenBy = By.xpath("//*[@class='auth-modal__register-link']");
    By surnameFieldBy = By.xpath("//div[@class='auth-modal']//input[@formcontrolname='surname']");
    By nameFieldBy = By.xpath("//div[@class='auth-modal']//input[@formcontrolname='name']");
    By emailPhoneFieldBy = By.xpath("//div[@class='auth-modal']//input[@formcontrolname='username']");
    By passwordFieldBy = By.xpath("//div[@class='auth-modal']//input[@formcontrolname='password']");
    By registerButtonOnSignUoScreenBy = By.xpath("//*[@class='button button_size_large button_color_green auth-modal__submit']");


    @BeforeMethod
    public void setUp () {

        System.setProperty("webdriver.chrome.driver", "chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        WebDriver driver = new ChromeDriver(options);
       // WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }


    @Test
     public void test1 () {


        driver.get("https://rozetka.com.ua/");
       // Actions actions = new Actions(driver);
        driver.findElement(enterToAccountBy).click();
        driver.findElement(registerButtonOnEnterScreenBy).click();
        driver.findElement(surnameFieldBy).click();
        driver.findElement(nameFieldBy).click();
        driver.findElement(emailPhoneFieldBy).click();
        driver.findElement(passwordFieldBy).click();
        driver.findElement(registerButtonOnSignUoScreenBy).click();


     }


     @AfterMethod
     public void tearDown () {
         driver.quit();
     }

}
