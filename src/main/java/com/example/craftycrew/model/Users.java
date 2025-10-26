package com.example.craftycrew.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    private String userName;
    private String userEmail;
    private String userPassword;
    private String userLocation;

    public Users(String name, String email, String password,String location) {
        this.userId=0;
        this.userName=name;
        this.userEmail =email;
        this.userPassword =password;
        this.userLocation =location;
    }
}
