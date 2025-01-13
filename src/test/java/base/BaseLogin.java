package base;//package base;


import org.openqa.selenium.By;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;


public class BaseLogin extends DriverCreator{

    public static Properties properties = new Properties();

    public static Properties locators = new Properties();

    public static FileReader fileReader1;
    public static FileReader fileReader2;

    public static void login() throws IOException, InterruptedException {

        fileReader1 = new FileReader("testconfig/configfile/config.properties");
        fileReader2 = new FileReader("src/main/resources/configfiles/locators.properties");
        properties.load(fileReader1);
        locators.load(fileReader2);
        Thread.sleep(2000);
        driver.findElement(By.id(locators.getProperty("username_field"))).sendKeys(properties.getProperty("username"));
        driver.findElement(By.id(locators.getProperty("password_field"))).sendKeys(properties.getProperty("password"));
        driver.findElement(By.xpath(locators.getProperty("login_button"))).click();
        Thread.sleep(5000);
    }
}


//
//import base.DriverCreator;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//
//import java.io.FileReader;
//import java.util.Properties;
//
//import static java.sql.DriverManager.getDriver;

//public class BaseLogin extends DriverCreator {
//    public static void login() throws Exception {
//        WebDriver driver = getDriver();
//        if (driver == null) {
//            throw new Exception("WebDriver instance is null");
//        }
//        Properties properties = new Properties();
//        properties.load(new FileReader("testconfig/configfile/config.properties"));
//        Properties locators = new Properties();
//        locators.load(new FileReader("src/main/resources/configfiles/locators.properties"));
//
//        driver.get(properties.getProperty("openg2purl"));
//        driver.manage().window().maximize();
//
//        Thread.sleep(2000);
//        driver.findElement(By.id(locators.getProperty("username_field"))).sendKeys(properties.getProperty("username"));
//        driver.findElement(By.id(locators.getProperty("password_field"))).sendKeys(properties.getProperty("password"));
//        driver.findElement(By.xpath(locators.getProperty("login_button"))).click();
//        Thread.sleep(5000);
//    }
//}
