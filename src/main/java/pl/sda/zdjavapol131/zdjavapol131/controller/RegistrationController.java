package pl.sda.zdjavapol131.zdjavapol131.controller;

import ch.qos.logback.core.joran.conditional.IfAction;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import pl.sda.zdjavapol131.zdjavapol131.model.dto.UserDto;
import pl.sda.zdjavapol131.zdjavapol131.repository.UserRepository;
import pl.sda.zdjavapol131.zdjavapol131.repository.dao.UserEntity;
import pl.sda.zdjavapol131.zdjavapol131.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class RegistrationController {
    private UserService userService;
    private UserRepository userRepository;

    public RegistrationController(UserService userService, UserRepository userRepository){
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @PostMapping(path = "/register")
    public String registration(@RequestBody UserDto userDto){
        UserEntity existingUser = userService.findByEmail(userDto.getEmail());

        if (existingUser != null){
            return "There is already an account registered with that email";
        }
        else{ userService.saveUser(userDto);
            return "Registered";
        }
    }

}
