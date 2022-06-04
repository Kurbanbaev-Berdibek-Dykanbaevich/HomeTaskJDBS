package peaksoft.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseHM {
    private static final String URL = "jdbc:postgresql://localhost:5432/home_task";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "postgres";

    public static Connection connection(){
        Connection connection = null;
        try{
            connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            System.out.println("Successfully connected to Database!!!");
        }catch (SQLException e){
            e.printStackTrace();
        }
        return connection;
    }
}
