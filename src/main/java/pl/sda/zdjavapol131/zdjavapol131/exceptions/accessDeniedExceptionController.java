package pl.sda.zdjavapol131.zdjavapol131.exceptions;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@CrossOrigin(origins = "http://localhost:4200")
public class accessDeniedExceptionController {

    @GetMapping("/accessDenied")
    public String showReservationForm(){
        return "/accessDeniedException";
    }
}
