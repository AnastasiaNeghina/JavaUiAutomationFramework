package com.opencart.managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.Locale;

public class DriverManager {
    //    Declaram 3 proprietati private: webDriverType, instance si driver
    private static String webDriverType = "Chrome";
    private static DriverManager instance;
    private WebDriver driver;

    //    Declaram constructorul clasei de tip private
    private DriverManager() {
        switch (webDriverType.toUpperCase()) {
            case "CHROME":
                driver = new ChromeDriver();
                System.out.println("The Chrome Driver was initiated!");
                break;
            case "FIREFOX":
                driver = new FirefoxDriver();
                System.out.println("The Firefox Driver was initiated!");
                break;
            case "EDGE":
                driver = new EdgeDriver();
                System.out.println("The Edge Driver was initiated!");
                break;
            case "SAFARI":
                driver = new SafariDriver();
                System.out.println("The Safari Driver was initiated!");
                break;
            default:
                System.out.println("There is not defined such a driver: " + webDriverType);
        }
    }

    //    Metoda statica pentru a obtine instanta Singleton - singura instanta a clasei, accesibila in mod global
    public static DriverManager getInstance() {
        if (instance == null) {
            instance = new DriverManager();
        }
        return instance;
    }

    //    Metoda publica pentru a obtine driverul web
    public WebDriver getDriver() {
        if (driver == null) {
            getInstance();
        }
        return driver;
    }
}

