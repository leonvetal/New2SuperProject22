package com.it.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import static com.it.common.Constants.BASE_URL;

public class DriverFactory {

    public static final String AUTOMATE_USERNAME = "bsuser7502162567";
    public static final String AUTOMATE_ACCESS_KEY = "muHzi1qoJ2ABayF1sbvn";
    public static final String URL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";

    public static WebDriver getDriver()  {
        WebDriver driver = null;

        String driverName = System.getProperty("driver");
        if (driverName != null) {
            if ("fireFox".equals(driverName)) {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            } else if ("ie".equals(driverName)) {
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
            } else if ("edge".equals(driverName)) {
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
            } else if ("Chrome".equals(driverName)) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            } else if ("BrSt".equals(driverName)) {
                DesiredCapabilities caps = new DesiredCapabilities();
                caps.setCapability("os_version", "XP");
                caps.setCapability("resolution", "1024x768");
                caps.setCapability("browser", "Chrome");
                caps.setCapability("browser_version", "48.0");
                caps.setCapability("os", "Windows");
                caps.setCapability("name", "BStack-[Java] Sample Test"); // test name
                caps.setCapability("build", "BStack Build Number 1"); // CI/CD job or build name
                try {
                    driver = new RemoteWebDriver(new URL(URL), caps);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }

            }
            else {
                throw new UnsupportedOperationException();
            }
        } else {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(BASE_URL);
        return driver;
    }
}
