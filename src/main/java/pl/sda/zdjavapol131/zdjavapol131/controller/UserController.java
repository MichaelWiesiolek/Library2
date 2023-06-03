package pl.sda.zdjavapol131.zdjavapol131.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.sda.zdjavapol131.zdjavapol131.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
    private UserService userService;
    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping(path ="/users",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createReservation(@RequestBody String email, Integer phoneNumber){

        return new ResponseEntity<>(email + " "+ phoneNumber, HttpStatus.CREATED);
    }
}
