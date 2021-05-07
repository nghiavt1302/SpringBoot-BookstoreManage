package Project.Services;

import Project.Config.DatabaseTask;
import Project.Model.RequestModel.LoginRequest;
import Project.Model.RequestModel.RegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.SQLException;

@Service
public class UserService {

    @Autowired
    DatabaseTask databaseTask;

    public String login(LoginRequest loginRequest){
        String phone = loginRequest.getPhone();
        String pass = loginRequest.getPassword();
        try {
            if (!databaseTask.checkPhoneExist(phone)){
                return "Phone number not found!";
            }else{
                if (!databaseTask.checkPassword(phone, pass)){
                    return "Wrong password!";
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Login Success!";
    }

    public String register(RegisterRequest registerRequest){
        String email = registerRequest.getEmail();
        String phone = registerRequest.getPhone();
        String pass = registerRequest.getPassword();

        if(phone == null || phone.equals("") || phone.length() != 10){
            return "Invalid phone number.";
        }

        if(email == null || email.equals("") || !email.contains("@gmail.com")){
            return "Invalid email address.";
        }

        if (pass == null || pass.equals("") || pass.length() < 8){
            return "Invalid password.";
        }

        try {
            if(databaseTask.checkEmailExist(email)){
                return "Email already exists.";
            }
            else if(databaseTask.checkPhoneExist(phone)){
                return "Phone number already exists.";
            }else {
                databaseTask.insertUserToDB(email, phone, pass);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Success!";
    }
}
