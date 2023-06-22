package pl.sda.zdjavapol131.zdjavapol131.controller;

import org.attoparser.dom.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.sda.zdjavapol131.zdjavapol131.model.dto.BookDto;
import pl.sda.zdjavapol131.zdjavapol131.repository.dao.BooksEntity;
import pl.sda.zdjavapol131.zdjavapol131.service.BooksService;

import java.util.List;

@Controller
@CrossOrigin(origins = "http://localhost:4200")
public class BooksController {
    private BooksService booksService;

    @Autowired
    public BooksController(BooksService booksService){this.booksService = booksService;}


    @GetMapping("/books")
   public String getAllBooks(Model model) {
        List<BooksEntity> books = booksService.getAllBooks();
        model.addAttribute("books",books);
        return "books";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/books", params = {"sortBy"})
    public List<BooksEntity> getSortedBooks(@RequestParam(name = "sortBy", required = false) String parameter) {
        return booksService.getSortedBooks(parameter);
    }










}
