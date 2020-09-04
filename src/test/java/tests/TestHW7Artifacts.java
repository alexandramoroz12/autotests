package test.java.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test.java.pages.HomePage;

import java.security.SecureRandom;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

public class TestHW7Artifacts {

    WebDriver driver;
    WebDriverWait wait;
    HomePage homePage;

   // String arrProducers[] = {"Acer", "Apple", "Asus", "Dell", "Dream Machines", "HP", "Huawei", "Lenovo", "MSI", "Microsoft", "Razer", "Xiaomi", "Alien", "Chuwi", "Digma", "Durabook", "Epic", "Fujitsu", "Fujitsu-siemens", "Gigabyte", "Google", "Intel", "Jumper", "LG", "Mediacom", "Medion", "Mixzo", "NuVision", "Odys", "Panasonic", "Pixus", "Porsche Design", "Prestigio", "RCA", "Samsung", "Teclast", "Toshiba", "Vinga", "Yepo"};


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

    @Test(dataProvider = "dp")
    public void  test (String arr []) {

        driver.get("https://rozetka.com.ua/notebooks/c80004/");
        List<WebElement> producersCheckboxes = driver.findElements(By.xpath("//input[@class='custom-checkbox']"));

        for (String checkbox : arr){
            homePage.clickFilter(checkbox);

            List<WebElement> goods = driver.findElements(By.xpath("//span[@class='goods-tile__title']"));
            for (WebElement good : goods) {

                assertTrue(good.getText().toLowerCase().contains(arr));
            }

        }
    }


    @AfterMethod
    public void tearDown () {
        driver.quit();
    }

    @DataProvider(name = "dp")
    public Object[][] provider () {

        return new Object[][]{
                {"Acer"},{"Apple"},{"Asus"},{"Dell"},{"Dream Machines"},{"HP"},
                {"Huawei"},{"Lenovo"},{"MSI"},{"Microsoft"},{"Razer"},{"Xiaomi"},
                {"Alien"},{"Chuwi"},{"Digma"},{"Durabook"},{"Epic"},{"Fujitsu"},
                {"Fujitsu-siemens"},{"Gigabyte"},{"Google"},{"Intel"},{"Jumper"},
                {"LG"},{"Mediacom"},{"Medion"},{"Mixzo"},{"NuVision"},{"Odys"},
                {"Panasonic"},{"Pixus"},{"Porsche Design"},{"Prestigio"},{"RCA"},
                {"Samsung"},{"Teclast"},{"Toshiba"},{"Vinga"},{"Yepo"}
        };
    }
}
