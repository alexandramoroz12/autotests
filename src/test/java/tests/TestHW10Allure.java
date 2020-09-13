package test.java.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.java.pages.HomePage;
import test.java.utils.PropertyLoader;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

public class TestHW10Allure {

    WebDriver driver;
    WebDriverWait wait;
    HomePage homePage;

    String producers[] = {"Acer","Apple","Asus","Dell","Dream Machines","HP",
            "Huawei","Lenovo","MSI","Microsoft","Razer","Xiaomi",
            "Alien","Chuwi","Digma","Durabook","Epic","Fujitsu",
            "Fujitsu-siemens","Gigabyte","Google","Intel","Jumper",
            "LG","Mediacom","Medion","Mixzo","NuVision","Odys",
            "Panasonic","Pixus","Porsche Design","Prestigio","RCA",
            "Samsung","Teclast","Toshiba","Vinga","Yepo"};

    @BeforeMethod
    public void setUp (ITestContext testContext) {

        System.setProperty("webdriver.chrome.driver", "chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        // WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 10, 500);
        homePage = new HomePage(driver);
        testContext.setAttribute("driver", driver);

    }

    @Test
    public void test () {

        driver.get(PropertyLoader.loadProperty("notebookurl"));

        int counter = (int)( Math.random()*(producers.length));

        homePage.clickFilter(producers[counter]);

        //список товаров определенного производителя
        List<WebElement> goods = driver.findElements(By.xpath("//span[@class='goods-tile__title']"));

        // в цикле проверяем, что каждый товар содержит название производителя
        for (WebElement good : goods) {

            assertTrue(good.getText().toLowerCase().contains(producers[counter].toLowerCase()));
        }
    }


    @AfterMethod
    public void tearDown () {

        driver.quit();
    }
}
