package Database;

import Airline.Plane;

import java.sql.*;
import java.util.ArrayList;

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

    /**
     * Метод для отримання списку літаків з бази даних
     * @return список літаків, який міститься у відповідній таблиці бд
     */
    public ArrayList GetPlaneList(){
        ArrayList PlaneList = new ArrayList<>();

        String query = "SELECT * FROM Plane";
        try{
            Statement statement = connection.getDbConnection().createStatement();
            ResultSet result = statement.executeQuery(query);

            // Заповнюємо масив літаків зчитаними даними
            while (result.next()) {
                Plane plane = new Plane(result.getString(2), result.getString(3),
                        result.getInt(4), result.getDouble(5),
                        result.getInt(6), result.getInt(7) );
                PlaneList.add(plane);
            }
            connection.closeDbConnection();
        }
        catch (SQLException e){
            e.printStackTrace();
        }

        return PlaneList;
    }

}
