package pl.sda.zdjavapol131.zdjavapol131.controller;

import org.junit.jupiter.api.Test;
import org.mockito.stubbing.OngoingStubbing;
import pl.sda.zdjavapol131.zdjavapol131.repository.dao.BooksEntity;
import pl.sda.zdjavapol131.zdjavapol131.service.BooksService;
import java.text.AttributedString;
import java.util.List;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class BooksControllerTest {

    private BooksService booksService;
    private AttributedString model;

    BooksControllerTest(BooksService booksService, AttributedString model) {
        this.booksService = booksService;
        this.model = model;
    }

    // @Test
    // void getSortedBooks() {
    //     //given
    //     BooksController booksController = mock(BooksController.class);
    //     //when

    //     //then
    //    // private List<BooksEntity> prepareMockData() {
    //         List<BooksEntity> books;
    //         books = booksService.getAllBooks();
    //         // model.addAttribute("books",books);
    //     }
    // }
}