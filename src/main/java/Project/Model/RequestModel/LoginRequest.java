package Project.Model.RequestModel;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class LoginRequest {
    private String phone;
    private String password;

    public LoginRequest(String phone, String password) {
        this.phone = phone;
        this.password = password;
    }
}
