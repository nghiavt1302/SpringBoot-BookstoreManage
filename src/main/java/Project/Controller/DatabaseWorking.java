package Project.Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseWorking {
    public static void insertUserToDB(String email, String phoneNum, String password) throws SQLException {
        Connection connection = DBConnection.DBConnect();
        Statement stmt = connection.createStatement();
        String sql = "INSERT INTO customer(email,phone,password) VALUES("+ email + "," + phoneNum + "," + password + ")";
        stmt.execute(sql);
    }
}
