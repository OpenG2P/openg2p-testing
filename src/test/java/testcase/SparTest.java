package testcase;


import base.SparSetup;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import utilities.commons;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;


public class SparTest extends SparSetup {

    @Test
    public static void bankAccount() throws InterruptedException, IOException {
        fileReader1 = new FileReader("testconfig/configfile/config.properties");
        fileReader2 = new FileReader("src/main/resources/configfiles/locators.properties");
        properties.load(fileReader1);
        locators.load(fileReader2);
        Thread.sleep(2000);
        commons.click(driver, By.xpath(locators.getProperty("sign_in_with_national_id")));
        commons.click(driver,By.xpath(locators.getProperty("login_with_otp")));
        commons.enter(driver,By.id(locators.getProperty("vid")),"7675948129");
        commons.click(driver,By.xpath(locators.getProperty("get_otp")));
        commons.click(driver,By.xpath(locators.getProperty("otp")));
        String otpValue = "1";
        for (int i = 1; i <= 6; i++) {
            String fieldXpath = "(//input[@class='pincode-input-text'])[" + i + "]";
            driver.findElement(By.xpath(fieldXpath)).sendKeys(otpValue);
        }
        commons.click(driver,By.xpath(locators.getProperty("verify_otp")));
        commons.click(driver,By.xpath(locators.getProperty("update_details")));
        commons.click(driver,By.id(locators.getProperty("payment_type_dropdown")));
        commons.click(driver,By.xpath(locators.getProperty("payment_type_bank_account")));
        commons.click(driver,By.id(locators.getProperty("bank_dropdown")));
        commons.click(driver,By.xpath(locators.getProperty("bank2")));
        commons.click(driver,By.id(locators.getProperty("branch_dropdown")));
        commons.click(driver,By.xpath(locators.getProperty("branch_name")));
        commons.enter(driver,By.id(locators.getProperty("account_number")),"9876543212");
        commons.click(driver,By.xpath(locators.getProperty("submit_button")));


    }

    @Test
    public static void wallet() throws InterruptedException, IOException {
        fileReader1 = new FileReader("testconfig/configfile/config.properties");
        fileReader2 = new FileReader("src/main/resources/configfiles/locators.properties");
        properties.load(fileReader1);
        locators.load(fileReader2);
        Thread.sleep(2000);
        commons.click(driver, By.xpath(locators.getProperty("sign_in_with_national_id")));
        commons.click(driver,By.xpath(locators.getProperty("login_with_otp")));
        commons.enter(driver,By.id(locators.getProperty("vid")),"7675948129");
        commons.click(driver,By.xpath(locators.getProperty("get_otp")));
        commons.click(driver,By.xpath(locators.getProperty("otp")));
        String otpValue = "1";
        for (int i = 1; i <= 6; i++) {
            String fieldXpath = "(//input[@class='pincode-input-text'])[" + i + "]";
            driver.findElement(By.xpath(fieldXpath)).sendKeys(otpValue);
        }
        commons.click(driver,By.xpath(locators.getProperty("verify_otp")));
        commons.click(driver,By.xpath(locators.getProperty("update_details")));
        commons.click(driver,By.id(locators.getProperty("payment_type_dropdown")));
        commons.click(driver,By.xpath(locators.getProperty("payment_type_wallet")));
        commons.click(driver,By.id(locators.getProperty("wallet_dropdown")));
        commons.click(driver,By.xpath(locators.getProperty("pink_wallet")));
        commons.enter(driver,By.id(locators.getProperty("phone_number_wallet")),"9876543219");
        commons.click(driver,By.xpath(locators.getProperty("submit_button")));
    }


    @Test
    public static void mpesa() throws IOException, InterruptedException {
        fileReader1 = new FileReader("testconfig/configfile/config.properties");
        fileReader2 = new FileReader("src/main/resources/configfiles/locators.properties");
        properties.load(fileReader1);
        locators.load(fileReader2);
        Thread.sleep(2000);
        commons.click(driver, By.xpath(locators.getProperty("sign_in_with_national_id")));
        commons.click(driver,By.xpath(locators.getProperty("login_with_otp")));
        commons.enter(driver,By.id(locators.getProperty("vid")),"7675948129");
        commons.click(driver,By.xpath(locators.getProperty("get_otp")));
        commons.click(driver,By.xpath(locators.getProperty("otp")));
        String otpValue = "1";
        for (int i = 1; i <= 6; i++) {
            String fieldXpath = "(//input[@class='pincode-input-text'])[" + i + "]";
            driver.findElement(By.xpath(fieldXpath)).sendKeys(otpValue);
        }
        commons.click(driver,By.xpath(locators.getProperty("verify_otp")));
        commons.click(driver,By.xpath(locators.getProperty("update_details")));
        commons.click(driver,By.id(locators.getProperty("payment_type_dropdown")));
        commons.click(driver,By.xpath(locators.getProperty("payment_type_mpesa")));
        commons.enter(driver,By.xpath(locators.getProperty("email_empesa")),"yash@gmail.com");
        commons.click(driver,By.xpath(locators.getProperty("submit_button")));

    }
}
