package pl.sda.zdjavapol131.zdjavapol131.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.sda.zdjavapol131.zdjavapol131.repository.UserRepository;
import pl.sda.zdjavapol131.zdjavapol131.repository.dao.UserEntity;
import pl.sda.zdjavapol131.zdjavapol131.service.UserService;

import java.util.List;

@Controller
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
    private UserService userService;
    private UserRepository userRepository;

    @Autowired
    public UserController(UserService userService, UserRepository userRepository){
        this.userService = userService;
        this.userRepository = userRepository;
    }


    @GetMapping("/users")
    public String showReservationForm(Model model){
        List<UserEntity> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "users";
    }


//    @ResponseStatus(HttpStatus.CREATED)
//    @PostMapping(path ="/users/createReservation",
//            consumes = MediaType.APPLICATION_JSON_VALUE,
//            produces = MediaType.APPLICATION_JSON_VALUE)
//    public void createReservation(@RequestBody ReservationRequest request){
//        userService.createReservation(request.getEmail(),request.getPhoneNumber());
//    }


}
