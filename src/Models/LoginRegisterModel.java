package src.Models;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Observable;

public class LoginRegisterModel extends Observable {

    // instance field
    // Database connection fields
    public Connection conn;
    public Statement statement;


    public LoginRegisterModel() {
//        String
//        ResultSet loginVertification = statement.executeQuery()
    }





    public void verifyLogin(String uuid, String password) {

        notifyObservers();
    }
}
