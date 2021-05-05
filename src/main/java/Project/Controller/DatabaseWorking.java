package Project.Controller;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseWorking {
    public static void insertUserToDB(String email, String phoneNum, String password) throws SQLException {
        Connection connection = DBConnection.DBConnect();
        Statement stmt = connection.createStatement();
        String sql = "INSERT INTO customer(email,phone,password) VALUES("+ email + "," + phoneNum + "," + password + ")";
        stmt.execute(sql);
    }

    public static List<Book> getBookListByCategoryId(int id) throws SQLException {
        ResultSet rs = QueryBookListByCategory(id);
        List<Book> bookList = new ArrayList<>();
        while (rs.next()){
            Book newBook = new Book(rs.getString("product_name"), rs.getString("name"), rs.getString("product_description"));
            bookList.add(newBook);
        }
        for (Book b : bookList){
            System.out.println(b.getName());
        }
        return bookList;
    }
    public static ResultSet QueryBookListByCategory(int id) throws SQLException {
        Connection cnt = DBConnection.DBConnect();
        Statement stmt = cnt.createStatement();
        String sql = "select * from getBookByCategory where id = 1 " ;
        ResultSet rs = stmt.executeQuery(sql);
        return rs;
    }
}
