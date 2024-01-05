package testcase;

import base.BaseLogin;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ReadXLSData;
import utilities.commons;

import java.io.IOException;

public class GroupTypeTest extends BaseLogin {
    @Test(dataProviderClass = ReadXLSData.class,dataProvider = "openg2pdata")
    public static void groupTypeCreation(String kind) throws IOException, InterruptedException {
        login();
        commons.click(driver, By.xpath(locators.getProperty("registry_configuration")));
        commons.click(driver,By.xpath(locators.getProperty("group_type")));
        commons.click(driver,By.xpath(locators.getProperty("group_type_create_button")));
        commons.enter(driver,By.xpath(locators.getProperty("group_type_data_input")),kind);
        commons.click(driver,By.xpath(locators.getProperty("save_group_type")));
        String expectedText = kind;
        String tableXPath = "//table[@class='o_list_table table table-sm table-hover table-striped o_list_table_ungrouped']";
        boolean entryFound = commons.isEntryPresentInPaginatedTable(driver, tableXPath, expectedText);
        Assert.assertTrue(entryFound, "Expected entry with text '" + expectedText + "' not found");


    }
}
