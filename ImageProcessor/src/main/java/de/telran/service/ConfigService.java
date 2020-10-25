package de.telran.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigService {

    Properties prop = new Properties();

    public ConfigService() {
        try (InputStream input = ConfigService.class.getClassLoader().getResourceAsStream("application.properties")) {
            if (input == null) {
                System.out.println("Sorry, unable to find application.properties");
            }
            prop.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getPathSeparator() {
        return (String) prop.get("csv_separator");
    }

    public String getPathToSavedImages() {
        return (String) prop.get("path_to_saved_images");
    }
}