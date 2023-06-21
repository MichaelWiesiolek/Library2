package pl.sda.zdjavapol131.zdjavapol131.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.sda.zdjavapol131.zdjavapol131.model.dto.UserDto;
import pl.sda.zdjavapol131.zdjavapol131.repository.UserRepository;
import pl.sda.zdjavapol131.zdjavapol131.service.RegistrationService;
import pl.sda.zdjavapol131.zdjavapol131.service.UserService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class RegistrationController {
    private UserService userService;
    private UserRepository userRepository;
    private RegistrationService registrationService;

    @Autowired
    public RegistrationController(UserService userService, UserRepository userRepository, RegistrationService registrationService){
        this.userService = userService;
        this.userRepository = userRepository;
        this.registrationService = registrationService;
    }
    @GetMapping(path = "/register")
    public String register(){
        return "Register";
    }

    @PostMapping(path = "/register/new")
    public String registration(@Valid @RequestBody UserDto userDto){
       return registrationService.userRegistration(userDto);
    }

}
