package database;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigLoader {
    private Properties properties = new Properties();

    public ConfigLoader() {
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("application.properties")) {
            if (input == null) {
                System.out.println("Sorry, unable to find application.properties");
                return;
            }
            properties.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public String getDbUrl() {
        return properties.getProperty("spring.datasource.url");
    }

    public String getDbUser() {
        return properties.getProperty("spring.datasource.username");
    }

    public String getDbPassword() {
        return properties.getProperty("spring.datasource.password");
    }
}
