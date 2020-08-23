package test.java.hw_4_chromeDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverTest {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rozetka.com.ua/");

        By number = By.xpath("//*[@class='header-phones__button']");

        String numberValue = driver.findElement(number).getText();

        String numberResult =  numberValue.substring(1,4) + numberValue.substring(6,9) + numberValue.substring(10,12) + numberValue.substring(13,15);

        System.out.println("Rozetka phone number: " + numberResult);

        driver.quit();

    }
}
