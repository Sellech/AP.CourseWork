package Database;

import java.sql.*;

/**
 * Клас для встановлення з'єднання з SQL-server
 */
public class DatabaseConnection {
    private Connection dbConnection;

    /**
     * Метод для отримання з'єднання з SQL-server
     * @return посилання на з'єднання
     */
    public Connection getDbConnection() throws SQLException{

        // Конфігурація
        String host = "DESKTOP-CT6A1CV";
        String username = "admin";
        String password = "123456789";
        String dbName = "CourseWork";

        String url = "jdbc:sqlserver://"+host+";databaseName="+dbName+";encrypt=true;trustServerCertificate=true;";

        // Підключення
        dbConnection = DriverManager.getConnection(url, username, password);
        System.out.println("Підключення до SQL серверу");

        return dbConnection;
    }

    /**
     * Метод для від'єднання від SQL-server
     */
    public void closeDbConnection() throws SQLException{
        System.out.println("Відключення від SQL серверу");
        dbConnection.close();
    }
}
