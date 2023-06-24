package pl.sda.zdjavapol131.zdjavapol131.model.dto;

import lombok.Data;
import pl.sda.zdjavapol131.zdjavapol131.repository.dao.BooksEntity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class ReservationRequest {
    private String email;
    private String phoneNumber;
    private LocalDate lendingDate;
    private List<Integer> reservationContent = new ArrayList<>();
}
