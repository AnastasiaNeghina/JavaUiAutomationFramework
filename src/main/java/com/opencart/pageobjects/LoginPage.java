package com.opencart.pageobjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Page {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#input-email")
    protected WebElement emailAddressInput;
    @FindBy(css = "#input-password")
    protected WebElement passwordInput;
    @FindBy(css = "button[type='submit']")
    protected WebElement loginBtn;

    public void fillInTheLoginForm(String email, String password) {
        emailAddressInput.sendKeys(email);
        System.out.println("The entered Email is: " + email);
        passwordInput.sendKeys(password);
        System.out.println("The entered Password is: " + password);
    }

    public void clickOnLoginBtn() {
        loginBtn.click();
        System.out.println("The user was logged in");

    }
}