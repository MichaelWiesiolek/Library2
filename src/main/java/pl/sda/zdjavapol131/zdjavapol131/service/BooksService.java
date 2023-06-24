package pl.sda.zdjavapol131.zdjavapol131.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pl.sda.zdjavapol131.zdjavapol131.model.dto.BookDto;
import pl.sda.zdjavapol131.zdjavapol131.repository.BooksRepository;
import pl.sda.zdjavapol131.zdjavapol131.repository.dao.BooksEntity;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class BooksService {
    private final BooksRepository booksRepository;

    @Autowired
    public BooksService(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }


    public void addNewBook(String author, String title, String publisher, String category, LocalDate releaseDate) {
        BooksEntity entity = new BooksEntity();
        entity.setAuthor(author);
        entity.setTitle(title);
        entity.setPublisher(publisher);
        entity.setCategory(category);
        entity.setReleaseDate(releaseDate);
        booksRepository.save(entity);
    }


    public void removeBook(int id) {
        booksRepository.deleteById(id);
    }

    public void createNewBook (BookDto bookDto){
        BooksEntity newBook = new BooksEntity();
        newBook.setAuthor(bookDto.getAuthor());
        newBook.setTitle(bookDto.getTitle());
        newBook.setPublisher(bookDto.getPublisher());
        newBook.setReleaseDate(bookDto.getReleaseDate());
        newBook.setCategory(bookDto.getCategory());
        booksRepository.save(newBook);
    }

    public List<BooksEntity> getAllBooks() {
        List<BooksEntity> allBooks = booksRepository.findAll();
        return allBooks;
    }
    public List<String> getCategories(){
        List<String> listCategory = Arrays.asList("Romance", "Fiction", "Fantasy", "Mystery", "Thriller", "Horror", "Adventure", "Western", "Crime", "Dystopian",
                "Children's Literature", "Comedy", "Tragedy", "Mythology", "Biography", "Essay", "Memoir", "Drama", "Poetry","Historical");
        Collections.sort(listCategory);
        return listCategory;
    }

    public List<BooksEntity> getSortedBooks(String parameter) {
        List<BooksEntity> allBooks = booksRepository.findAll();
        switch (parameter) {
            case "author" -> {
                allBooks.sort(Comparator.comparing(BooksEntity::getAuthor));
                return allBooks;
            }
            case "title" -> {
                allBooks.sort(Comparator.comparing(BooksEntity::getTitle));
                return allBooks;
            }
            case "publisher" -> {
                allBooks.sort(Comparator.comparing(BooksEntity::getPublisher));
                return allBooks;
            }
            case "category" -> {
                allBooks.sort(Comparator.comparing(BooksEntity::getCategory));
                return allBooks;
            }
            case "releaseDate" -> {
                allBooks.sort(Comparator.comparing(BooksEntity::getReleaseDate));
                return allBooks;
            }
            default -> {
                return allBooks;
            }
        }
    }


    public Page<BooksEntity> findPaginated(int pageNumber, final int pageSize, final String sortField, final String sortDirection) {
        final Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ?
                Sort.by(sortField).ascending() : Sort.by(sortField).descending();
        final Pageable pageable = PageRequest.of(pageNumber - 1, pageSize, sort);
        return booksRepository.findAll(pageable);
    }
}

