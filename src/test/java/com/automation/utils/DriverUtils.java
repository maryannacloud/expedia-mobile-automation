package com.automation.utils;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

public class DriverUtils {

    static AppiumDriver driver;

    // Method to create driver, and it will get called from Hooks @Before
    public static void createLocalDriver() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", ConfigReader.getProperty("platform.name"));
        capabilities.setCapability("appium:automationName", ConfigReader.getProperty("automation.name"));
        capabilities.setCapability("deviceName", ConfigReader.getProperty("device.name"));
        capabilities.setCapability("appium:app", System.getProperty("user.dir") + "\\" + ConfigReader.getProperty("apk.name"));

        driver = new AppiumDriver(capabilities);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
    }

    public static void createBrowserStackDriver() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
        browserstackOptions.put("projectName", "ExpediaTestAutomation");
        browserstackOptions.put("userName", ConfigReader.getProperty("browser.stack.username"));
        browserstackOptions.put("accessKey", ConfigReader.getProperty("browser.stack.access.key"));
        browserstackOptions.put("buildName", "regression-test");

        capabilities.setCapability("bstack:options", browserstackOptions);
        capabilities.setCapability("platformName", "android");
        capabilities.setCapability("platformVersion", "platform.version");
        capabilities.setCapability("deviceName", "browser.stack.device.name");
        capabilities.setCapability("app", "bs://ff2ca42ce31c6be97f9c00710510ded752be21cc");


        URL url = new URL(ConfigReader.getProperty("browser.stack.url"));
        driver = new AppiumDriver(url, capabilities);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

    }

    // Anywhere we need driver, we will call this method
    public static AppiumDriver getDriver() {
        return driver;
    }

    // This is created for testing purpose, we can create at any class to test our methods just like unit testing.
    public static void main(String[] args) {
        System.out.println(System.getProperty("os.name"));
        System.out.println(System.getProperty("user.dir"));
    }
}
