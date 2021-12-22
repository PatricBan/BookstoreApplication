package com.sda.patricban.bookstore.service;

import com.sda.patricban.bookstore.model.Book;
import com.sda.patricban.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> findAll() {

        List<Book> bookList = new ArrayList<>();
        bookRepository.findAll().forEach(book -> bookList.add(book));
        return bookList;
    }

    @Override
    public void save(String isbn, String title, String description, Date releaseDate) {
        Book book = new Book(isbn, title, description, releaseDate);
        bookRepository.save(book);
    }

    @Override
    public void update(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void delete(Book book) {
        bookRepository.delete(book);
    }

    @Override
    @Transactional
    public void deleteBook(Integer id) {
        bookRepository.deleteBookById(id);
    }

    @Override
    public Book findBookByIsbn(String isbn) {
        return bookRepository.findBookByIsbn(isbn);
    }

    @Override
    public Book findBookById(Integer id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public List<Book> findAllByReleaseDateAfter(Date date) {
        return bookRepository.findAllByReleaseDateAfter(date);
    }

    @Override
    public List<Book> findAllByTitleIsLike(String keyword) {
        return bookRepository.findAllByTitleIsLike(keyword);
    }

    @Override
    public List<Book> findAllByReleaseDateBefore(Date date) {
        return bookRepository.findAllByReleaseDateBefore(date);

    }


}
