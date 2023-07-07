package com.opencart.pageobjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class Page {
    private static final Logger logger = LogManager.getLogger(Page.class);

    public Page(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//i[@class='fa-solid fa-user']")
    protected WebElement myAccountBtn;

    @FindBy(xpath = "//a[normalize-space()='Register']")
    protected WebElement registerBtn;
    @FindBy(xpath = "//a[@class='dropdown-item'][normalize-space()='Login']")
    protected WebElement loginBtn;

    public void navigateToRegisterPage() {
        myAccountBtn.click();
        logger.info("The button My Account was clicked!");
        registerBtn.click();
        logger.info("The Register button was clicked!");
    }

    public void navigateToLoginPage() {
        myAccountBtn.click();
        logger.info("The button My Account was clicked!");
        loginBtn.click();
        logger.info("The Login button was clicked!");
    }
}
