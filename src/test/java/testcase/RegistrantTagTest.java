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
public class RegistrantTagTest extends BaseLogin {

    @Test(dataProviderClass = ReadXLSData.class,dataProvider = "openg2pdata")
    public static void registrantTagCreation(String registrantTag) throws IOException, InterruptedException {
        login();
        commons.click(driver, By.xpath(locators.getProperty("registry_configuration")));
        commons.click(driver,By.xpath(locators.getProperty("registrant_tags")));
        commons.click(driver,By.xpath(locators.getProperty("registrant_tag_create_button")));
        commons.enter(driver,By.xpath(locators.getProperty("registrant_tag_data_input")),registrantTag);
        commons.click(driver,By.xpath(locators.getProperty("save_registrant_tag")));
        String tableXPath = "//table[@class='o_list_table table table-sm table-hover table-striped o_list_table_ungrouped']";
        boolean entryFound = commons.isEntryPresentInPaginatedTable(driver, tableXPath, registrantTag);
        Assert.assertTrue(entryFound, "Expected entry with text '" + registrantTag + "' not found");
        Thread.sleep(3000);


    }
}
