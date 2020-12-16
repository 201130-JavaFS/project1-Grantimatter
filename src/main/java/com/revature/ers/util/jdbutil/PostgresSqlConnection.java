package com.revature.ers.util.jdbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresSqlConnection {
    private static Connection connection;

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName(DbUtilProps.DRIVER);
        String username=System.getenv("postgresUserName");
        //String password=System.getenv("postgresPassword");
        String password = System.getenv("awsPassword");
        connection = DriverManager.getConnection(DbUtilProps.URL, username, password);
        return connection;
    }

    public static void setConnection(Connection connection) {
        PostgresSqlConnection.connection = connection;
    }
}
