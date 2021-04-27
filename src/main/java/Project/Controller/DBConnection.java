package Project.Controller;

import java.sql.*;

public class DBConnection {
    public static Connection DBConnect() throws SQLException {
        Connection connection = null;
        String url = "jdbc:mysql://localhost:3306/mydb";
        String user = "root";
        String pass = "nghiavt";

        connection = DriverManager.getConnection(url, user, pass);
        return connection;
    }

//    public static void main(String[] args) throws SQLException {
//        Connection connection = DBConnect();
//        Statement stmt = connection.createStatement();
//        String sql = "INSERT INTO customer(email,phone,password) VALUES('vtnghia01.bchkl@gmail.com', '0705088886', 'nghiavt')";
//        stmt.execute(sql);
//    }
}
