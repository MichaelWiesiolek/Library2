package pl.sda.zdjavapol131.zdjavapol131.controller;

import com.paypal.orders.PaymentMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import pl.sda.zdjavapol131.zdjavapol131.service.CustomUserDetailsService;
import pl.sda.zdjavapol131.zdjavapol131.service.ReservationService;
import pl.sda.zdjavapol131.zdjavapol131.service.UserService;

@Controller
public class DeliveryController {
    private UserService userService;
    private CustomUserDetailsService customUserDetailsService;
    private PaymentMethod paymentMethod;
    public ReservationService reservationService;

    @Autowired
    public DeliveryController(UserService userService, CustomUserDetailsService customUserDetailsService){
        this.userService = userService;
        this.customUserDetailsService = customUserDetailsService;
        this.paymentMethod = new PaymentMethod();
    }
    @GetMapping("/delivery")
    public String home(){
        return "/delivery";
    }
}
