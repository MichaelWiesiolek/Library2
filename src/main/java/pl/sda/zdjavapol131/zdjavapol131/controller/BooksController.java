package pl.sda.zdjavapol131.zdjavapol131.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.zdjavapol131.zdjavapol131.service.BooksService;

@RestController
public class BooksController {
    private BooksService booksService;

    @Autowired
    public BooksController(BooksService booksService){this.booksService = booksService;}


}
