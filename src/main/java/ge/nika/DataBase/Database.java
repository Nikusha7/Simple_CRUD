package ge.nika.DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static String url = "jdbc:mysql://localhost:3306/student";
    private static String userName = "root";
    private static String password = "nika";

    private Database(){

    }

    public static Connection getConnection() throws SQLException{
        Connection connection;
        connection = DriverManager.getConnection(url, userName, password);

        return connection;
    }

}
