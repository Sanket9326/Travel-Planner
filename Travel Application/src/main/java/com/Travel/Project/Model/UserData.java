package com.Travel.Project.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class UserData {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Integer id;

    private String username;
    private String password;
    private String number;
    private String email;

    public UserData(String username, String password, String number, String email) {
        this.username = username;
        this.password = password;
        this.number = number;
        this.email = email;
    }

    public UserData() {

    }
}
