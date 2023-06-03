package pl.sda.zdjavapol131.zdjavapol131.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.sda.zdjavapol131.zdjavapol131.repository.dao.ReservationEntity;
import pl.sda.zdjavapol131.zdjavapol131.service.ReservationService;

import java.util.List;

@RestController
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
}
