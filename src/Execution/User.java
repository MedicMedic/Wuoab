package src.Execution;

import java.sql.*;

public class User implements Runnable {

    // derby connection information field
    public static Connection conn;
    public static String url = "jdbc:derby:WuoabDB;create=true";
    public static String username = "root";
    public static String password = "Qwert12345";
    public static Statement statement;

    // init block
    {

    }

    // constructors
    public User() {
        autoConnectWuoabDB();


        // close the connection
        try {
            statement.close();
            conn.close();
        } catch (SQLException sqlEx) {
            System.out.println("SQL Exception occurs: " + sqlEx.getMessage());
        }

    }

    // methods
    @Override
    public void run() {

    }

    public void autoConnectWuoabDB() {
        try {
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connection has been established");
            statement = conn.createStatement();

        } catch (SQLException sqlEx) {
            System.out.println("SQL Exception occurs: " + sqlEx.getMessage());
        }
    }

    public static void createUserInformationTable() {
        try {
            statement = conn.createStatement();
//            String
        } catch (SQLException sqlEx) {
            System.out.println("SQL Exception occurs: " + sqlEx.getMessage());
        }
    }
}
