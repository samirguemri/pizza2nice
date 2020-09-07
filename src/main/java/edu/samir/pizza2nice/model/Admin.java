package edu.samir.pizza2nice.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Admin extends Person{
    private String login;
    private String password;

    public Admin(
            @JsonProperty("firstName") String firstName,
            @JsonProperty("lastName") String lastName,
            @JsonProperty("address") String address,
            @JsonProperty("zipCode") String zipCode,
            @JsonProperty("login") String login,
            @JsonProperty("password") String password
    ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.zipCode = zipCode;
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
