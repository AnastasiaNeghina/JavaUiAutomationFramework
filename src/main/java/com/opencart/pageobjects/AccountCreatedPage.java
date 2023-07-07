package com.opencart.pageobjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountCreatedPage extends Page {
    private static final Logger logger = LogManager.getLogger(AccountCreatedPage.class);

    public AccountCreatedPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@class='dropdown-item'][normalize-space()='Logout']")
    protected WebElement logoutOption;

    public void logoutFromAccount() {
        myAccountBtn.click();
        logoutOption.click();
        logger.info("The user was logged out");
    }
}
