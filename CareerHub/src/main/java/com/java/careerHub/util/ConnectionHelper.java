package com.java.careerHub.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.MissingResourceException;

public class ConnectionHelper {

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        try {
            ResourceBundle rb = ResourceBundle.getBundle("db");
            String driver = rb.getString("driver");
            String url = rb.getString("url");
            String user = rb.getString("user");
            String pwd = rb.getString("password");

            Class.forName(driver);
            return DriverManager.getConnection(url, user, pwd);
        } catch (MissingResourceException e) {
            System.err.println("Error: 'db.properties' file is missing. Ensure it is in the classpath.");
            throw new RuntimeException(e);
        }
    }
}
