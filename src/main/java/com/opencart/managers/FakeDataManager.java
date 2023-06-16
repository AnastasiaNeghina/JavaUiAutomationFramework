package com.opencart.managers;

import com.github.javafaker.Faker;

public class FakeDataManager {
    private static Faker fakerObject = new Faker();

    public static String getRandomName() {
        return fakerObject.name().firstName();
    }

    public static String getRandomLastName() {
        return fakerObject.funnyName().name();
    }

    public static String getRandomEmail() {
        return fakerObject.internet().emailAddress();
    }

    public static String getRandomPassword(int min, int max) {
        return fakerObject.internet().password(min, max);
    }
}
