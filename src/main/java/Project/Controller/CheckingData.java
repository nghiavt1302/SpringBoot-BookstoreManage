package Project.Controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CheckingData {
    public static boolean checkEmailExist(String email) throws SQLException {
        Connection connection = DBConnection.DBConnect();
        Statement stmt = connection.createStatement();
        String sql = "SELECT email FROM customer";
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            if (email.equals(rs.getString("email"))) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkPhoneExist(String phoneNum) throws SQLException {
        Connection connection = DBConnection.DBConnect();
        Statement stmt = connection.createStatement();
        String sql = "SELECT phone FROM customer";
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            if (phoneNum.equals(rs.getString("phone"))) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkPassword(String phone, String password) throws SQLException {
        Connection connection = DBConnection.DBConnect();
        Statement stmt = connection.createStatement();
        String sql = "SELECT password FROM customer WHERE phone = '" + phone + "'";
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            if (password.equals(rs.getString("password"))) {
                return true;
            }
        }
        return false;
    }
}