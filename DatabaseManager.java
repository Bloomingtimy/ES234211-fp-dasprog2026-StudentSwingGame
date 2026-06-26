package FPGame;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {

    // TODO: Change these values based on your database configuration
    private static final String URL = "jdbc:mysql://localhost:3308/game_project";
    private static final String USER = "adminFPDasprog";
    //adminFPDasprog
    private static final String PASSWORD = "4dminFPDaspr0";
    //4dminFPDaspr0

    public static Connection getConnection(){
        try{
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch(Exception e) {
                System.out.println("DATABASE ERROR:");
                e.printStackTrace();
                return null;
        }
    }
}

