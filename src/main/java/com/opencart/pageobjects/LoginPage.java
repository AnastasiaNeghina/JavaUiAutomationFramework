package com.opencart.pageobjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Page {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private static final Logger logger = LogManager.getLogger(Page.class);

    @FindBy(css = "#input-email")
    protected WebElement emailAddressInput;
    @FindBy(css = "#input-password")
    protected WebElement passwordInput;
    @FindBy(css = "button[type='submit']")
    protected WebElement loginBtn;

    public void fillInTheLoginForm(String email, String password) {
        emailAddressInput.sendKeys(email);
        logger.info("The entered Email is: " + email);
        passwordInput.sendKeys(password);
        logger.info("The entered Password is: " + password);
    }

    public void clickOnLoginBtn() {
        loginBtn.click();
        logger.info("The user was logged in");

    }
}