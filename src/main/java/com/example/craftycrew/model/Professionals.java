package com.example.craftycrew.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

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
    private double rating;
    @OneToMany
    private List<Reviews> reviews;

    public Professionals(String name, String email, String password, String address, String location, String profession) {
        this.name=name;
        this.email=email;
        this.password=password;
        this.address=address;
        this.location=location;
        this.profession=profession;
        this.rating=0;
        this.reviews=new ArrayList<Reviews>();
    }
}
