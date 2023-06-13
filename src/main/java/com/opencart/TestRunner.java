package com.opencart;

import com.opencart.managers.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;

public class TestRunner {
    public static void main(String[] args) throws InterruptedException {
//        se creează o variabilă manager, căreia i se atribuie valoarea returnată în urma apelării motodei getInst
        DriverManager manager = DriverManager.getInstance();
//        se obtine un obiect de tip WebDriver din instanta manager a clasei DriverManager
        WebDriver driver = manager.getDriver();

        String currentWindowName = driver.getWindowHandle();

        driver.switchTo().newWindow(WindowType.TAB);

        driver.get("https://github.com/AnastasiaNeghina/JavaUiAutomationFramework");
        Thread.sleep(2000);
        System.out.println("Access the pull pull request block, files changed and select approve!");
        driver.close();
        driver.switchTo().window(currentWindowName);
        manager.getDriver().get("https://maven.apache.org/download.cgi");
        driver.quit();
        System.out.println("The driver is closed!");
    }
}