package com.json.handsonproblems.validemail;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class User {
    @NotBlank(message = "Email cannot be empty")
    @Email(message = "Invalid email format")
    private String email;


    public User() {}

    public User(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}
