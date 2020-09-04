package test.java.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    WebDriver driver;
    WebDriverWait wait;
    By searchInput = By.xpath("//input[@class='rz-header-search-input-text passive']");
    By searchButton = By.xpath("//button[@class='btn-link-i js-rz-search-button']");
    By filterCheckbox = By.xpath("//input[@class='custom-checkbox']");


    public HomePage(WebDriver driver) {
        this.driver = driver;
    }


    public HomePage open () {
        driver.get("https://rozetka.com.ua/");
        return this;
    }

    public HomePage searchHomePage (String str) {

        driver.findElement(searchInput).sendKeys(str);
        driver.findElement(searchButton).click();
        return this;
    }

    public HomePage clickFilter () {

        WebElement filter = driver.findElement(filterCheckbox);
       // wait.until(ExpectedConditions.elementToBeClickable(contactBtnBy));
        filter.click();
        return this;
    }
}
