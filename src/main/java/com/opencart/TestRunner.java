package com.opencart;

import com.opencart.managers.DriverManager;
import com.opencart.managers.FakeDataManager;
import com.opencart.managers.ScrollManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;

public class TestRunner {
    public static void main(String[] args) throws InterruptedException {
//      Defined a driver object that will be used for future actions
        WebDriver driver = DriverManager.getInstance().getDriver();

        driver.get("https://www.google.md/");
        String currentWindowName = driver.getWindowHandle();
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://andreisecuqa.host/");

// First case - automation scenario: after accessing the andreisecuqa link to register a new user with handwritten data and to logout

//        Defined the web elements for first user
        WebElement accountIcon = driver.findElement(By.xpath("//i[@class='fa-solid fa-user']"));
        accountIcon.click();
        WebElement registerBtn = driver.findElement(By.xpath("//a[normalize-space()='Register']"));
        registerBtn.click();

        WebElement firstNameInput = driver.findElement(By.id("input-firstname"));
        firstNameInput.sendKeys("James");
        WebElement lastNameInput = driver.findElement(By.id("input-lastname"));
        lastNameInput.sendKeys("Rodriguez");
        WebElement emailInput = driver.findElement(By.id("input-email"));
        emailInput.sendKeys("Rodriguez000@gmail.com");
        WebElement passwordInput = driver.findElement(By.id("input-password"));
        passwordInput.sendKeys("JR2023!");
        WebElement privacyPolicyToggle = driver.findElement(By.xpath("//input[@name='agree']"));
        ScrollManager.scrollToElement(driver, privacyPolicyToggle);
        privacyPolicyToggle.click();
        WebElement continueBtn = driver.findElement(By.cssSelector("button[type='submit']"));
        continueBtn.click();
        Thread.sleep(500);

//        Log out the first user
        WebElement accountIconNextPage = driver.findElement(By.xpath("//i[@class='fa-solid fa-user']"));
        accountIconNextPage.click();
        Thread.sleep(500);
        WebElement logoutBtn = driver.findElement(By.xpath("//a[@class='dropdown-item'][normalize-space()='Logout']"));
        logoutBtn.click();
        driver.close();
        System.out.println("The user 1 has successfully logged out!");

//   Second case - automation scenario: after accessing the andreisecuqa link in a new tab to register a new user with random generated data, to logout and log in with random generated data

        driver.switchTo().window(currentWindowName);
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://andreisecuqa.host/");

//        Defined the web elements for second user
        WebElement accountIconForUser2 = driver.findElement(By.xpath("//i[@class='fa-solid fa-user']"));
        accountIconForUser2.click();
        WebElement registerBtnForUser2 = driver.findElement(By.xpath("//a[normalize-space()='Register']"));
        registerBtnForUser2.click();

        String firstName = FakeDataManager.getRandomName();
        System.out.println("The generated first name is: " + firstName);
        WebElement firstNameInputUser2 = driver.findElement(By.id("input-firstname"));
        firstNameInputUser2.sendKeys(firstName);

        String lastName = FakeDataManager.getRandomLastName();
        System.out.println("The generated last name is: " + lastName);
        WebElement lastNameInputUser2 = driver.findElement(By.id("input-lastname"));
        lastNameInputUser2.sendKeys(lastName);

        String email = FakeDataManager.getRandomEmail();
        System.out.println("The generated email is: " + email);
        WebElement emailInputUser2 = driver.findElement(By.id("input-email"));
        emailInputUser2.sendKeys(email);

        String password = FakeDataManager.getRandomPassword(20, 30);
        System.out.println("The generated password is: " + password);
        WebElement passwordInputUser2 = driver.findElement(By.id("input-password"));
        passwordInputUser2.sendKeys(password);

        WebElement pPToggle = driver.findElement(By.xpath("//input[@name='agree']"));
        ScrollManager.scrollToElement(driver, pPToggle);
        pPToggle.click();

        WebElement continueBtnUser2 = driver.findElement(By.cssSelector("button[type='submit']"));
        continueBtnUser2.click();
        Thread.sleep(500);

//        Logout the user 2
        WebElement accountIconToLogoutUser2 = driver.findElement(By.xpath("//i[@class='fa-solid fa-user']"));
        accountIconToLogoutUser2.click();
        Thread.sleep(500);
        WebElement logoutBtnUser2 = driver.findElement(By.xpath("//a[@class='dropdown-item'][normalize-space()='Logout']"));
        logoutBtnUser2.click();
        Thread.sleep(500);

//        Login the second user that was created with random generated data
        WebElement accountIconToLogInUser2 = driver.findElement(By.xpath("//i[@class='fa-solid fa-user']"));
        accountIconToLogInUser2.click();
        Thread.sleep(500);
        WebElement loginBtnToLogInUser2 = driver.findElement(By.xpath("//a[@class='dropdown-item'][normalize-space()='Login']"));
        loginBtnToLogInUser2.click();
        Thread.sleep(500);

        WebElement emailAddressUser2 = driver.findElement(By.id("input-email"));
        emailAddressUser2.sendKeys(email);
        WebElement passwordUser2 = driver.findElement(By.id("input-password"));
        passwordUser2.sendKeys(password);
        WebElement loginBtn = driver.findElement(By.xpath("//button[normalize-space()='Login']"));
        loginBtn.click();
        Thread.sleep(500);

        System.out.println("The user 2 has successfully logged in!");
        System.out.println(driver.getCurrentUrl());

        driver.quit();
        System.out.println("The execution was finished!");
    }
}