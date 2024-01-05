package testcase;

import base.BaseLogin;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ReadXLSData;
import utilities.commons;

import java.io.IOException;

public class RelationshipsTest extends BaseLogin{
    @Test(dataProviderClass = ReadXLSData.class,dataProvider = "openg2pdata")
    public static void relationshipsCreation(String name, String inverseName) throws IOException, InterruptedException {
        login();
        commons.click(driver, By.xpath(locators.getProperty("registry_configuration")));
        commons.click(driver,By.xpath(locators.getProperty("relationship")));
        commons.click(driver,By.xpath(locators.getProperty("relationship_create_button")));
        commons.enter(driver,By.xpath(locators.getProperty("relationship_name_data_input")),name);
        commons.enter(driver,By.xpath(locators.getProperty("relationship_inverse_name_data_input")),inverseName);
        commons.click(driver,By.xpath(locators.getProperty("relationship_bidirectional_checkbox")));
        commons.dropdown(driver,By.xpath(locators.getProperty("source_partner_type_dropdown")));
        commons.dropdown(driver,By.xpath(locators.getProperty("destination_partner_type_dropdown")));
        commons.click(driver,By.xpath(locators.getProperty("save_relationship")));
        String expectedText = name;
        String tableXPath = "//table[@class='o_list_table table table-sm table-hover table-striped o_list_table_ungrouped']";

        boolean entryFound = commons.isEntryPresentInPaginatedTable(driver, tableXPath, expectedText);
        Assert.assertTrue(entryFound, "Expected entry with text '" + expectedText + "' not found");
        Thread.sleep(3000);
    }
}
