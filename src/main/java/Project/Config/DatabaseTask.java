package Project.Config;

import Project.Model.BookEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
@Service
public class DatabaseTask {
    @Autowired
    Connection connection;

    public boolean checkEmailExist(String email) throws SQLException {
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

    public boolean checkPhoneExist(String phoneNum) throws SQLException {
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

    public boolean checkPassword(String phone, String password) throws SQLException {
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

    public void insertUserToDB(String email, String phoneNum, String password) throws SQLException {
        Statement stmt = connection.createStatement();
        String sql = "INSERT INTO customer(email,phone,password) VALUES('"+ email + "','" + phoneNum + "','" + password + "')";
        stmt.execute(sql);
    }

    public boolean checkIdExist(int id) throws SQLException {
        Statement stmt = connection.createStatement();
        String sql = "SELECT id FROM category;";
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            if (id == rs.getInt("id")) {
                return true;
            }
        }
        return false;
    }

    public List<BookEntity> getBookListByCategoryId(int id, String order) throws SQLException {
        ResultSet rs = QueryBookListByCategory(id, order);
        List<BookEntity> bookList = new ArrayList<>();
        while (rs.next()){
            String name = rs.getString("product_name");
            String category = rs.getString("name");
            String type = rs.getString("product_description");
            BookEntity newBook = new BookEntity(name, category, type);
            bookList.add(newBook);
        }
        for (BookEntity b : bookList){
            System.out.println(b.getName());
        }
        return bookList;
    }
    public ResultSet QueryBookListByCategory(int id, String order) throws SQLException {
        Statement stmt = connection.createStatement();
        String sql = "select * from getBookByCategory where id = " + id + " order by product_name " + order +";";
        ResultSet rs = stmt.executeQuery(sql);
        return rs;
    }

    public String getCategoryName(int id) throws SQLException {
        Statement stmt = connection.createStatement();
        String sql = "select * from category where id = " + id + ";";
        ResultSet rs = stmt.executeQuery(sql);
        rs.next();
        return rs.getString("name");
    }
}
