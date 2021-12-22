package com.sda.patricban.bookstore.service;

import com.sda.patricban.bookstore.model.Role;
import com.sda.patricban.bookstore.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    void saveUser(String email, String password, Role role);
    User findUserByEmail(String email);
}
