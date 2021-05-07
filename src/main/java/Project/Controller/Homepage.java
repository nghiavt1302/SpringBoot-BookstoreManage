package Project.Controller;

import Project.Model.RequestModel.LoginRequest;
import Project.Model.RequestModel.RegisterRequest;
import Project.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.sql.SQLException;

@RestController
@RequestMapping(value = "/homepage")
public class Homepage {
    @Autowired
    UserService userService;

    @PostMapping(value = "/register")
    public String register(@RequestBody RegisterRequest registerRequest) {
        return  userService.register(registerRequest);
    }

    @PostMapping(value = "/login")
    public String login(@RequestBody LoginRequest loginRequest) throws SQLException {
        return userService.login(loginRequest);
    }
}


