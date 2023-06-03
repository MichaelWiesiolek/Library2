package pl.sda.zdjavapol131.zdjavapol131.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.sda.zdjavapol131.zdjavapol131.repository.dao.BooksEntity;
import pl.sda.zdjavapol131.zdjavapol131.service.BooksService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class BooksController {
    private BooksService booksService;

    @Autowired
    public BooksController(BooksService booksService){this.booksService = booksService;}


    //@RequestMapping(method = RequestMethod.GET, path = "/books")
   // public List<BooksEntity> getAllBooks() {return booksService.getAllBooks();}

    @RequestMapping(method = RequestMethod.GET, path = "/books", params = {"sortBy"})
    public List<BooksEntity> getSortedBooks(@RequestParam(name = "sortBy", required = false) String parameter) {
        return booksService.getSortedBooks(parameter);
    }




}
