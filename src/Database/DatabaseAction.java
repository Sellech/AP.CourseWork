package Database;

import Airline.Plane;

import javax.security.auth.login.Configuration;
import java.sql.*;
import java.util.ArrayList;

/**
 * Клас для реалізації операцій в БД
 */
public class DatabaseAction  {

    // Конфігурація
    private final String AIRLINE_TABLE = "Airline"; // таблиця що містить назву авіакомпанії
    private final String AIRLINE_NAME = "AirlineName";  // назва стовпця, який містить ім'я авіалінії

    private final String PLANE_TABLE = "Plane"; // таблиця авіапарку компанії







    private final DatabaseConnection connection;

    /**
     * Конструктор даного класу
     */
    public DatabaseAction(){
        connection = new DatabaseConnection();
    }

    /**
     * Метод для створення авіакомпанії в бд
     */
    public void CreateAirline(String AirlineName){
        String query = "INSERT INTO " + AIRLINE_TABLE + " ("
                + AIRLINE_NAME + ") VALUES(?)";

        try{
            PreparedStatement statement = connection.getDbConnection().prepareStatement(query);
            statement.setString(1, AirlineName);
            statement.executeUpdate();
            connection.closeDbConnection();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    /**
     * Метод для видалення авіалінії при закритті програми
     */
    public void DeleteAirline(){
        String query = "DELETE FROM " + AIRLINE_TABLE;
        try{
            PreparedStatement statement = connection.getDbConnection().prepareStatement(query);
            statement.executeUpdate();
            connection.closeDbConnection();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    /**
     * Метод для отримання назви авіакомпанії з бд
     * @return стрічку, яка містить назву компанії
     */
    public String GetAirlineName(){
        String AirlineName = new String(), query = "SELECT * FROM " + AIRLINE_TABLE;

        try{
            Statement statement = connection.getDbConnection().createStatement();
            ResultSet result = statement.executeQuery(query);

            while (result.next()) {
                AirlineName = result.getString(1);
            }
            connection.closeDbConnection();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return AirlineName;
    }

    /**
     * Метод для отримання списку літаків з бази даних
     * @return список літаків, який міститься у відповідній таблиці бд
     */
    public ArrayList GetPlaneList(){
        ArrayList PlaneList = new ArrayList<>();

        String query = "SELECT * FROM " + PLANE_TABLE;
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
