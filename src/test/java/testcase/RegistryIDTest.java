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
public class RegistryIDTest extends BaseLogin {

    @Test(dataProviderClass = ReadXLSData.class,dataProvider = "openg2pdata")
    public static void idTypeCreation(String idType) throws IOException, InterruptedException {
        login();
        commons.click(driver, By.xpath(locators.getProperty("registry_configuration")));
        commons.click(driver,By.xpath(locators.getProperty("id_type")));
        commons.click(driver,By.xpath(locators.getProperty("id_type_create_button")));
        commons.enter(driver,By.xpath(locators.getProperty("id_type_data_input")),idType);
        commons.click(driver,By.xpath(locators.getProperty("id_type_save_button")));
        String tableXPath = "//table[@class='o_list_table table table-sm table-hover table-striped o_list_table_ungrouped']";

        boolean entryFound = commons.isEntryPresentInPaginatedTable(driver, tableXPath, idType);
        Assert.assertTrue(entryFound, "Expected entry with text '" + idType + "' not found");
        Thread.sleep(3000);
    }

}

