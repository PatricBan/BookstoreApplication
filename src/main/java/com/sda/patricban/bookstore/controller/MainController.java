package com.sda.patricban.bookstore.controller;


import com.sda.patricban.bookstore.controller.dto.BookDto;
import com.sda.patricban.bookstore.controller.dto.UserRegistrationDto;
import com.sda.patricban.bookstore.model.Book;
import com.sda.patricban.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

/**
 * se va ocupa cu redirectarea paginilor
 */

@Controller
public class MainController {

    private BookService bookService;

    @Autowired
    public MainController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/")
    public String getFirstPage(Model model) {
        populateHomepage(model);
        return "index";
    }



    @GetMapping("/createBook")
    public String createBook(Model model) {
        model.addAttribute("book", new Book());
        return "createBook";
    }

    @GetMapping("/updateBook/{id}")
    public String updateBook(@PathVariable(name="id") Integer id, Model model) {
        Book book = bookService.findBookById(id);

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);

        BookDto bookDto = new BookDto();
        bookDto.setIsbn(book.getIsbn());
        bookDto.setTitle(book.getTitle());
        bookDto.setDescription(book.getDescription());
        bookDto.setReleaseDate(formatter.format(book.getReleaseDate()));
        bookDto.setId(book.getId());

        model.addAttribute("book", bookDto);
        return "updateBook";
    }

    /**
     * url-ul din security configuration de la
     * .formLogin().loginPage("/login").permitAll()
     */
    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/registration")
    public String registration(Model model){
        model.addAttribute("user", new UserRegistrationDto());
        return "register";
    }

    @GetMapping("/home-admin")
    public String homePageAdmin(Model model) {
        populateHomepage(model);
        return "home-admin";
    }

    private void populateHomepage(Model model) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        List<BookDto> bookList = bookService.findAll()
                .stream()
                .map(book -> new BookDto(
                        book.getDescription(),
                        book.getTitle(),
                        formatter.format(book.getReleaseDate()),
                        book.getId(),
                        book.getIsbn()))
                .collect(Collectors.toList());

        model.addAttribute("bookList", bookList);
    }


    @GetMapping("/create-admin")
    public String createAdmin(Model model){
            model.addAttribute("user", new UserRegistrationDto());
            return "create-admin";
    }

}

























