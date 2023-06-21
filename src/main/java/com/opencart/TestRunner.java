package com.opencart;

import com.opencart.managers.DriverManager;
import com.opencart.managers.FakeDataManager;
import com.opencart.managers.ScrollManager;
import com.opencart.pageobjects.AccountCreatedPage;
import com.opencart.pageobjects.HomePage;
import com.opencart.pageobjects.LoginPage;
import com.opencart.pageobjects.RegisterPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;

public class TestRunner {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverManager.getInstance().getDriver();

        driver.get("https://andreisecuqa.host/");
        HomePage homePage = new HomePage(driver);
        homePage.navigateToRegisterPage();

        String firstName = FakeDataManager.getRandomName();
        String lastName = FakeDataManager.getRandomLastName();
        String email = FakeDataManager.getRandomEmail();
        String password = FakeDataManager.getRandomPassword(20, 30);

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.fillInTheRegisterForm(firstName, lastName, email, password);
        registerPage.switchOnThePrivacyPolicyToggle(driver);
        registerPage.clickOnContinueBtn();
        Thread.sleep(2000);

//       Logout the user
        AccountCreatedPage accountCreatedPage = new AccountCreatedPage(driver);
        accountCreatedPage.logoutFromAccount();
        Thread.sleep(2000);

//       Login the user that was created with random generated data
        homePage.navigateToLoginPage();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillInTheLoginForm(email, password);
        Thread.sleep(2000);
        loginPage.clickOnLoginBtn();
        Thread.sleep(2000);

        driver.quit();
        System.out.println("The execution was finished!");
    }
}