package pl.sda.zdjavapol131.zdjavapol131.repository.dao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.sda.zdjavapol131.zdjavapol131.model.dto.BookDto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Entity
@Data
@Table(name = "reservations")
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class ReservationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "email")
    private String email;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "lendingDate")
    private LocalDate lendingDate;
    @Column(name ="returnDate")
    private LocalDate returnDate;
    @OneToMany(mappedBy = "reservationContent", cascade = CascadeType.ALL)
    private List<BooksEntity> reservationContent = new ArrayList<>();


}
