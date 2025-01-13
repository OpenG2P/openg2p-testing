package testcase;

import base.BaseLogin;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import utilities.commons;

import java.io.IOException;

public class MTSConnectorTest extends BaseLogin {


    @Test
    public static void tokenizer(String mapping, String outputFormat, String filter, String listOfFields, String database, String username, String password) throws IOException, InterruptedException {
        login();
        commons.click(driver, By.xpath(locators.getProperty("menu_option")));
        commons.click(driver,By.xpath(locators.getProperty("create_button")));

        commons.enter(driver,By.xpath(locators.getProperty("connector_name")),"Tokenizer");
        commons.enter(driver,By.xpath(locators.getProperty("url_to_reach_mts")),"http://mosip-token-seeder.mosip-token-seeder");
        commons.click(driver,By.xpath(locators.getProperty("mts_input_type")));
        commons.click(driver, By.xpath(locators.getProperty("openg2p_registry")));
        commons.enter(driver,By.xpath(locators.getProperty("mapping")),mapping);
        commons.click(driver,By.xpath(locators.getProperty("mts_output_type")));
        commons.click(driver, By.xpath(locators.getProperty("json")));
        commons.enter(driver,By.xpath(locators.getProperty("mts_output_format")),outputFormat);
        commons.click(driver,By.xpath(locators.getProperty("mts_delivery_type")));
        commons.click(driver,By.xpath(locators.getProperty("callback")));
        commons.click(driver,By.xpath(locators.getProperty("job_type")));
        commons.click(driver,By.xpath(locators.getProperty("one_time")));
        commons.enter(driver,By.xpath(locators.getProperty("language")),"eng");
        commons.enter(driver,By.xpath(locators.getProperty("filters_to_apply_to_registry")),filter);
        commons.enter(driver,By.xpath(locators.getProperty("list_of_fields_to_be_used")),listOfFields);
        commons.enter(driver,By.xpath(locators.getProperty("start_time")),"");
        commons.enter(driver,By.xpath(locators.getProperty("end_time")),"");
        commons.enter(driver,By.xpath(locators.getProperty("callback_url")),"http://openg2p-odoo.openg2p/api/v1/registry/individual/updateidentification");
        commons.click(driver,By.xpath(locators.getProperty("callback_http_method")));
        commons.click(driver,By.xpath(locators.getProperty("patch")));
        commons.enter(driver,By.xpath(locators.getProperty("callback_timeout")),"10");
        commons.click(driver,By.xpath(locators.getProperty("callback_auth_type")));
        commons.click(driver,By.xpath(locators.getProperty("odoo")));
        commons.enter(driver,By.xpath(locators.getProperty("callback_auth_url")),"http://openg2p-odoo.openg2p/web/session/authenticate");
        commons.enter(driver,By.xpath(locators.getProperty("callback_auth_database")),database);
        commons.enter(driver,By.xpath(locators.getProperty("callback_auth_username")),username);
        commons.enter(driver,By.xpath(locators.getProperty("callback_auth_password")),password);


    }
}
