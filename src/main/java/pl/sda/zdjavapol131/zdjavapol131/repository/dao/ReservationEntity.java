package pl.sda.zdjavapol131.zdjavapol131.repository.dao;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;


@Entity
@Data
@Table(name = "reservation")

public class ReservationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "email")
    private String email;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "lendingDate")
    private String lendingDate;
    @Column(name ="returnDate")
    private String returnDate;
    //@Column(name = "basket")
    //private List<BooksEntity> basket;
}
