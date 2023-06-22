package pl.sda.zdjavapol131.zdjavapol131.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.sda.zdjavapol131.zdjavapol131.model.dto.UserDto;
import pl.sda.zdjavapol131.zdjavapol131.repository.UserRepository;
import pl.sda.zdjavapol131.zdjavapol131.repository.dao.UserEntity;
import pl.sda.zdjavapol131.zdjavapol131.service.RegistrationService;
import pl.sda.zdjavapol131.zdjavapol131.service.UserService;

import java.util.List;

@Controller
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
    @GetMapping("/register")
    public String showRegistrationForm(Model model){
        UserDto user = new UserDto();
        model.addAttribute("user", user);
        return "register";
    }

//    @PostMapping(path = "/register/save")
//    public String registration(@Valid @RequestBody UserDto userDto){
//       return registrationService.userRegistration(userDto);
//    }

    @PostMapping("/register/save")
    public String registration(@Valid @ModelAttribute("user") UserDto userDto, BindingResult result, Model model){
        UserEntity existingUser = userService.findUserByEmail(userDto.getEmail());

        if(existingUser != null && existingUser.getEmail() != null && !existingUser.getEmail().isEmpty()){
            result.rejectValue("email", null,
                    "There is already an account registered with the same email");
        }
        if(result.hasErrors()){
            model.addAttribute("user", userDto);
            return "/register";
        }
        userService.saveUser(userDto);
        return "redirect:/register?success";
    }

}
