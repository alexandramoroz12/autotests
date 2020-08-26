package test.java.hw_5_Wait;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;


public class WaitTest {

    WebDriver driver;
    WebDriverWait wait;

    /*
    By enterToAccountBy = By.xpath("//*[@class='header-topline__user-link link-dashed']");
    By registerButtonOnEnterScreenBy = By.xpath("//*[@class='auth-modal__register-link']");
    By surnameFieldBy = By.xpath("//div[@class='auth-modal']//input[@formcontrolname='surname']");
    By nameFieldBy = By.xpath("//div[@class='auth-modal']//input[@formcontrolname='name']");
    By emailPhoneFieldBy = By.xpath("//div[@class='auth-modal']//input[@formcontrolname='username']");
    By passwordFieldBy = By.xpath("//div[@class='auth-modal']//input[@formcontrolname='password']");
    By registerButtonOnSignUoScreenBy = By.xpath("//*[@class='button button_size_large button_color_green auth-modal__submit']");

    By errorMsgSurname = By.xpath("//p[contains(text(),' Введите свою фамилию на кириллице ')]");
    By errorMsgName = By.xpath("//p[contains(text(),'Введите свое имя на кириллице')]");
    By errorMsgEmail = By.xpath("//p[contains(text(),'Введите свою эл. почту или телефон')]");
    By errorPasswordFrame = By.xpath("//div[@class='form__row_with_button']//input[@class='ng-pristine ng-invalid ng-touched']");

    By errorSurnameFrame = By.xpath("//fieldset[@class='form__row js-name validation_type_error']//input[@formcontrolname='surname'] ");
    By errorNameFrame = By.xpath("//fieldset[@class='form__row js-name validation_type_error']//input[@formcontrolname='name']");
    By errorEmailFrame = By.xpath("//fieldset[@class='form__row js-contact validation_type_error']//input[@class='ng-pristine ng-invalid ng-touched']");

   */


   // By enterToAccountBy2 = By.xpath("//*[@class='header-user-link sprite-side whitelink xhr']");
    //  By registerButtonOnEnterScreenBy2 = By.xpath("//*[@class='novisited auth-f-signup-link']");
   // By nameFieldBy2 = By.xpath("//*[@class='auth-f-i']//input[@name='title']");
   // By emailPhoneFieldBy2 = By.xpath("//*[@class='auth-f-i']//input[@name='login']");
   // By passwordFieldBy2 = By.xpath ("//*[@class='auth-f-i']//input[@name='password']");
   // By registerButtonOnSignUoScreenBy2 = By.xpath ("//*[@class='btn-link btn-link-green btn-link-sign']");


    By enterToAccountByMixed = By.xpath("//*[(@class='header-topline__user-link link-dashed') or (@class='header-user-link sprite-side whitelink xhr')]");
    By registerButtonOnEnterScreenByMixed = By.xpath("//*[(@class='auth-modal__register-link') or (@class='novisited auth-f-signup-link')]");
    By nameFieldByMixed = By.xpath("//*[(@formcontrolname='name') or (@name='title')]");
    By emailPhoneFieldByMixed = By.xpath("//*[(@formcontrolname='username') or (@name='login')]");
    By passwordFieldByMixed = By.xpath("//*[(@formcontrolname='password') or (@name='password')]");
    By registerButtonOnSignUoScreenByMixed = By.xpath("//*[(@class='button button_size_large button_color_green auth-modal__submit') or (@class='btn-link btn-link-green btn-link-sign')]");


    By errorNameFrame2 = By.xpath ("//input[@class='input-text auth-input-text input-invalid'][@name='title']");
    By errorEmailFrame2 = By.xpath ("//input[@class='input-text auth-input-text input-invalid'][@name='login']");
    By errorPasswordFrame2 = By.xpath ("//input[@class='input-text auth-input-text input-invalid'][@name='password']");


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

    }


    @Test
     public void test1AllFields () {


        driver.get("https://rozetka.com.ua/");


       // Actions actions = new Actions(driver);
        driver.findElement(enterToAccountByMixed).click();
        driver.findElement(registerButtonOnEnterScreenByMixed).click();

        wait.until(ExpectedConditions.and(
                ExpectedConditions.elementToBeClickable(nameFieldByMixed),
                ExpectedConditions.elementToBeClickable(emailPhoneFieldByMixed),
                ExpectedConditions.elementToBeClickable(passwordFieldByMixed)
        ));

       // driver.findElement(surnameFieldBy).click();
        driver.findElement(nameFieldByMixed).click();
        driver.findElement(emailPhoneFieldByMixed).click();
        driver.findElement(passwordFieldByMixed).click();
        driver.findElement(registerButtonOnSignUoScreenByMixed).click();

        WebElement nameInput = driver.findElement(errorNameFrame2);
        String actualColorName = nameInput.getCssValue("border-color");
        String expectedColor = "rgb(253, 124, 124)";
        assertEquals(actualColorName, expectedColor);

        WebElement emailInput = driver.findElement(errorEmailFrame2);
        String actualColorEmail = emailInput.getCssValue("border-color");
        assertEquals(actualColorEmail, expectedColor);


        WebElement passInput = driver.findElement(errorPasswordFrame2);
        String actualColorPass = passInput.getCssValue("border-color");
        assertEquals(actualColorPass, expectedColor);

     }



    @Test
    public void test2TwoFields () {


        driver.get("https://rozetka.com.ua/");




        // Actions actions = new Actions(driver);
        driver.findElement(enterToAccountByMixed).click();
        driver.findElement(registerButtonOnEnterScreenByMixed).click();

        wait.until(ExpectedConditions.and(
                ExpectedConditions.elementToBeClickable(nameFieldByMixed),
                ExpectedConditions.elementToBeClickable(emailPhoneFieldByMixed),
                ExpectedConditions.elementToBeClickable(passwordFieldByMixed)
        ));

        // driver.findElement(surnameFieldBy).click();
        driver.findElement(nameFieldByMixed).click();
        //driver.findElement(emailPhoneFieldByMixed).click();
        driver.findElement(passwordFieldByMixed).click();
        driver.findElement(registerButtonOnSignUoScreenByMixed).click();

        WebElement nameInput = driver.findElement(errorNameFrame2);
        String actualColorName = nameInput.getCssValue("border-color");
        String expectedColor = "rgb(253, 124, 124)";
        assertEquals(actualColorName, expectedColor);

        /*
        WebElement emailInput = driver.findElement(errorEmailFrame2);
        String actualColorEmail = emailInput.getCssValue("border-color");
        assertEquals(actualColorEmail, expectedColor);
        */

        WebElement passInput = driver.findElement(errorPasswordFrame2);
        String actualColorPass = passInput.getCssValue("border-color");
        assertEquals(actualColorPass, expectedColor);

    }




     @AfterMethod
     public void tearDown () {
         driver.quit();
     }

}
