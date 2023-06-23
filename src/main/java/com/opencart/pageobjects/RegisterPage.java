package com.opencart.pageobjects;

import com.opencart.managers.DriverManager;
import com.opencart.managers.ScrollManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends Page {
    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "input-firstname")
    protected WebElement firstNameInput;
    @FindBy(id = "input-lastname")
    protected WebElement lastNameInput;
    @FindBy(id = "input-email")
    protected WebElement emailInput;
    @FindBy(id = "input-password")
    protected WebElement passwordInput;
    @FindBy(xpath = "//input[@name='agree']")
    protected WebElement privacyPolicyToggle;
    @FindBy(css = "button[type='submit']")
    protected WebElement continueBtn;

    public void fillInTheRegisterForm(String firstName, String lastName, String email, String password) {
        firstNameInput.sendKeys(firstName);
        System.out.println("The entered First Name is: " + firstName);
        lastNameInput.sendKeys(lastName);
        System.out.println("The entered Last Name is: " + lastName);
        emailInput.sendKeys(email);
        System.out.println("The entered Email is: " + email);
        passwordInput.sendKeys(password);
        System.out.println("The entered Password is: " + password);
    }

    public void switchOnThePrivacyPolicyToggle(WebDriver driver) throws InterruptedException {
        ScrollManager.scrollToElement(driver, privacyPolicyToggle);
        privacyPolicyToggle.click();
    }

    public void clickOnContinueBtn() throws InterruptedException {
        ScrollManager.scrollToElement(DriverManager.getInstance().getDriver(), continueBtn);
        continueBtn.click();
    }
}
