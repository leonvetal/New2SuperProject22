package com.it.pages;

import com.it.driver.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import static com.it.common.Constants.BASE_URL;

public abstract class BasePage {
    protected static WebDriver driver= DriverFactory.getDriver();


    public BasePage() {
        PageFactory.initElements(driver,this);
    }
}
