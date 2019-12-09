package factory;

import java.io.IOException;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {

    private String driverClassName = "com.mysql.jdbc.Driver";
    private String url, name, password;

    private static ConnectionFactory connectionFactory = null;

    private ConnectionFactory() {
        try {
            Class.forName(driverClassName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() throws SQLException {
        try {
            Properties props = new Properties();
            props.load(this.getClass().getClassLoader().getResourceAsStream(
                    "database.properties"));

            url = props.getProperty("url");
            name = props.getProperty("username");
            password = props.getProperty("password");

            return DriverManager.getConnection(url, name, password);
        } catch (IOException e) {
            System.out.println("Problem with reading from properties");
        }
        return null;
    }

    public static ConnectionFactory getInstance() {
        if (connectionFactory == null) {
            connectionFactory = new ConnectionFactory();
        }
        return connectionFactory;
    }
}
