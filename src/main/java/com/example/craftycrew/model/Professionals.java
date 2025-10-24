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
public class Professionals {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;
    private String password;
    private String address;
    private String location;
    private String profession;

    public Professionals(String name, String email, String password, String address, String location, String profession) {
        this.name=name;
        this.email=email;
        this.password=password;
        this.address=address;
        this.location=location;
        this.profession=profession;
    }
}
