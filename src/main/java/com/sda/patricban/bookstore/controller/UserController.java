package com.sda.patricban.bookstore.controller;

import com.sda.patricban.bookstore.controller.dto.UserRegistrationDto;
import com.sda.patricban.bookstore.model.Role;
import com.sda.patricban.bookstore.model.User;
import com.sda.patricban.bookstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/registration")
    public String registerUser(@Valid @ModelAttribute(name = "user") UserRegistrationDto userRegistrationDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "register";
        }

        User user = userService.findUserByEmail(userRegistrationDto.getEmail());
        if (user != null) {
            bindingResult.rejectValue("email", null, "User with this email already registered");
            return "register";
        }
        userService.saveUser(userRegistrationDto.getEmail(), userRegistrationDto.getPassword(), Role.CUSTOMER);
        return "redirect:/registration?success";

    }

    @PostMapping("/create-admin")
    public String registerAdmin(@Valid @ModelAttribute(name = "user") UserRegistrationDto userRegistrationDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "create-admin"; //numele fisierului html
        }

        User user = userService.findUserByEmail(userRegistrationDto.getEmail());
        if (user != null) {
            bindingResult.rejectValue("email", null, "User with this email already registered");
            return "create-admin";
        }
        userService.saveUser(userRegistrationDto.getEmail(), userRegistrationDto.getPassword(), Role.ADMIN);
        return "redirect:/home-admin"; //redirect nu reincarca pagina

    }

}
