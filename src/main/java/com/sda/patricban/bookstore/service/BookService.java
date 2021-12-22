package com.sda.patricban.bookstore.service;

import com.sda.patricban.bookstore.model.Book;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface BookService {

    void save(String isbn, String title, String description, Date releaseDate);
    void update(Book book);
    void delete(Book book);
    void deleteBook(Integer id);


    Book findBookByIsbn(String isbn);
    Book findBookById(Integer id);
    List<Book> findAll();
    List<Book> findAllByReleaseDateAfter(Date date);
    List<Book> findAllByTitleIsLike(String keyword);
    List<Book> findAllByReleaseDateBefore(Date date);


}
