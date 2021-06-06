import javax.swing.*;
import com.mysql.cj.jdbc.Driver;
import java.sql.*;

public class JDBC {
    private  static Connection connection = null;
    private static PreparedStatement statement = null;
    private static String url ="jdbc:mysql://localhost:3306/AutoShop";
    private static  String username = "root";
    private static String password ="AidarkanMoldokulov5";
    private static int rows;

    public static void main(String[] args) throws SQLException {
        AddCars("BMB", "Black", 3.5, 50000.00);
        AddCars("Mercedes", "Blue", 5.5, 100000.00);
        AddCars("Mazda", "Green", 2.5, 15000.00);

        selectCars();

        updateСars(2,"Tayota");

        selectCars();

        deleteCars(1);
        deleteCars(2);

        selectCars();
    }

    private static void connectiondb(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url,username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();

        }
    }
    private static void AddCars(String CarName, String Color,double EngineVolume, double Price) throws SQLException {
        try {
            connectiondb();
            statement = connection.prepareStatement("insert into Cars (CarName ,Color ,EngineVolume ,Price) values(?,?,?,?)");
            statement.setString(1, CarName);
            statement.setString(2, Color);
            statement.setDouble(3, EngineVolume);
            statement.setDouble(4, Price);
            rows = statement.executeUpdate();
            System.out.println(" rows added " + rows);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            try {
                if (statement!=null){
                    connection.close();
                }
            }
            catch (SQLException e){
                e.printStackTrace();
            }
            try{
                if(connection!=null){
                    connection.close();
                }
            }
            catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    private static void selectCars(){
        try {
            connectiondb();
            Statement statement = connection.createStatement();
            ResultSet resultSet= statement.executeQuery("select * from Cars");
            while (resultSet.next()){
                int id= resultSet.getInt(1);
                String CarName = resultSet.getString(2);
                String Color = resultSet.getString(3);
                double EngineVolume = resultSet.getDouble(4);
                double Price = resultSet.getDouble(5);
                System.out.printf("%d  %s  %s  %f  %f \n",id,CarName,Color,EngineVolume,Price);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            try {
                if (statement!=null){
                    connection.close();
                }
            }
            catch (SQLException e){
                e.printStackTrace();
            }
            try{
                if(connection!=null){
                    connection.close();
                }
            }
            catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    private  static void updateСars(int CarID, String CarName){
        try {
            connectiondb();
            statement  = connection.prepareStatement("update Cars set CarName = ? where CarID = ?");
            statement.setString(1,CarName);
            statement.setInt(2,CarID);
            rows = statement.executeUpdate();
            System.out.printf("%d rows updated \n", rows);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                if (statement != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private static void deleteCars(int CarID){
        try {
            connectiondb();
            statement = connection.prepareStatement("delete from Cars where CarID = ?");
            statement.setInt(1, CarID);
            rows = statement.executeUpdate();
            System.out.printf("%d rows deleted \n", rows);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                if (statement != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
