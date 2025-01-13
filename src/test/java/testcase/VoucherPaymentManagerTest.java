package testcase;

import base.BaseLogin;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.commons;

import java.io.IOException;

public class VoucherPaymentManagerTest extends BaseLogin {

    @Test
    public static void voucherPaymentManagerCreation(String managerName, String programName,String amountPerCycle,String configFileName) throws IOException, InterruptedException {
        login();
        commons.click(driver, By.xpath(locators.getProperty("menu_option")));
        commons.click(driver, By.xpath(locators.getProperty("programs")));
        commons.click(driver,By.xpath(locators.getProperty("programs_configurations")));
        commons.click(driver,By.xpath(locators.getProperty("voucher_payment_manager")));
        commons.click(driver,By.xpath(locators.getProperty("voucher_payment_manager_create_button")));
        commons.enter(driver,By.xpath(locators.getProperty("voucher_manager_name")),managerName);
        commons.click(driver,By.name(locators.getProperty("programs_dropdown")));
        By programList = By.xpath("//ul[@class='ui-menu ui-widget ui-widget-content ui-autocomplete dropdown-menu ui-front']//li");
        commons.dropDownByValue(driver, programList, programName);
        commons.clearAndEnter(driver,By.xpath(locators.getProperty("amount_per_cycle")),amountPerCycle);
        commons.click(driver,By.xpath(locators.getProperty("entitlement_validation_group")));
        By validationGroupList = By.xpath("//ul[@class='ui-menu ui-widget ui-widget-content ui-autocomplete dropdown-menu ui-front']//li");
        commons.dropDownByValue(driver,validationGroupList,"OpenG2P Module Access / Administrator");
        commons.click(driver,By.xpath(locators.getProperty("voucher_file_config")));
        By voucherFileList = By.xpath("//ul[@class='ui-menu ui-widget ui-widget-content ui-autocomplete dropdown-menu ui-front']//li");
        commons.dropDownByValue(driver,voucherFileList,configFileName);
        commons.click(driver,By.xpath(locators.getProperty("voucher_document_store")));
        By documentSToreList = By.xpath("//ul[@class='ui-menu ui-widget ui-widget-content ui-autocomplete dropdown-menu ui-front']//li");
        commons.dropDownByValue(driver,documentSToreList,"Default S3 Document Store");
        commons.click(driver,By.xpath(locators.getProperty("voucher_manager_save_button")));
        commons.click(driver,By.xpath(locators.getProperty("voucher_manager_list_view")));
        String tableXPath = "//table[@class='o_list_table table table-sm table-hover table-striped o_list_table_ungrouped']";
        boolean entryFound = commons.isEntryPresentInPaginatedTable(driver, tableXPath, managerName);
        Assert.assertTrue(entryFound, "Expected entry with text '" + managerName + "' not found");
    }

    @Test()
    public static void voucherPaymentManagerMapping(String programName, String managerName) throws IOException, InterruptedException {
        login();
        commons.click(driver, By.xpath(locators.getProperty("menu_option")));
        commons.click(driver, By.xpath(locators.getProperty("programs")));
        String tableXPath = "";
        Thread.sleep(2000);
        WebElement entryFound = commons.getEntryElement(driver, tableXPath, programName);
        if (entryFound != null) {
            entryFound.click();
        }
        commons.click(driver,By.xpath(locators.getProperty("program_configuration")));
        commons.click(driver,By.xpath(locators.getProperty("remove_default_entitlement_manager")));
        commons.click(driver,By.xpath(locators.getProperty("entitlement_manager_add_a_line_button")));
        commons.click(driver,By.xpath(locators.getProperty("add_manager_create_button")));
        commons.click(driver,By.xpath(locators.getProperty("manager_type_dropdown")));
        By managerTypes = By.xpath("//select[@class='o_input o_field_widget']//option");
        commons.dropDownByValue(driver,managerTypes,"Voucher");
        commons.click(driver,By.xpath(locators.getProperty("manager_name_dropdown")));
        By managerNames = By.xpath("//ul[@class='ui-menu ui-widget ui-widget-content ui-autocomplete dropdown-menu ui-front']//li");
        commons.dropDownByValue(driver,managerNames,managerName);
        commons.click(driver,By.xpath(locators.getProperty("save_and_close_button")));
        commons.click(driver,By.xpath(locators.getProperty("save_button")));
    }
}
