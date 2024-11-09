package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    public static String getProperty(String key) {
    	Properties properties = new Properties();
    	
        try (FileInputStream fis = new FileInputStream("config.properties")) {
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return properties.getProperty(key);
    }

    public static void main(String[] args) {
       

        // Access and print properties
        String dbUrl = ConfigReader.getProperty("db.path");
        String dbUser = ConfigReader.getProperty("document.path");


        // Print the properties
        System.out.println("Database URL: " + dbUrl);
        System.out.println("Database User: " + dbUser);

    }
}

