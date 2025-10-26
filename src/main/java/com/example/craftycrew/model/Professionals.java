package com.example.craftycrew.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private int profId;
    private String profName;
    private String profEmail;
    private String profPassword;
    private String profAddress;
    private String profLocation;
    private String profProfession;
    private double profRating;
    private int reviewCount;

    public Professionals(String name, String email, String profPassword, String address, String location, String profession) {
        this.profName =name;
        this.profEmail =email;
        this.profPassword = profPassword;
        this.profAddress =address;
        this.profLocation =location;
        this.profProfession =profession;
        this.profRating =0;
        this.reviewCount=0;
    }
}
