package pl.sda.zdjavapol131.zdjavapol131.model.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ReservationRequest {
    private String email;
    private String phoneNumber;
    private String lendingDate;
}
