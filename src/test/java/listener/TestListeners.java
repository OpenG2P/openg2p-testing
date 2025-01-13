package listener;

import base.DriverCreator;
import io.qameta.allure.Allure;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestLogger;

import java.io.ByteArrayInputStream;

public class TestListeners implements ITestListener {


    public void onTestStart(ITestResult result) {
        TestLogger.info("***** Test Started: " + result.getName() + " *****");
    }


    public void onTestSuccess(ITestResult result) {
        TestLogger.info("***** Test Successful: " + result.getName() + " *****");
    }


    public void onTestFailure(ITestResult result) {
        TestLogger.error("***** Test Failed: " + result.getName() + " *****");
        WebDriver driver = DriverCreator.driver;
        if (driver != null) {
            try {
                captureAndAttachScreenshot(result.getName(), driver);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        TestLogger.info("Screenshot Taken");
    }

    private void captureAndAttachScreenshot(String testName, WebDriver driver) {
        if (driver instanceof TakesScreenshot screenshotDriver) {
            byte[] screenshot = screenshotDriver.getScreenshotAs(OutputType.BYTES);

            // Attach the screenshot as an image to Allure
            Allure.addAttachment(testName + " Screenshot", new ByteArrayInputStream(screenshot));
        }
    }


}
