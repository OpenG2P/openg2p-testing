package testcase;

import base.BaseLogin;
import listener.TestListeners;
import org.apache.hc.core5.reactor.Command;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.NoInjection;
import org.testng.annotations.Test;
import utilities.ExtractedTextHolder;
import utilities.ReadXLSData;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.PriorityQueue;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.Select;
import utilities.commons;

import static utilities.ExtractedTextHolder.getItemName;
import static utilities.ExtractedTextHolder.itemName;
import static utilities.commons.click;

@Listeners(TestListeners.class)
@Test
public class RegistryGroupPageTest extends BaseLogin {




    @Test(priority = 1,dataProviderClass = ReadXLSData.class,dataProvider = "openg2pdata")
    public static void groupCreation(String groupName, String address, String phoneNumber, String email) throws IOException, InterruptedException {
        login();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        commons.click(driver,By.xpath(locators.getProperty("group_create_button")));
        commons.enter(driver,By.xpath(locators.getProperty("group_creation_name_field")),groupName);
        commons.click(driver,By.xpath(locators.getProperty("tags_dropdown")));
        commons.click(driver,By.xpath(locators.getProperty("contact_info_section")));
        commons.enter(driver,By.xpath(locators.getProperty("group_address_fields")),address);
//        commons.click(driver,By.xpath(locators.getProperty("add_line_group_phone_number")));
//        commons.click(driver,By.xpath(locators.getProperty("add_line_group_phone_number")));
//        commons.enter(driver,By.xpath(locators.getProperty("group_phone_number")),phoneNumber);
//        commons.click(driver,By.xpath(locators.getProperty("save_and_close_button")));
        commons.enter(driver,By.xpath(locators.getProperty("group_email_field")),email);
        commons.click(driver,By.xpath(locators.getProperty("group_save_button")));
        commons.click(driver,By.xpath(locators.getProperty("groups")));
        String tableXPath = "//table[@class='o_list_table table table-sm table-hover table-striped o_list_table_ungrouped']";
        Thread.sleep(2000);
        boolean entryFound = commons.isEntryPresentInPaginatedTable(driver, tableXPath, groupName);
        Assert.assertTrue(entryFound, "Expected entry with text '" + groupName + "' not found");
    }


//    @Test(priority = 1,dependsOnMethods = "groupCreation")
//    public static void archiveGroup( String groupName) throws IOException, InterruptedException {
//        login();
//        String tableXPath = "//table[@class='o_list_table table table-sm table-hover table-striped o_list_table_ungrouped']";
//        Thread.sleep(2000);
//        WebElement entryFound = commons.getEntryElement(driver, tableXPath, groupName);
//        entryFound.click();
//        commons.click(driver,By.xpath(locators.getProperty("action_button")));
//        commons.click(driver,By.linkText(locators.getProperty("archive_group")));
//        commons.click(driver,By.xpath(locators.getProperty("archive_confirmation")));
//        String expectedText = "Archived";
//        String pageSource = driver.getPageSource();
//        Assert.assertTrue(pageSource.contains(expectedText), "Expected text '" + expectedText + "' not found on the page.");
//    }
//
//    @Test(priority = 1,dataProviderClass = ReadXLSData.class,dataProvider = "openg2pdata")
//    public static void unarchiveGroup(String groupName) throws IOException, InterruptedException {
//        login();
//        commons.click(driver,By.xpath(locators.getProperty("filters")));
//        commons.click(driver,By.xpath(locators.getProperty("archived_option")));
//        commons.click(driver,By.xpath(locators.getProperty("search_bar")));
//        String tableXPath = "//table[@class='o_list_table table table-sm table-hover table-striped o_list_table_ungrouped']";
//        WebElement entryFound = commons.getEntryElement(driver, tableXPath, groupName);
//        Thread.sleep(3000);
//        entryFound.click();
//        commons.click(driver,By.xpath(locators.getProperty("action_button")));
//        commons.click(driver,By.linkText(locators.getProperty("unarchive_group")));
//        WebElement textElement = driver.findElement(By.xpath(locators.getProperty("archived")));
//        boolean isTextVisible = textElement.isDisplayed();
//        Assert.assertFalse(isTextVisible, "Expected text is not visible on the page.");
//
//    }

    @Test(priority = 2)
    public static void addGroupToProgram(String groupName) throws IOException, InterruptedException {
        login();
        String tableXPath = "//table[@class='o_list_table table table-sm table-hover table-striped o_list_table_ungrouped']";
        Thread.sleep(2000);
        WebElement entryFound = commons.getEntryElement(driver, tableXPath, groupName);
        assert entryFound != null;
        entryFound.click();
        commons.click(driver,By.xpath(locators.getProperty("action_button")));
        commons.click(driver,By.linkText(locators.getProperty("add_to_program_group")));
        commons.dropdown(driver,By.xpath(locators.getProperty("group_program_list")));
        Thread.sleep(2000);
        commons.click(driver,By.xpath(locators.getProperty("program_selection")));
        commons.click(driver,By.name(locators.getProperty("assign_registrant_group")));

    }
}
