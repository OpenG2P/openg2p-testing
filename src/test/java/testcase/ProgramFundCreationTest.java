package testcase;

import base.BaseLogin;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ReadXLSData;
import utilities.commons;

import java.io.IOException;
import java.util.List;

public class ProgramFundCreationTest extends BaseLogin {


    @Test(dataProviderClass = ReadXLSData.class, dataProvider = "openg2pdata")
    public static void groupProgramFundCreation(String programName) throws IOException, InterruptedException {
        login();
        commons.click(driver, By.xpath(locators.getProperty("menu_option")));
        commons.click(driver, By.xpath(locators.getProperty("programs")));
        commons.click(driver, By.xpath(locators.getProperty("accounting")));
        commons.click(driver, By.xpath(locators.getProperty("program_funds")));
        commons.click(driver, By.xpath(locators.getProperty("program_fund_create_button")));
        commons.click(driver, By.xpath(locators.getProperty("program_fund_program_dropdown")));
        By dropdownLocator = By.xpath("//ul[@class='ui-menu ui-widget ui-widget-content ui-autocomplete dropdown-menu ui-front']//li");
        commons.dropDownByValue(driver, dropdownLocator, programName);
        commons.clearAndEnter(driver,By.xpath(locators.getProperty("fund_amount")),"10000000");
        Thread.sleep(1000);
        commons.click(driver,By.name(locators.getProperty("post_program_fund")));
        commons.click(driver,By.xpath(locators.getProperty("breadcrumb_button")));
        String tableXPath = "//table[@class='o_list_table table table-sm table-hover table-striped o_list_table_ungrouped']";
        Thread.sleep(2000);
        boolean entryFound = commons.isEntryPresentInPaginatedTable(driver, tableXPath, programName);
        Assert.assertTrue(entryFound, "Expected entry with text '" + programName + "' not found");


    }

    @Test(dataProviderClass = ReadXLSData.class, dataProvider = "openg2pdata")
    public static void individualProgramFundCreation(String programName) throws IOException, InterruptedException {
        login();
        commons.click(driver, By.xpath(locators.getProperty("menu_option")));
        commons.click(driver, By.xpath(locators.getProperty("programs")));
        commons.click(driver, By.xpath(locators.getProperty("accounting")));
        commons.click(driver, By.xpath(locators.getProperty("program_funds")));
        commons.click(driver, By.xpath(locators.getProperty("program_fund_create_button")));
        commons.click(driver, By.xpath(locators.getProperty("program_fund_program_dropdown")));
        By dropdownLocator = By.xpath("//ul[@class='ui-menu ui-widget ui-widget-content ui-autocomplete dropdown-menu ui-front']//li");
        commons.dropDownByValue(driver, dropdownLocator, programName);
        commons.clearAndEnter(driver,By.xpath(locators.getProperty("fund_amount")),"10000000");
        Thread.sleep(1000);
        commons.click(driver,By.name(locators.getProperty("post_program_fund")));
        commons.click(driver,By.xpath(locators.getProperty("breadcrumb_button")));
        String tableXPath = "//table[@class='o_list_table table table-sm table-hover table-striped o_list_table_ungrouped']";
        Thread.sleep(2000);
        boolean entryFound = commons.isEntryPresentInPaginatedTable(driver, tableXPath, programName);
        Assert.assertTrue(entryFound, "Expected entry with text '" + programName + "' not found");
    }
}