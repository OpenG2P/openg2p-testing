package base;//package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.*;
import utilities.TestLogger;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;

public class DriverCreator {

    public static WebDriver driver;
    public static Properties properties = new Properties();
    public static Properties locators = new Properties();
    public static Properties headless = new Properties();

    public static FileReader fileReader1;
    public static FileReader fileReader2;
    public  static  FileReader fileReader3;

  @BeforeMethod
    public void setUp(Method m) throws IOException {

      if (driver == null) {
          fileReader1 = new FileReader("testconfig/configfile/config.properties");
          fileReader2 = new FileReader("src/main/resources/configfiles/locators.properties");
          fileReader3 = new FileReader("testconfig/configfile/headless.properties");
          properties.load(fileReader1);
          locators.load(fileReader2);
          headless.load(fileReader3);
      }

      if (properties.getProperty("browser").equalsIgnoreCase("chrome")) {
          ChromeOptions options = new ChromeOptions();
          if (headless.getProperty("headless").equalsIgnoreCase("true")) {
              options.addArguments("--headless");
          }
          WebDriverManager.chromedriver().setup();
          driver = new ChromeDriver(options);
      } else if (properties.getProperty("browser").equalsIgnoreCase("firefox")) {
          FirefoxOptions options = new FirefoxOptions();
          if (headless.getProperty("headless").equalsIgnoreCase("true")) {
              options.addArguments("--headless");
          }
          WebDriverManager.firefoxdriver().setup();
          driver = new FirefoxDriver(options);
      } else if (properties.getProperty("browser").equalsIgnoreCase("edge")) {
          EdgeOptions options = new EdgeOptions();
          if (headless.getProperty("headless").equalsIgnoreCase("true")) {
              options.addArguments("--headless");
          }
          WebDriverManager.edgedriver().setup();
          driver = new EdgeDriver(options);
      }

      driver.get(properties.getProperty("openg2purl"));
      driver.manage().window().maximize();

      TestLogger.info("STARTING TEST: " + m.getName());
      TestLogger.info("THREAD ID: " + Thread.currentThread().getId());
  }



    @AfterMethod
    public void tearDown() {

        driver.close();
    }
}
//import io.github.bonigarcia.wdm.WebDriverManager;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//import utilities.TestLogger;
//
//import java.io.FileReader;
//import java.lang.reflect.Method;
//import java.util.Properties;
//
//public class DriverCreator {
//    public static WebDriver driver;
//    public static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();
//    public static Properties properties = new Properties();
//    public static Properties locators = new Properties();
//    public static Properties headless = new Properties();
//
//    @BeforeMethod
//    public void setUp(Method m) throws Exception {
//        if (driverThreadLocal.get() == null) {
//            properties.load(new FileReader("testconfig/configfile/config.properties"));
//            locators.load(new FileReader("src/main/resources/configfiles/locators.properties"));
//            headless.load(new FileReader("testconfig/configfile/headless.properties"));
//
//            WebDriver driver = createDriver();
//            driverThreadLocal.set(driver);
//        }
//
//        TestLogger.info("STARTING TEST: " + m.getName());
//        TestLogger.info("THREAD ID: " + Thread.currentThread().getId());
//    }
//
//    @AfterMethod
//    public void tearDown() {
//        WebDriver driver = driverThreadLocal.get();
//        if (driver != null) {
//            driver.quit();
//            driverThreadLocal.remove();
//        }
//    }
//
//    public static WebDriver getDriver() {
//        return driverThreadLocal.get();
//    }
//
//    private WebDriver createDriver() {
//        WebDriver driver = null;
//        String browser = properties.getProperty("browser");
//        if (browser.equalsIgnoreCase("chrome")) {
//            ChromeOptions options = new ChromeOptions();
//            if (headless.getProperty("headless").equalsIgnoreCase("true")) {
//                options.addArguments("--headless");
//            }
//            WebDriverManager.chromedriver().setup();
//            driver = new ChromeDriver(options);
//        } else if (browser.equalsIgnoreCase("firefox")) {
//            // Add Firefox driver setup logic here
//        } else if (browser.equalsIgnoreCase("edge")) {
//            // Add Edge driver setup logic here
//        }
//        return driver;
//    }
//}
