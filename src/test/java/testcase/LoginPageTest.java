
package testcase;

import base.DriverCreator;
import listener.TestListeners;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.ReadXLSData;
import utilities.commons;



@Listeners(TestListeners.class)
@Test
public class LoginPageTest extends DriverCreator {

    @Test(priority = 1,dataProviderClass = ReadXLSData.class,dataProvider = "openg2pdata")
    public static void resetPassword(String email,String scenario) throws InterruptedException {
        commons.click(driver, By.linkText(locators.getProperty("reset_link")));
        commons.enter(driver,By.xpath(locators.getProperty("reset_email_field")),email);
        commons.click(driver,By.xpath(locators.getProperty("confirm_email_button")));
        if (scenario.equals("TRUE")) {
            String successMessage = driver.findElement(By.cssSelector(locators.getProperty("confirmation_message"))).getText();
            Assert.assertEquals(successMessage,"An email has been sent with credentials to reset your password");
        }
        else {
            String errorMessage = driver.findElement(By.cssSelector(locators.getProperty("reset_password_error_message"))).getText();
            Assert.assertEquals(errorMessage, "Incorrect email. Please enter the registered email address.");

        }
    }


    @Test(priority = 2,dataProviderClass = ReadXLSData.class,dataProvider = "openg2pdata")
    public static void loginTest(String email, String password, String scenario) throws InterruptedException {
        //Act
        commons.enter(driver,By.id(locators.getProperty("username_field")),email);
        commons.enter(driver,By.id(locators.getProperty("password_field")),password);
        commons.click(driver,By.xpath(locators.getProperty("login_button")));
//        Thread.sleep(2000);
//        if(scenario.equals("TRUE")) {
//            WebElement registry = driver.findElement(By.xpath(locators.getProperty("group_create_button")));
//            Assert.assertNotNull(registry);
//        }
//        else {
////            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//            String errorMessage = driver.findElement(By.xpath(locators.getProperty("login_error_message"))).getText();
//            Assert.assertEquals(errorMessage,"Login failed due to Invalid credentials !","Credentials are Invalid");
//
//        }

    }

}
