package com.sda.patricban.bookstore.repository;

import com.sda.patricban.bookstore.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.ResponseEntity;

public interface UserRepository extends CrudRepository<User, Integer> {

     User findUserByEmail(String email);


}
