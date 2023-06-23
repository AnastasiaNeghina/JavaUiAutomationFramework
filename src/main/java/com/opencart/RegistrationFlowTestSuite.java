package com.opencart;

import com.opencart.managers.DriverManager;
import com.opencart.managers.FakeDataManager;
import com.opencart.pageobjects.HomePage;
import com.opencart.pageobjects.RegisterPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

public class RegistrationFlowTestSuite {
    WebDriver driver;
    HomePage homePage;
    RegisterPage registerPage;
    static int counter = 0;

    @BeforeAll
    public static void executeTheCodeBeforeAllTestCases() {
        System.out.println("The execution started!");
    }

    @BeforeEach
    public void executeTheCodeBeforeEachTestCase() {
        driver = DriverManager.getInstance().getDriver();
        driver.get("https://andreisecuqa.host/");
        homePage = new HomePage(driver);
        registerPage = new RegisterPage(driver);
        counter++;
        System.out.println("The test number: " + counter + " started!");
    }

    @Test
    @DisplayName("After registration of a new account the URL should contain the succes keyword")
    public void registerFlowRedirectsTheUserToTheCorrectURL() throws InterruptedException {

        homePage.navigateToRegisterPage();

        String firstName = FakeDataManager.getRandomName();
        String lastName = FakeDataManager.getRandomLastName();
        String email = FakeDataManager.getRandomEmail();
        String password = FakeDataManager.getRandomPassword(20, 30);

        registerPage.fillInTheRegisterForm(firstName, lastName, email, password);
        registerPage.switchOnThePrivacyPolicyToggle(driver);
        registerPage.clickOnContinueBtn();
        Thread.sleep(2000);

        boolean urlContainsTheCorrectKeywords = driver.getCurrentUrl().contains("success");
        Assertions.assertTrue(urlContainsTheCorrectKeywords, "The URL " + driver.getCurrentUrl() + " contains  success keyword");
    }

    @Test
    @DisplayName("When PrivacyPolicy toggle is not accepted, the URL contains keyword: register")
    public void registerFlowIsBlockedByPrivacyPolicyToggle() throws InterruptedException {

        homePage.navigateToRegisterPage();

        String firstName = FakeDataManager.getRandomName();
        String lastName = FakeDataManager.getRandomLastName();
        String email = FakeDataManager.getRandomEmail();
        String password = FakeDataManager.getRandomPassword(20, 30);

        registerPage.fillInTheRegisterForm(firstName, lastName, email, password);
//        According to the test scenario the Privacy Policy toggle is not accepted
//        registerPage.switchOnThePrivacyPolicyToggle(driver);
        registerPage.clickOnContinueBtn();
        Thread.sleep(2000);

        boolean urlContainsTheCorrectKeywords = driver.getCurrentUrl().contains("success");
        Assertions.assertFalse(urlContainsTheCorrectKeywords, "The URL " + driver.getCurrentUrl() + " contains keyword: success.");

        boolean urlContainsRegisterKeyword = driver.getCurrentUrl().contains("register");
        Assertions.assertTrue(urlContainsRegisterKeyword, "The URL belongs to register page");
    }

    @AfterEach
    public void executeThisMethodAfterEachTestCase() {
        DriverManager.getInstance().quitTheDriver(); //instance was defined as static so in order to invoke the method, we should use the name of the class
        System.out.println("The Test number: " + counter + " finished!");
    }

    @AfterAll
    public static void executeTheCodeAfterAllTestCases() {
        System.out.println("The execution finished!");
    }
}