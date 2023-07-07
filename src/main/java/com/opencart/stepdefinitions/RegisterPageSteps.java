package com.opencart.stepdefinitions;

import com.opencart.managers.DriverManager;
import com.opencart.managers.FakeDataManager;
import com.opencart.pageobjects.RegisterPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import java.util.Map;

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

    @And("the registration form is completed with the following data:")
    public void theRegistrationFormIsCompletedWithTheFollowingData(Map<String, String> userRegistrationMap) {
        String firstnameValue = userRegistrationMap.get("firstname");
        if (firstnameValue != null && firstnameValue.toUpperCase().equals("RANDOM")) {
            firstnameValue = FakeDataManager.getRandomName();
        }
        String lastnameValue = userRegistrationMap.get("lastname");
        if (lastnameValue != null && lastnameValue.toUpperCase().equals("RANDOM")) {
            lastnameValue = FakeDataManager.getRandomLastName();
        }
        String emailValue = userRegistrationMap.get("email");
        if (emailValue != null && emailValue.toUpperCase().equals("RANDOM")) {
            emailValue = FakeDataManager.getRandomEmail();
        }
        String passwordValue = userRegistrationMap.get("password");
        if (passwordValue != null && passwordValue.toUpperCase().equals("RANDOM")) {
            passwordValue = FakeDataManager.getRandomPassword(10, 22);
        }

        registerPage.fillInTheRegisterForm(firstnameValue, lastnameValue, emailValue, passwordValue);
    }
}
