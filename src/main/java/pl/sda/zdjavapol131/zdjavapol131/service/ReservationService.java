package pl.sda.zdjavapol131.zdjavapol131.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.sda.zdjavapol131.zdjavapol131.model.dto.ReservationRequest;
import pl.sda.zdjavapol131.zdjavapol131.repository.BooksRepository;
import pl.sda.zdjavapol131.zdjavapol131.repository.ReservationRepository;
import pl.sda.zdjavapol131.zdjavapol131.repository.dao.BooksEntity;
import pl.sda.zdjavapol131.zdjavapol131.repository.dao.ReservationEntity;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;
    private final BooksRepository booksRepository;

    @Autowired
    public ReservationService(ReservationRepository reservationRepository, BooksRepository booksRepository) {
        this.reservationRepository = reservationRepository;
        this.booksRepository = booksRepository;
    }
    @Transactional
    public void createReservation(ReservationRequest reservationRequest) {
        ReservationEntity newReservation = new ReservationEntity();
        newReservation.setEmail(reservationRequest.getEmail());
        newReservation.setPhoneNumber(reservationRequest.getPhoneNumber());
        newReservation.setLendingDate(reservationRequest.getLendingDate());
        newReservation.setReturnDate(reservationRequest.getLendingDate().plusDays(14));
        List<Integer> list= reservationRequest.getReservationContent();
        List<BooksEntity> allById = booksRepository.findAllById(list);
        newReservation.setReservationContent(allById);
        ReservationEntity save = reservationRepository.save(newReservation);
        allById.forEach(x -> x.setReservationContent(save));
    }

    public List<ReservationEntity> getAllReservations(){
     List<ReservationEntity> reservations = reservationRepository.findAll();
      return reservations;
    }
}

