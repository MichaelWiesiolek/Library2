package pl.sda.zdjavapol131.zdjavapol131.repository.dao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Table(name = "books")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BooksEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private int Id;
    @Column(name = "author")
    private String author;
    @Column(name = "title")
    private String title;
    @Column(name = "publisher")
    private String publisher;
    @Column(name = "category")
    private String category;
    @Column(name = "release_date")
    private LocalDate releaseDate;
    @ManyToOne(fetch = FetchType.LAZY)
    private ReservationEntity reservationContent;

}
