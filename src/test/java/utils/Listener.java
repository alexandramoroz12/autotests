package test.java.utils;

import org.openqa.selenium.WebDriver;
import org.testng.*;



public class Listener implements ISuiteListener, ITestNGListener, IInvokedMethodListener {


    @Override
    public void beforeInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {

    }

    @Override
    public void afterInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {

    }

    @Override
    public void onStart(ISuite iSuite) {

    }

    @Override
    public void onFinish(ISuite iSuite) {

    }

   //@Override
    public void onTestStart(ITestResult iTestResult) {
        //System.out.println(" ---- TEst started");
    }

   // @Override
    public void onTestSuccess(ITestResult iTestResult) {
        //System.out.println("Test finished successfuly");
    }


    //создание скриншотов только на упавшие тесты
   //@Override
    public void onTestFailure(ITestResult result) {
        ITestContext testContext = result.getTestContext();
        WebDriver driver = (WebDriver) testContext.getAttribute("driver");
        Screenshot screenshot = new Screenshot(driver);
        screenshot.makeScreenshot(result);
        System.out.println("Test finished with failure");
    }
}
