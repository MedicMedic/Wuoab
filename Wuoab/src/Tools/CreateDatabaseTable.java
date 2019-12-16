package Tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDatabaseTable {

    private static Connection conn;
    private static String url = "jdbc:derby:WuoabDB;create=true";
    private static String username = "root";
    private static String password = "Qwert12345";
    private static Statement statement;
    private static String createUserInformationTable = "CREATE TABLE UserInfo(" +
            "UUID INT primary key GENERATED ALWAYS AS IDENTITY (START WITH 19000000, INCREMENT BY 1), " +
            "FirstName VARCHAR(255), " +
            "Surname VARCHAR(255), " +
            "ID VARCHAR(255), " +
            "PhoneNum VARCHAR(255), " +
            "Password VARCHAR(255), " +
            "Question VARCHAR(255), " +
            "Answer VARCHAR(255), " +
            "IFOnline INT)" ;

    public static void main(String[] args) {
        try{
            conn = DriverManager.getConnection(url, username, password);
            statement = conn.createStatement();

            // create user info table
//            statement.addBatch(createUserInformationTable);
//            statement.executeBatch();
            statement.executeUpdate(createUserInformationTable);
//	    statement.executeUpdate("CREATE TABLE test (ID INT, MAKE VARCHAR(50), MODEL VARCHAR(50), PRICE INT )");
        } catch(SQLException sqlEX){
            System.out.println("SQLException has occured: " + sqlEX.getMessage());
        }
    }


}
