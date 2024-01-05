package testcase;

import base.BaseLogin;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ReadXLSData;
import utilities.commons;

import java.io.IOException;

public class ProgramCreationTest extends BaseLogin {

    @Test(dataProviderClass = ReadXLSData.class,dataProvider = "openg2pdata")
    public static void groupProgramCreation(String programName, String amountPerCycle) throws IOException, InterruptedException {
        login();
        commons.click(driver, By.xpath(locators.getProperty("menu_option")));
        commons.click(driver,By.xpath(locators.getProperty("programs")));
        commons.click(driver,By.xpath(locators.getProperty("create_program_button")));
        commons.enter(driver,By.xpath(locators.getProperty("program_name")),programName);
        commons.click(driver,By.xpath(locators.getProperty("configure_the_cycle_manager")));
        commons.click(driver,By.name(locators.getProperty("auto_approve_entitlement")));
        commons.dropdown(driver,By.xpath(locators.getProperty("cycle_approver_group")));
        commons.click(driver,By.xpath(locators.getProperty("configure_the_entitlement_manager")));
        commons.clearAndEnter(driver,By.xpath(locators.getProperty("amount_per_cycle")),amountPerCycle);
        commons.dropdown(driver,By.xpath(locators.getProperty("entitlement_validation_group")));
        commons.click(driver,By.name(locators.getProperty("program_create_button")));
        commons.click(driver,By.xpath(locators.getProperty("programs_list_view")));
        String tableXPath = "//table[@class='o_list_table table table-sm table-hover table-striped o_list_table_ungrouped']";
        Thread.sleep(2000);
        boolean entryFound = commons.isEntryPresentInPaginatedTable(driver, tableXPath, programName);
        Assert.assertTrue(entryFound, "Expected entry with text '" + programName + "' not found");
    }

    @Test(dataProviderClass = ReadXLSData.class,dataProvider = "openg2pdata")
    public static void individualProgramCreation(String programName,String amountPerCycle) throws IOException, InterruptedException {
        login();
        commons.click(driver, By.xpath(locators.getProperty("menu_option")));
        commons.click(driver,By.xpath(locators.getProperty("programs")));
        commons.click(driver,By.xpath(locators.getProperty("create_program_button")));
        commons.enter(driver,By.xpath(locators.getProperty("program_name")),programName);
        WebElement radioButton = driver.findElement(By.xpath(locators.getProperty("target_type_individual")));
        if (!radioButton.isSelected()) {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", radioButton);
        }
        commons.click(driver,By.xpath(locators.getProperty("configure_the_cycle_manager")));
        commons.click(driver,By.name(locators.getProperty("auto_approve_entitlement")));
        commons.dropdown(driver,By.xpath(locators.getProperty("cycle_approver_group")));
        commons.click(driver,By.xpath(locators.getProperty("configure_the_entitlement_manager")));
        commons.clearAndEnter(driver,By.xpath(locators.getProperty("amount_per_cycle")),amountPerCycle);
        commons.dropdown(driver,By.xpath(locators.getProperty("entitlement_validation_group")));
        commons.click(driver,By.name(locators.getProperty("program_create_button")));
        commons.click(driver,By.xpath(locators.getProperty("programs_list_view")));
        String tableXPath = "//table[@class='o_list_table table table-sm table-hover table-striped o_list_table_ungrouped']";
        Thread.sleep(2000);
        boolean entryFound = commons.isEntryPresentInPaginatedTable(driver, tableXPath, programName);
        Assert.assertTrue(entryFound, "Expected entry with text '" + programName + "' not found");

    }
}
