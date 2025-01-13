package testcase;

import base.BaseLogin;
import listener.TestListeners;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.ReadXLSData;
import utilities.commons;
import java.io.IOException;

@Listeners(TestListeners.class)
@Test
public class FlowTest extends BaseLogin {

    @Test(dataProviderClass = ReadXLSData.class,dataProvider = "openg2pdata")
    public static void cashAndG2PConnectFlow(String programName) throws IOException, InterruptedException {
        login();
        commons.click(driver, By.xpath(locators.getProperty("menu_option")));
        commons.click(driver, By.xpath(locators.getProperty("programs")));
        String tableXPath = "//table[@class='o_list_table table table-sm table-hover table-striped o_list_table_ungrouped']";
        Thread.sleep(2000);
        WebElement entryFound = commons.getEntryElement(driver, tableXPath, programName);
        entryFound.click();
        commons.click(driver,By.name(locators.getProperty("enroll_eligible_registrants")));
        commons.click(driver,By.name(locators.getProperty("verify_eligibility")));
        commons.click(driver,By.name(locators.getProperty("verify_eligibility")));
        commons.click(driver,By.name(locators.getProperty("deduplicate")));
        commons.click(driver,By.name(locators.getProperty("create_new_cycle")));
        commons.click(driver,By.xpath(locators.getProperty("cycle_form_navigator")));
        commons.click(driver,By.name(locators.getProperty("prepare_entitlement")));
        commons.click(driver,By.name(locators.getProperty("to_approve")));
        commons.click(driver,By.name(locators.getProperty("approve")));
        commons.click(driver,By.name(locators.getProperty("prepare_payment")));
        commons.click(driver,By.name(locators.getProperty("send_payment")));
        commons.click(driver,By.name(locators.getProperty("payment_section")));
        WebElement statusCell = driver.findElement(By.xpath("//table[@class='o_list_table table table-sm table-hover table-striped o_list_table_ungrouped']//tr[1]//td[15]//span"));
        String actualStatus = statusCell.getText();
        Assert.assertEquals(actualStatus, "Paid", "Status doesn't match!");
    }

    @Test
    public static void voucherPaymentFlow(String programName) throws IOException, InterruptedException {
        login();
        commons.click(driver, By.xpath(locators.getProperty("menu_option")));
        commons.click(driver, By.xpath(locators.getProperty("programs")));
        String tableXPath = "//table[@class='o_list_table table table-sm table-hover table-striped o_list_table_ungrouped']";
        Thread.sleep(2000);
        WebElement entryFound = commons.getEntryElement(driver, tableXPath, programName);
        entryFound.click();
        commons.click(driver,By.name(locators.getProperty("enroll_eligible_registrants")));
        commons.click(driver,By.name(locators.getProperty("verify_eligibility")));
        commons.click(driver,By.name(locators.getProperty("verify_eligibility")));
        commons.click(driver,By.name(locators.getProperty("deduplicate")));
        commons.click(driver,By.name(locators.getProperty("create_new_cycle")));
        commons.click(driver,By.xpath(locators.getProperty("cycle_form_navigator")));
        commons.click(driver,By.name(locators.getProperty("prepare_entitlement")));
        commons.click(driver,By.name(locators.getProperty("to_approve")));
        commons.click(driver,By.name(locators.getProperty("approve")));
    }
}
