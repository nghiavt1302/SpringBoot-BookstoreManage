package Project.Controller;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;


@RestController
@RequestMapping(value = "/homepage")
public class Register {
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public void PostRegisterInfor(@RequestBody RegisterInfor regIf) throws SQLException {
        String phoneNum = regIf.getPhone();
        String email = regIf.getEmail();
        String password = regIf.getPassword();

        if(phoneNum.matches("^\\d{10}$") && email.matches("^[\\w.+\\-]+@gmail\\.com$") && password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*d)[a-zA-Zd]{8,}$")){
            if (CheckingData.checkEmailExist(email) || CheckingData.checkPhoneExist(phoneNum)){
                System.out.println("The user already exists.");
            }else{
                DatabaseWorking.insertUserToDB(email, phoneNum, password);
                System.out.println("The new user has been added to the database.");
            }
        }
    }
}

@Getter @Setter
class RegisterInfor{
    private String email;
    private String password;
    private String phone;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

