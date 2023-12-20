package base;

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
          fileReader1 = new FileReader("openg2p-testing\\testconfig\\configfile\\config.properties");
          fileReader2 = new FileReader("openg2p-testing\\src\\main\\resources\\configfiles\\locators.properties");
          fileReader3 = new FileReader("openg2p-testing\\testconfig\\configfile\\headless.properties");
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

      driver.get(properties.getProperty("testurl"));
      driver.manage().window().maximize();

      TestLogger.info("STARTING TEST: " + m.getName());
      TestLogger.info("THREAD ID: " + Thread.currentThread().getId());
  }



    @AfterMethod
    public void tearDown() {

        driver.close();
    }
}
