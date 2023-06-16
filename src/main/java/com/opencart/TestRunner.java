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
//        Defined the web elements
        WebElement accountIcon = driver.findElement(By.xpath("//i[@class='fa-solid fa-user']"));
        accountIcon.click();
        WebElement registerBtn = driver.findElement(By.xpath("//a[normalize-space()='Register']"));
        registerBtn.click();

// First case - automation scenario: after accessing the andreisecuqa link to register a new user with handwritten data
//        WebElement firstNameInput = driver.findElement(By.id("input-firstname"));
//        firstNameInput.sendKeys("James");
//        WebElement lastNameInput = driver.findElement(By.id("input-lastname"));
//        lastNameInput.sendKeys("Rodriguez");
//        WebElement emailInput = driver.findElement(By.id("input-email"));
//        emailInput.sendKeys("Rodriguez10@gmail.com");
//        WebElement passwordInput = driver.findElement(By.id("input-password"));
//        passwordInput.sendKeys("JR2023!");
//        WebElement privacyPolicyToggle = driver.findElement(By.xpath("//input[@name='agree']"));
//        ScrollManager.scrollToElement(driver, privacyPolicyToggle);
//        privacyPolicyToggle.click();
//        WebElement continueBtn = driver.findElement(By.cssSelector("button[type='submit']"));
//        continueBtn.click();

// Second case - automation scenario: after accessing the andreisecuqa link to register a new user with random generated data
        String firstName = FakeDataManager.getRandomName();
        System.out.println("The generated first name is: " + firstName);
        WebElement firstNameInput = driver.findElement(By.id("input-firstname"));
        firstNameInput.sendKeys(firstName);

        String lastName = FakeDataManager.getRandomLastName();
        System.out.println("The generated last name is: " + lastName);
        WebElement lastNameInput = driver.findElement(By.id("input-lastname"));
        lastNameInput.sendKeys(lastName);

        String email = FakeDataManager.getRandomEmail();
        System.out.println("The generated email is: " + email);
        WebElement emailInput = driver.findElement(By.id("input-email"));
        emailInput.sendKeys(email);

        String password = FakeDataManager.getRandomPassword(20, 30);
        System.out.println("The generated password is: " + password);
        WebElement passwordInput = driver.findElement(By.id("input-password"));
        passwordInput.sendKeys(password);

        WebElement privacyPolicyToggle = driver.findElement(By.xpath("//input[@name='agree']"));
        ScrollManager.scrollToElement(driver, privacyPolicyToggle);
        privacyPolicyToggle.click();

        WebElement continueBtn = driver.findElement(By.cssSelector("button[type='submit']"));
        continueBtn.click();

        System.out.println(driver.getCurrentUrl());

        driver.close();

        driver.switchTo().window(currentWindowName);

        driver.get("https://andreisecuqa.host/");

        driver.quit();
        System.out.println("The execution was finishe!");
    }
}