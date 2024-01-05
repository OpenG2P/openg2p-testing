package testcase;

import base.BaseLogin;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ReadXLSData;
import utilities.commons;

import java.io.IOException;

public class GSMAMoneyPaymentManagerTest extends BaseLogin {

    @Test(dataProviderClass = ReadXLSData.class,dataProvider = "openg2pdata")
    public static void gsmaMoneyPaymentManagerCreation(String managerName, String programName, String authenticationEndpointURL, String paymentEndPointURL, String email,String password) throws IOException, InterruptedException {
        login();
        commons.click(driver, By.xpath(locators.getProperty("menu_option")));
        commons.click(driver, By.xpath(locators.getProperty("programs")));
        commons.click(driver,By.xpath(locators.getProperty("programs_configurations")));
        commons.click(driver,By.xpath(locators.getProperty("dbt_payment_manager")));
        commons.click(driver,By.xpath(locators.getProperty("dbt_payment_manager_create_button")));
        commons.enter(driver,By.xpath(locators.getProperty("dbt_manager_name")),managerName);
        commons.click(driver,By.name(locators.getProperty("programs_dropdown")));
        By dropdownLocator = By.xpath("//ul[@class='ui-menu ui-widget ui-widget-content ui-autocomplete dropdown-menu ui-front']//li");
        commons.dropDownByValue(driver, dropdownLocator, programName);
        commons.enter(driver,By.name(locators.getProperty("authentication_endpoint_url")),authenticationEndpointURL);
        commons.enter(driver,By.xpath(locators.getProperty("payment_endpoint_url")),paymentEndPointURL);
        commons.enter(driver,By.xpath(locators.getProperty("gsma_email")),email);
        commons.enter(driver,By.xpath(locators.getProperty("gsma_password")),password);
        commons.click(driver,By.xpath(locators.getProperty("payee_id_field")));
        By payeeIdfiled = By.xpath("//select[@class='o_input o_field_widget o_quick_editable o_required_modifier']//option");
        commons.dropDownByValue(driver,payeeIdfiled,"Email");
        commons.click(driver,By.xpath(locators.getProperty("gsma_money_manager_save_button")));
        commons.click(driver,By.xpath(locators.getProperty("gsma_money_manager_list_view")));
        String tableXPath = "//table[@class='o_list_table table table-sm table-hover table-striped o_list_table_ungrouped']";
        boolean entryFound = commons.isEntryPresentInPaginatedTable(driver, tableXPath, managerName);
        Assert.assertTrue(entryFound, "Expected entry with text '" + managerName + "' not found");
    }

    @Test
    public static void gsmaMoneyPaymentManagerMapping(String programName, String managerName) throws IOException, InterruptedException {
        login();
        commons.click(driver, By.xpath(locators.getProperty("menu_option")));
        commons.click(driver, By.xpath(locators.getProperty("programs")));
        String tableXPath = "";
        Thread.sleep(2000);
        WebElement entryFound = commons.getEntryElement(driver, tableXPath, programName);
        assert entryFound != null;
        entryFound.click();
        commons.click(driver,By.xpath(locators.getProperty("program_configuration")));
        commons.click(driver,By.xpath(locators.getProperty("remove_default_payment_manager")));
        commons.click(driver,By.xpath(locators.getProperty("payment_manager_add_a_line_button")));
        commons.click(driver,By.xpath(locators.getProperty("add_manager_create_button")));
        commons.click(driver,By.xpath(locators.getProperty("manager_type_dropdown")));
        By managerTypes = By.xpath("//select[@class='o_input o_field_widget']//option");
        commons.dropDownByValue(driver,managerTypes,"Simple MPesa Payment Manager");
        commons.click(driver,By.xpath(locators.getProperty("manager_name_dropdown")));
        By managerNames = By.xpath("//ul[@class='ui-menu ui-widget ui-widget-content ui-autocomplete dropdown-menu ui-front']//li");
        commons.dropDownByValue(driver,managerNames,managerName);
        commons.click(driver,By.xpath(locators.getProperty("save_and_close_button")));
        commons.click(driver,By.xpath(locators.getProperty("save_button")));
    }
}
