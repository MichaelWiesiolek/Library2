package pl.sda.zdjavapol131.zdjavapol131.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.zdjavapol131.zdjavapol131.repository.BooksRepository;
import pl.sda.zdjavapol131.zdjavapol131.repository.dao.BooksEntity;

import java.sql.Date;

@Service
public class BooksService {
    private final BooksRepository booksRepository;

    @Autowired
    public BooksService(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }


    public void addNewBook(String author, String title, String publisher, String category, Date releaseDate){
        BooksEntity entity = new BooksEntity();
        entity.setAuthor(author);
        entity.setTitle(title);
        entity.setPublisher(publisher);
        entity.setCategory(category);
        entity.setReleaseDate(releaseDate);
    }
    public void removeBook(){

    }

}
