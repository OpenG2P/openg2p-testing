package testcase;

import base.BaseLogin;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.ReadXLSData;
import utilities.commons;

import java.io.IOException;

public class DeduplicationManagerTest extends BaseLogin {

    @Test(dataProviderClass = ReadXLSData.class,dataProvider = "openg2pdata")
    public static void deduplicationManagerCreation(String deduplicationManagerName, String programName, String idType) throws IOException, InterruptedException {
        login();
        commons.click(driver, By.xpath(locators.getProperty("menu_option")));
        commons.click(driver, By.xpath(locators.getProperty("programs")));
        commons.click(driver,By.xpath(locators.getProperty("programs_configurations")));
        commons.click(driver,By.xpath(locators.getProperty("id_deduplication_manager")));
        commons.click(driver,By.xpath(locators.getProperty("create_id_deduplication_manager_button")));
        commons.enter(driver,By.xpath(locators.getProperty("id_deduplication_manager_name")),deduplicationManagerName);
        commons.click(driver,By.xpath(locators.getProperty("programs_dropdown")));
        By dropdownLocator = By.xpath("//ul[@class='ui-menu ui-widget ui-widget-content ui-autocomplete dropdown-menu ui-front']//li");
        commons.dropDownByValue(driver, dropdownLocator, programName);
        commons.click(driver,By.xpath(locators.getProperty("supported_id_document_type")));
        By idTypes = By.xpath("//ul[@class='ui-menu ui-widget ui-widget-content ui-autocomplete dropdown-menu ui-front'][2]//li");
        commons.dropDownByValue(driver,idTypes,idType);
        Thread.sleep(3000);
        commons.click(driver,By.xpath(locators.getProperty("deduplication_manager_save_button")));

    }


    @Test(dataProviderClass = ReadXLSData.class,dataProvider = "openg2pdata")
    public static void deduplicationManagerMapping(String programName,String deduplicationManagerName) throws IOException, InterruptedException {
        login();
        commons.click(driver, By.xpath(locators.getProperty("menu_option")));
        commons.click(driver, By.xpath(locators.getProperty("programs")));
        String tableXPath = "//table[@class='o_list_table table table-sm table-hover table-striped o_list_table_ungrouped']";
        Thread.sleep(2000);
        WebElement entryFound = commons.getEntryElement(driver, tableXPath, programName);
        entryFound.click();
        commons.click(driver,By.xpath(locators.getProperty("program_configuration")));
        commons.click(driver,By.xpath(locators.getProperty("remove_default_deduplication_manager")));
        Thread.sleep(1000);
        commons.click(driver,By.xpath(locators.getProperty("add_a_line_deduplication")));
        commons.click(driver,By.xpath(locators.getProperty("create_dedup_window_button")));
        commons.click(driver,By.xpath(locators.getProperty("dedup_manager_dropdown")));
        commons.click(driver,By.xpath(locators.getProperty("selecting_id_deduplication_manager")));
//        By managerDropdown = By.xpath("");
//        commons.dropDownByValue(driver,managerDropdown,"");
        commons.click(driver,By.xpath(locators.getProperty("manager_name_dropdown")));
        By managerNames = By.xpath("//ul[@class='ui-menu ui-widget ui-widget-content ui-autocomplete dropdown-menu ui-front']//li");
        commons.dropDownByValue(driver,managerNames,deduplicationManagerName);
        commons.click(driver,By.linkText(locators.getProperty("window_save_and_close_button")));
    }
}
