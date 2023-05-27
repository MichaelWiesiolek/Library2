package pl.sda.zdjavapol131.zdjavapol131.dataProvider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.sda.zdjavapol131.zdjavapol131.repository.BooksRepository;

import java.sql.Date;

@Component
public class BookIndexH2DataProvider implements CommandLineRunner {
    private final BooksRepository booksRepository;
    @Autowired
    public BookIndexH2DataProvider(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    @Override
    public void run(String... args) throws Exception {


    }
}
