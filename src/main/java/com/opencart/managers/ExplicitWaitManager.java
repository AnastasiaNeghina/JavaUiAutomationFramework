package com.opencart.managers;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ExplicitWaitManager {

    private static Logger logger = LogManager.getLogger(ExplicitWaitManager.class);
    private static int explicitWaitPeriod = Integer.parseInt(ConfigReaderManager.getProperty("explicitWait"));
    private static WebDriverWait waitObject = new WebDriverWait(DriverManager.getInstance().getDriver(), Duration.ofSeconds(explicitWaitPeriod));

    public static void waitTillElementIsClickable(WebElement element) {
        logger.log(Level.INFO, "Waiting till the web element [" + element.getAccessibleName() + "] is clickable!");
        waitObject.until(ExpectedConditions.elementToBeClickable(element));
        logger.log(Level.INFO, "The element [" + element.getAccessibleName() + "] is clickable!");
    }

    public static void waitTillElementIsVisible(WebElement element) {
        logger.log(Level.INFO, "Waiting till the web element [" + element.getAccessibleName() + "] is visible!");
        waitObject.until(ExpectedConditions.visibilityOf(element));
        logger.log(Level.INFO, "The element [" + element.getAccessibleName() + "] is visible!");
    }

}
