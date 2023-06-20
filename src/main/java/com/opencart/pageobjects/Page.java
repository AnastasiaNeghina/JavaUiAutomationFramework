package com.opencart.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class Page {
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
        System.out.println("The button My Account was clicked!");
        registerBtn.click();
        System.out.println("The Register button was clicked!");
    }

    public void navigateToLoginPage() {
        myAccountBtn.click();
        System.out.println("The button My Account was clicked!");
        loginBtn.click();
        System.out.println("The Login button was clicked!");
    }
}
