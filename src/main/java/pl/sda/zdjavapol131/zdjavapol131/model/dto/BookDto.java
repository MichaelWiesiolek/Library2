package pl.sda.zdjavapol131.zdjavapol131.model.dto;

import jakarta.persistence.Column;
import lombok.Data;

import java.time.LocalDate;

@Data
public class BookDto {
    private  int id;
    private String author;
    private String title;
    private String publisher;
    private String category;
    private LocalDate releaseDate;
}
