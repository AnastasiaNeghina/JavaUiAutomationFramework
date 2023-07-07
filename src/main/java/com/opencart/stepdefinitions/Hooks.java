package com.opencart.stepdefinitions;

import com.opencart.managers.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Hooks {
    private static final Logger logger = LogManager.getLogger(Hooks.class);
    static int counter = 0;

    @BeforeAll
    public static void beforeAllTheTestsAreExecuted() {
        System.out.println("The execution of features is started!");
    }

    @Before
    public void beforeEachTest() {
        counter++;
        logger.log(Level.INFO, "The Test [" + counter + "] started");
    }

    @After
    public void afterEachTest() {
        DriverManager.getInstance().quitTheDriver();
        logger.info("The Test[" + counter + "] finished!");
    }

    @AfterAll
    public static void afterAllTheTestsAreExecuted() {
        logger.log(Level.INFO, "The execution of all features is finished!");
    }
}
