package testcase;

import base.BaseLogin;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.ReadXLSData;
import utilities.commons;

import java.io.IOException;
import java.util.List;

public class ProgramFundCreationTest extends BaseLogin {


    @Test(dataProviderClass = ReadXLSData.class, dataProvider = "openg2pdata")
    public static void groupProgramFundCreation(String programName, String amount) throws IOException, InterruptedException {
        login();
        commons.click(driver, By.xpath(locators.getProperty("menu_option")));
        commons.click(driver, By.xpath(locators.getProperty("programs")));
        commons.click(driver, By.xpath(locators.getProperty("accounting")));
        commons.click(driver, By.xpath(locators.getProperty("program_funds")));
        commons.click(driver, By.xpath(locators.getProperty("program_fund_create_button")));
        commons.click(driver, By.xpath(locators.getProperty("program_fund_program_dropdown")));
        By dropdownLocator = By.xpath("//ul[@class='ui-menu ui-widget ui-widget-content ui-autocomplete dropdown-menu ui-front']//li");
        commons.dropDownByValue(driver, dropdownLocator, programName);
        commons.clearAndEnter(driver,By.xpath(locators.getProperty("fund_amount")),amount);
        Thread.sleep(1000);
        commons.click(driver,By.name(locators.getProperty("post_program_fund")));



    }

    @Test(dataProviderClass = ReadXLSData.class, dataProvider = "openg2pdata")
    public static void individualProgramFundCreation(String programName, String amount) throws IOException, InterruptedException {
        login();
        commons.click(driver, By.xpath(locators.getProperty("menu_option")));
        commons.click(driver, By.xpath(locators.getProperty("programs")));
        commons.click(driver, By.xpath(locators.getProperty("accounting")));
        commons.click(driver, By.xpath(locators.getProperty("program_funds")));
        commons.click(driver, By.xpath(locators.getProperty("program_fund_create_button")));
        By dropdownLocator = By.xpath("//ul[@class='ui-menu ui-widget ui-widget-content ui-autocomplete dropdown-menu ui-front']//li");
        commons.dropDownByValue(driver, dropdownLocator, programName);
        commons.clearAndEnter(driver,By.xpath(locators.getProperty("fund_amount")),amount);
        commons.click(driver,By.name(locators.getProperty("post_program_fund")));

    }
}