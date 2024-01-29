package testcase;

import base.BaseLogin;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ReadXLSData;
import utilities.commons;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class RegistryIndividualPageTest extends BaseLogin {


    @Test(dataProviderClass = ReadXLSData.class,dataProvider = "openg2pdata")
    public static void individualCreation(String familyName, String firstName, String additionalName, String address, String email, String dateOfBirth) throws IOException, InterruptedException {
    login();
        Thread.sleep(2000);
        commons.click(driver,By.xpath(locators.getProperty("registry_individual")));
        commons.click(driver,By.xpath(locators.getProperty("individual_create_button")));
        commons.enter(driver,By.name(locators.getProperty("family_name_field")),familyName);
        commons.enter(driver,By.name(locators.getProperty("first_name_field")),firstName);
        commons.enter(driver,By.name(locators.getProperty("additional_name_field")),additionalName);
        commons.enter(driver,By.xpath(locators.getProperty("individual_address_field")),address);
        commons.enter(driver,By.xpath(locators.getProperty("individual_email_field")),email);
//        commons.dropdown(driver,By.name(locators.getProperty("individual_notification_preference")));
//        commons.click(driver,By.xpath(locators.getProperty("selecting_notification_preference")));
        commons.enter(driver,By.xpath(locators.getProperty("individual_date_of_birth")),dateOfBirth);
//        commons.click(driver,By.xpath(locators.getProperty("gender")));
//        commons.click(driver,By.xpath(locators.getProperty("gender_value")));
        commons.click(driver,By.xpath(locators.getProperty("save_individual")));
        commons.click(driver,By.xpath(locators.getProperty("individuals")));
//        List<String> expectedTexts = Arrays.asList(familyName,firstName);
//        String tableXPath = "//table[@class='o_list_table table table-sm table-hover table-striped o_list_table_ungrouped']";
//
//        boolean entryFound = commons.isEntryPresentInPaginatedTable(driver, tableXPath, expectedTexts.toString());
//        Assert.assertTrue(entryFound, "Expected entry with text '" + expectedTexts + "' not found");


    }




}
