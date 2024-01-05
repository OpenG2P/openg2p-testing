package testcase;

import base.BaseLogin;
import listener.TestListeners;
import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.ReadXLSData;
import utilities.commons;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Listeners(TestListeners.class)
public class VoucherConfigFileTest extends BaseLogin {

    @Test(dataProviderClass = ReadXLSData.class,dataProvider = "openg2pdata")
    public static void voucherConfigFileCreation(String configFileName, String template, String qrCodeName,String qaCodeBody) throws IOException, InterruptedException {
        login();
        commons.click(driver, By.xpath(locators.getProperty("menu_option")));
        commons.click(driver, By.xpath(locators.getProperty("programs")));
        commons.click(driver,By.xpath(locators.getProperty("programs_configurations")));
        commons.click(driver,By.xpath(locators.getProperty("payment_file_config")));
        commons.click(driver,By.xpath(locators.getProperty("payment_file_config_create_button")));
        commons.enter(driver,By.xpath(locators.getProperty("payment_file_config_name")),configFileName);
        commons.enter(driver,By.xpath(locators.getProperty("voucher_template")),template);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        By qrCode = By.xpath("//ul[@class='nav nav-tabs']//li");
        commons.dropDownByValue(driver,qrCode,"QR Codes");
        commons.click(driver,By.xpath(locators.getProperty("qr_code_add_a_line")));
        commons.enter(driver,By.xpath(locators.getProperty("qr_code_name")),qrCodeName);
        commons.click(driver,By.xpath(locators.getProperty("qa_code_type")));
        By qrCodeType = By.xpath("//select[@class='o_input o_field_widget o_quick_editable' and @name='type']//option");
        commons.dropDownByValue(driver,qrCodeType,"QR code");
        commons.click(driver,By.xpath(locators.getProperty("qa_code_data_type")));
        By dataType =  By.xpath("//select[@class='o_input o_field_widget o_quick_editable' and @name='data_type']//option");
        commons.dropDownByValue(driver,dataType,"");
        commons.enter(driver,By.xpath(locators.getProperty("qr_code_body")),qaCodeBody);
        commons.click(driver,By.linkText(locators.getProperty("qr_code_save_and_close")));




    }
}
