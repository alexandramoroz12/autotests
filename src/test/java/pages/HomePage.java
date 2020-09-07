package test.java.pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    WebDriver driver;
    WebDriverWait wait;

    Logger logger = LogManager.getLogger(HomePage.class);

    By searchInput = By.xpath("//input[@class='rz-header-search-input-text passive']");
    By searchButton = By.xpath("//button[@class='btn-link-i js-rz-search-button']");
   // By filterCheckbox = By.xpath("//input[@class='custom-checkbox']");


    public HomePage(WebDriver driver) {

        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }


    public HomePage open () {

        this.logger.trace("Trace");
        this.logger.debug("Debug");
        this.logger.info("Info");
        this.logger.warn("Warn");
        this.logger.error("Error");
        this.logger.fatal("Fatal");


        this.logger.info("Home page was opened");
        logger.debug("Logger debug");
        driver.get("https://rozetka.com.ua/");
        return this;
    }

    public HomePage searchHomePage (String str) {

        driver.findElement(searchInput).sendKeys(str);
        driver.findElement(searchButton).click();
        return this;
    }


    /*
    public HomePage clickFilter () {

        WebElement filter = driver.findElement(filterCheckbox);
       // wait.until(ExpectedConditions.elementToBeClickable(contactBtnBy));
        filter.click();
        return this;
    }

     */



    public HomePage clickFilter (String filter) {
        WebElement filterElement = driver.findElement(By.cssSelector("div[data-filter-name='producer'] label[for='" + filter + "']"));
        wait.until(ExpectedConditions.elementToBeClickable(filterElement));
        filterElement.click();
        wait.until(ExpectedConditions.textToBePresentInElement(filterElement,filter));
        return this;
    }


}
