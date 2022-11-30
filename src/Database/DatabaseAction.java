package Database;

import java.sql.*;

/**
 * Клас для реалізації операцій в БД
 */
public class DatabaseAction {
    //
    private final DatabaseConnection connection;

    /**
     * Конструктор даного класу
     */
    public DatabaseAction(){
        connection = new DatabaseConnection();
    }

}
