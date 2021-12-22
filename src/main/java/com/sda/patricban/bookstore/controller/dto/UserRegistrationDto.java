package com.sda.patricban.bookstore.controller.dto;

import com.sda.patricban.bookstore.constraint.FieldMatch;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@FieldMatch.List({
        @FieldMatch(first = "password", second = "confirmPassword", message = "Passwords do not match")
})
public class UserRegistrationDto {

    @Email
    @NotEmpty
    private String email;

    @NotEmpty
    @Size(min = 6, max = 30)
    private String password;

    @NotEmpty
    @Size(min = 6, max = 30)
    private String confirmPassword;

    public UserRegistrationDto() {
    }

    public UserRegistrationDto(String email, String password, String confirmPassword) {
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
