package pl.sda.zdjavapol131.zdjavapol131.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.sda.zdjavapol131.zdjavapol131.model.dto.ReservationRequest;
import pl.sda.zdjavapol131.zdjavapol131.repository.dao.ReservationEntity;
import pl.sda.zdjavapol131.zdjavapol131.service.ReservationService;

import java.util.List;

@Controller
@CrossOrigin(origins = "http://localhost:4200")
public class ReservationController {

    private ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }


    @RequestMapping(method = RequestMethod.GET, path = "/reservation")
    public List<ReservationEntity> getAllReservations() {
        return reservationService.getAllReservations();
    }
    @GetMapping("/showReservations")
    public String showReservations(Model model) {
        List<ReservationEntity> showReservations = reservationService.getAllReservations();
        model.addAttribute("showReservations", showReservations);
        return "showReservations";
    }

    @GetMapping("/reservations")
    public String showReservationForm(Model model){
        ReservationRequest reservationRequest = new ReservationRequest();
        List<Integer> allIds = reservationService.getAllIds();
        model.addAttribute("allIds", allIds);
        model.addAttribute("reservationRequest", reservationRequest);
        return "reservations";
    }

    @PostMapping("/reservations/save")
    public String registration(@Valid @ModelAttribute("reservationRequest") ReservationRequest reservationRequest, BindingResult result, Model model){

        if(result.hasErrors()){
            model.addAttribute("reservationRequest", reservationRequest);
            return "/reservations";
        }
        reservationService.createReservation(reservationRequest);
        return "redirect:/reservations?success";
    }
}


