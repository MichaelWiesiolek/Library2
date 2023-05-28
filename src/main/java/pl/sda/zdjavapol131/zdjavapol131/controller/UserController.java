package pl.sda.zdjavapol131.zdjavapol131.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.zdjavapol131.zdjavapol131.service.UserService;

@RestController
public class UserController {
    private UserService userService;
    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }
}
