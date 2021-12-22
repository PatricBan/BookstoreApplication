package com.sda.patricban.bookstore.controller;


import com.sda.patricban.bookstore.controller.dto.BookDto;
import com.sda.patricban.bookstore.model.Book;
import com.sda.patricban.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

@Controller
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // bindingResult ne zice daca avem erori
    @PostMapping("/addBook")
    public String addBook(@Valid @ModelAttribute(name="book") BookDto bookDto, BindingResult bindingResult, Model model) throws ParseException {
        if (bindingResult.hasErrors()) {
            return "createBook";
        }

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        bookService.save(bookDto.getIsbn(), bookDto.getTitle(), bookDto.getDescription(), formatter.parse(bookDto.getReleaseDate()));

        return "redirect:/";

        //  model.addAttribute("bookList", bookService.findAll());
        //  return "index";
    }

    @GetMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable(name = "id") Integer id) {
        bookService.deleteBook(id);
        return "redirect:/";
    }

    @PostMapping("/updateBook/{id}")
    public String updateBook(@PathVariable(name = "id") Integer id, @Valid BookDto bookDto, BindingResult bindingResult, Model model) throws ParseException {
        if (bindingResult.hasErrors()) {
            model.addAttribute("book", bookDto);
            return "updateBook";
        }

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);

        Book book = new Book(bookDto.getIsbn(),
                bookDto.getTitle(),
                bookDto.getDescription(),
                formatter.parse(bookDto.getReleaseDate()));
        book.setId(bookDto.getId());

        bookService.update(book);

        return "redirect:/";
    }
}









