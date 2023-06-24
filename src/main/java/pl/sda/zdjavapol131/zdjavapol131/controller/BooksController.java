package pl.sda.zdjavapol131.zdjavapol131.controller;

import jakarta.validation.Valid;
import org.attoparser.dom.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.sda.zdjavapol131.zdjavapol131.enums.UserRole;
import pl.sda.zdjavapol131.zdjavapol131.model.dto.BookDto;
import pl.sda.zdjavapol131.zdjavapol131.model.dto.UserDto;
import pl.sda.zdjavapol131.zdjavapol131.repository.dao.BooksEntity;
import pl.sda.zdjavapol131.zdjavapol131.repository.dao.UserEntity;
import pl.sda.zdjavapol131.zdjavapol131.service.BooksService;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Controller
@CrossOrigin(origins = "http://localhost:4200")
public class BooksController {
    private BooksService booksService;

    @Autowired
    public BooksController(BooksService booksService){this.booksService = booksService;}


//    @GetMapping("/books")
//   public String getAllBooks(Model model) {
//        List<BooksEntity> books = booksService.getAllBooks();
//        model.addAttribute("books",books);
//        return "books";
//    }

    @RequestMapping(method = RequestMethod.GET, path = "/books", params = {"sortBy"})
    public List<BooksEntity> getSortedBooks(@RequestParam(name = "sortBy", required = false) String parameter) {
        return booksService.getSortedBooks(parameter);
    }

    @GetMapping(value = "/books")
    public String viewIndexPage() {
        // During the index page we are using the sort-field as id and sort-dir as asc.
        return "redirect:page/1?sort-field=id&sort-dir=asc";
    }

    @GetMapping(value = "/page/{page-number}")
    public String findPaginated(@PathVariable(name = "page-number") final int pageNo,
                                @RequestParam(name = "sort-field") final String sortField,
                                @RequestParam(name = "sort-dir") final String sortDir,
                                final Model model) {
        final int pageSize = 10;
        final Page<BooksEntity> page = booksService.findPaginated(pageNo, pageSize, sortField, sortDir);
        final List<BooksEntity> listBooks = page.getContent();

        // Creating the model response.
        // Note for simplicity purpose we are not making the use of ResponseDto here.
        // In ideal cases the response will be encapsulated in a class.
        // pagination parameters
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        // sorting parameters
        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
        // employees
        model.addAttribute("listBook", listBooks);
        return "books";
    }
    @GetMapping("/book")
    public String showCreationForm(Model model){
        BookDto book = new BookDto();
        List<String> listCategory = booksService.getCategories();
        model.addAttribute("listCategory",listCategory);
        model.addAttribute("book", book);
        return "book";
    }


    @PostMapping("/book/new")
    public String registration(@ModelAttribute("user") BookDto bookDto, BindingResult result, Model model){

        if(result.hasErrors()){
            model.addAttribute("book", bookDto);
            return "/book";
        }
        booksService.createNewBook(bookDto);
        return "redirect:/book?success";
    }










}
