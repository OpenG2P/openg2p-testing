package testcase;

import base.BaseLogin;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ReadXLSData;
import utilities.commons;

import java.io.IOException;

public class G2PConnectPaymentManagerTest extends BaseLogin {

    @Test(dataProviderClass = ReadXLSData.class,dataProvider = "openg2pdata")
    public static void g2pConnectPaymentManagerCreation(String managerName, String programName, String paymentEndpointURL,String statusEndpointURL, String idType) throws IOException, InterruptedException {
        login();
        commons.click(driver, By.xpath(locators.getProperty("menu_option")));
        commons.click(driver, By.xpath(locators.getProperty("programs")));
        commons.click(driver,By.xpath(locators.getProperty("programs_configurations")));
        commons.click(driver,By.xpath(locators.getProperty("g2p_connect_payment_manager")));
        commons.click(driver,By.xpath(locators.getProperty("create_button")));
        commons.enter(driver,By.xpath(locators.getProperty("g2p_connect_manager_name")),managerName);
        commons.click(driver,By.name(locators.getProperty("programs_dropdown")));
        By dropdownLocator = By.xpath("//ul[@class='ui-menu ui-widget ui-widget-content ui-autocomplete dropdown-menu ui-front']//li");
        commons.dropDownByValue(driver, dropdownLocator, programName);
        commons.enter(driver,By.name(locators.getProperty("payment_endpoint_url")),paymentEndpointURL);
        commons.enter(driver,By.name(locators.getProperty("status_endpoint_url")),statusEndpointURL);
        commons.click(driver,By.name(locators.getProperty("status_check_crone_enabled_checkbox")));
        commons.click(driver,By.name(locators.getProperty("payee_id_field")));
        By payeeIdfiled = By.xpath("//select[@class='o_input o_field_widget o_quick_editable o_required_modifier']//option");
        commons.dropDownByValue(driver,payeeIdfiled,"Registrant ID");
        commons.click(driver,By.name(locators.getProperty("id_type_for_payee_id")));
        By idTypelist = By.xpath("//ul[@class='ui-menu ui-widget ui-widget-content ui-autocomplete dropdown-menu ui-front']//li");
        commons.dropDownByValue(driver,idTypelist,idType);
        commons.enter(driver,By.name(locators.getProperty("payee_prefix")),"token:");
        commons.enter(driver,By.name(locators.getProperty("payee_suffix")),"@nationalid");
        commons.enter(driver,By.xpath(locators.getProperty("local_lang")),"eng");
        commons.click(driver,By.xpath(locators.getProperty("save_button")));
        commons.click(driver,By.xpath(locators.getProperty("g2p_connect_manager_list_view")));
        String tableXPath = "//table[@class='o_list_table table table-sm table-hover table-striped o_list_table_ungrouped']";
        boolean entryFound = commons.isEntryPresentInPaginatedTable(driver, tableXPath, managerName);
        Assert.assertTrue(entryFound, "Expected entry with text '" + managerName + "' not found");

    }

    @Test
    public static void g2pConnectPaymentManagerMapping(String programName,String managerName) throws IOException, InterruptedException {
        login();
        commons.click(driver, By.xpath(locators.getProperty("menu_option")));
        commons.click(driver, By.xpath(locators.getProperty("programs")));
        String tableXPath = "";
        Thread.sleep(2000);
        WebElement entryFound = commons.getEntryElement(driver, tableXPath, programName);
        entryFound.click();
        commons.click(driver,By.xpath(locators.getProperty("program_configuration")));
        commons.click(driver,By.xpath(locators.getProperty("remove_default_payment_manager")));
        commons.click(driver,By.xpath(locators.getProperty("payment_manager_add_a_line_button")));
        commons.click(driver,By.xpath(locators.getProperty("add_manager_create_button")));
        commons.click(driver,By.xpath(locators.getProperty("manager_type_dropdown")));
        By managerTypes = By.xpath("//select[@class='o_input o_field_widget']//option");
        commons.dropDownByValue(driver,managerTypes,"Payment Interoperability Layer");
        commons.click(driver,By.xpath(locators.getProperty("manager_name_dropdown")));
        By managerNames = By.xpath("//ul[@class='ui-menu ui-widget ui-widget-content ui-autocomplete dropdown-menu ui-front']//li");
        commons.dropDownByValue(driver,managerNames,managerName);
        commons.click(driver,By.xpath(locators.getProperty("save_and_close_button")));
        commons.click(driver,By.xpath(locators.getProperty("save_button")));

    }
}
