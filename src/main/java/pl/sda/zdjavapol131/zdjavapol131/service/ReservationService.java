package pl.sda.zdjavapol131.zdjavapol131.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.zdjavapol131.zdjavapol131.model.dto.ReservationRequest;
import pl.sda.zdjavapol131.zdjavapol131.repository.ReservationRepository;
import pl.sda.zdjavapol131.zdjavapol131.repository.dao.ReservationEntity;

import java.util.List;

@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;

    @Autowired
    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public void createReservation(ReservationRequest reservationRequest) {
        ReservationEntity newReservation = new ReservationEntity();
        newReservation.setEmail(reservationRequest.getEmail());
        newReservation.setPhoneNumber(reservationRequest.getPhoneNumber());
        reservationRepository.save(newReservation);
    }

    public List<ReservationEntity> getAllReservations(){
     List<ReservationEntity> reservations = reservationRepository.findAll();
      return reservations;
    }
}

