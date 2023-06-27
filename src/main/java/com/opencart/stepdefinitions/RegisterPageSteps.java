package com.opencart.stepdefinitions;

import com.opencart.managers.DriverManager;
import com.opencart.managers.FakeDataManager;
import com.opencart.pageobjects.RegisterPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class RegisterPageSteps {
    WebDriver driver = DriverManager.getInstance().getDriver();
    RegisterPage registerPage = new RegisterPage(driver);

    @When("the registration form is completed with valid random data")
    public void theRegistrationFormIsCompletedWithValidRandomData() {
        String firstName = FakeDataManager.getRandomName();
        String lastName = FakeDataManager.getRandomLastName();
        String email = FakeDataManager.getRandomEmail();
        String password = FakeDataManager.getRandomPassword(20, 30);

        registerPage.fillInTheRegisterForm(firstName, lastName, email, password);

    }

    @And("the privacyToggle is enabled")
    public void thePrivacyToggleIsEnabled() throws InterruptedException {
        registerPage.switchOnThePrivacyPolicyToggle(driver);
    }

    @And("the continueButton is clicked")
    public void theContinueButtonIsClicked() throws InterruptedException {
        registerPage.clickOnContinueBtn();
    }
}
