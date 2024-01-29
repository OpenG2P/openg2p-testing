package testcase;

import base.BaseLogin;
import listener.TestListeners;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.ReadXLSData;
import utilities.commons;

import java.io.IOException;
@Listeners(TestListeners.class)
@Test
public class GenderTypeTest extends BaseLogin {

    @Test(dataProviderClass = ReadXLSData.class,dataProvider = "openg2pdata")
    public static void genderTypeCreation(String code, String value) throws IOException, InterruptedException {
        login();
        commons.click(driver, By.xpath(locators.getProperty("registry_configuration")));
        commons.click(driver,By.xpath(locators.getProperty("gender_type")));
        commons.click(driver,By.xpath(locators.getProperty("gender_type_create_button")));
        commons.enter(driver,By.xpath(locators.getProperty("gender_type_data_input_code")),code);
        commons.enter(driver,By.xpath(locators.getProperty("gender_type_data_input_value")),value);
        commons.click(driver,By.xpath(locators.getProperty("gender_type_save_button")));
        String tableXPath = "//table[@class='o_list_table table table-sm table-hover table-striped o_list_table_ungrouped']";
        boolean entryFound = commons.isEntryPresentInPaginatedTable(driver, tableXPath, code);
        Assert.assertTrue(entryFound, "Expected entry with text '" + code + "' not found");
        Thread.sleep(2000);
    }
}
