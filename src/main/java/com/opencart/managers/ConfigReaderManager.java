package com.opencart.managers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReaderManager {
    private static final Logger logger = LogManager.getLogger(ConfigReaderManager.class);
    private static final String CONFIG_FILE_PATH = "src/main/resources/config.properties";
    private static Properties definedProperties;

    private static void initDefinedProperties() {
        try {
            FileInputStream fileInputStream = new FileInputStream(CONFIG_FILE_PATH);
            definedProperties = new Properties();
            definedProperties.load(fileInputStream);
            fileInputStream.close();
        } catch (IOException capturedException) {
            capturedException.printStackTrace();
        }
    }

    public static String getProperty(String propertyKey) {
        if (definedProperties == null){
            initDefinedProperties();
            logger.info("The properties were initialized");
        }
        return definedProperties.getProperty(propertyKey);
    }
}
