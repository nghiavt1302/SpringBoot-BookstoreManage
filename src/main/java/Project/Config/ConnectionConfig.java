package Project.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
public class ConnectionConfig {

    @Bean
    Connection DBConnect()  {
        Connection connection = null;
        String url = "jdbc:mysql://localhost:3306/mydb";
        String user = "root";
        String pass = "nghiavt";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            if (connection == null){
                connection = DriverManager.getConnection(url, user, pass);
            }
            else return connection;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
