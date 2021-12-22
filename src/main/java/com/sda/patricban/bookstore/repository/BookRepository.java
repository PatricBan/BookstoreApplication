package com.sda.patricban.bookstore.repository;


import com.sda.patricban.bookstore.model.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {
    Book findBookByIsbn(String isbn);
    List<Book> findAllByReleaseDateAfter(Date date);
    Optional<Book> findBookByTitle(String title);
    List<Book> findAllByReleaseDateBefore(Date date);
    List<Book> findAllByTitleIsLike(String keyword);
    void deleteBookById(Integer id);

}
