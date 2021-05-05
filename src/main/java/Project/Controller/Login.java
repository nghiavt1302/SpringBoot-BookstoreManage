package Project.Controller;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.sql.SQLException;

@RestController
@RequestMapping(value = "/homepage")
public class Login {
    @PostMapping(value = "/login")
    public void login(@RequestBody LoginInfor loginInfor) throws SQLException {
        String phone = loginInfor.getPhone();
        String password = loginInfor.getPassword();
        if(!CheckingData.checkPhoneExist(phone)){
            System.out.println("Not registered.");
        }
        else if (CheckingData.checkPassword(phone, password)) {
            System.out.println("Login success!");
        }
    }

}

@Getter @Setter
class LoginInfor{
    private String phone;
    private String password;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}