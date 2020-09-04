package test.java.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.java.pages.HomePage;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TestHW6PO {

    WebDriver driver;
    WebDriverWait wait;
    HomePage homePage;

    @BeforeMethod
    public void setUp () {

        System.setProperty("webdriver.chrome.driver", "chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        // WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 10, 500);
        homePage = new HomePage(driver);

    }

    @Test
    public void test1() {

      String expectedGoodName = "iPhone";
      homePage.open();
      homePage.searchHomePage(expectedGoodName);
      List<WebElement> goods1 = driver.findElements(By.xpath("//span[@class='goods-tile__title']"));
        for (WebElement good: goods1) {
            //String actualGoodName = good.getText().contains("iPhone");
            assertTrue(good.getText().contains(expectedGoodName));
        }

    }

    @Test
    public void test2() {

        String expectedGoodName = "Samsung";
        homePage.open();
        homePage.searchHomePage(expectedGoodName);
        List<WebElement> goods2 = driver.findElements(By.xpath("//div[@class='g-i-tile-i-title clearfix']"));
        for (WebElement good: goods2) {
            //String actualGoodName = good.getText().contains("Samsung");
            assertTrue(good.getText().toLowerCase().contains(expectedGoodName));
        }

    }


    @AfterMethod
    public void tearDown () {
        driver.quit();
    }
}
