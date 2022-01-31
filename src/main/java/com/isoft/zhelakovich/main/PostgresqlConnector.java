package com.isoft.zhelakovich.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class PostgresqlConnector{




    public static Connection getConnection() throws SQLException {
        try {
            return DriverManager.getConnection(
                    Config.getPropertiesKey("db.url"),
                    Config.getPropertiesKey("db.login"),
                    Config.getPropertiesKey("db.password")
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
