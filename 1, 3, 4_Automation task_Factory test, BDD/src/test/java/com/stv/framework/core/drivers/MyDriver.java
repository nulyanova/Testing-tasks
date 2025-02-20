package com.stv.framework.core.drivers;
// Версия 133.0.6943.99 (Официальная сборка), (64 бит)
// C:\Program Files\chromedriver-win64\chromedriver.exe

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MyDriver {
    public static WebDriver driver;

    public static void setChromeDriver() {
        System.setProperty("webdriver.chrome.driver", "C:/Program Files/chromedriver-win64/chromedriver.exe");

        // Дополнительные настройки Chrome
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver();
    }

    public static WebDriver getDriver() {

        if (driver == null) {
            setChromeDriver();
//            setFireFox();
        }
        return driver;
    }

    /* private static void setChromeDriver() {
//        String exePath = "C:\\Chromedriver\\chromedriver.exe";
//        System.setProperty("webdriver.chrome.driver", exePath);
//        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver();
    } */

    /**
     * The method can be used to run tests in Fire fox
     */
    private static void setFireFox() {
//        String exePath =  "C:\\drivers\\geckodriver.exe";
//        System.setProperty("webdriver.gecko.driver", exePath);
        driver = new FirefoxDriver();
    }
}