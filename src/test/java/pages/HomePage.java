package test.java.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    WebDriver driver;
    By searchInput = By.xpath("//input[@class='rz-header-search-input-text passive']");
    By searchButton = By.xpath("//button[@class='btn-link-i js-rz-search-button']");


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
}
