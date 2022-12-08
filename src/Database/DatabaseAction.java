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
    private final String AIRLINE_TABLE = "Airline"; // таблиця авіакомпанії
    private final String AIRLINE_NAME = "AirlineName";

    private final String PLANE_TABLE = "Plane"; // таблиця авіапарку
    private final String PLANE_NAME = "[Name]";
    private final String PLANE_SIDE_NUMBER = "SideNumber";
    private final String PLANE_FLY_DISTANCE = "FlyDistance";
    private final String PLANE_FUEL_CONSUMPTION= "FuelConsumption";
    private final String PLANE_PASSENGER_CAPACITY = "PassengerCapacity";
    private final String PLANE_CARGO_CAPACITY = "CargoCapacity";

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

    /**
     * Метод для додавання літака до бд
     */
    public void PlaneAdd(Plane plane){
        String query = "INSERT INTO " + PLANE_TABLE + " ("
                + PLANE_NAME + "," + PLANE_SIDE_NUMBER + ","
                + PLANE_FLY_DISTANCE + "," + PLANE_FUEL_CONSUMPTION + ","
                + PLANE_PASSENGER_CAPACITY + "," + PLANE_CARGO_CAPACITY
                + ") VALUES(?,?,?,?,?,?)";
        try{
            PreparedStatement statement = connection.getDbConnection().prepareStatement(query);
            statement.setString(1, plane.getName());
            statement.setString(2, plane.getSideNumber());
            statement.setInt(3, plane.getFlyDistance());
            statement.setDouble(4, plane.getFuelConsumption());
            statement.setInt(5, plane.getPassengerCapacity());
            statement.setDouble(6, plane.getCargoCapacity());
            statement.executeUpdate();
            connection.closeDbConnection();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    /**
     * Метод для зміни інформації про літак в бд
     * @param RemovablePlane літак, який хочемо змінити
     * @param ChosenPlane характеристики літака, на які хочемо змінити
     */
    public void PlaneChange(Plane RemovablePlane, Plane ChosenPlane){
        String query = "UPDATE  " + PLANE_TABLE + " SET "
                + PLANE_NAME + " = ?,"
                + PLANE_SIDE_NUMBER + " = ?,"
                + PLANE_FLY_DISTANCE + " = ?,"
                + PLANE_FUEL_CONSUMPTION + " = ?,"
                + PLANE_PASSENGER_CAPACITY + " = ?,"
                + PLANE_CARGO_CAPACITY + " = ? "
                + "WHERE " + PLANE_SIDE_NUMBER + " = ?";
        try{
            PreparedStatement statement = connection.getDbConnection().prepareStatement(query);
            statement.setString(1, ChosenPlane.getName());
            statement.setString(2, ChosenPlane.getSideNumber());
            statement.setInt(3, ChosenPlane.getFlyDistance());
            statement.setDouble(4, ChosenPlane.getFuelConsumption());
            statement.setInt(5, ChosenPlane.getPassengerCapacity());
            statement.setDouble(6, ChosenPlane.getCargoCapacity());

            statement.setString(7, RemovablePlane.getSideNumber());
            statement.executeUpdate();
            connection.closeDbConnection();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    /**
     * Метод для видалення обраного літака з бд
     * @param RemovablePlane літак, який необхідно видалити
     */
    public void PlaneDelete(Plane RemovablePlane){
        String query = "DELETE FROM " + PLANE_TABLE + " WHERE "
                + PLANE_SIDE_NUMBER + " = ?";
        try{
            PreparedStatement statement = connection.getDbConnection().prepareStatement(query);
            statement.setString(1, RemovablePlane.getSideNumber());

            statement.executeUpdate();
            connection.closeDbConnection();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    /**
     * Метод для перевірки списку літаків в бд на наявність повторень бортового номера
     * @return false якщо було знайдено повторення, true - якщо не було знайдено повторень
     */
    public boolean SideNumberDuplicateCheck(String SideNumber){
        ArrayList<Plane> PlaneList = GetPlaneList();

        for(int i=0; i<PlaneList.size(); i++){
            if(PlaneList.get(i).getSideNumber().equals(SideNumber))
                return false;
        }
        return true;
    }

}
