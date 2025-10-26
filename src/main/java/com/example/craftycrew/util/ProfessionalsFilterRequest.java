package com.example.craftycrew.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

@AllArgsConstructor
@Getter
@Setter
public class ProfessionalsFilterRequest {
    private String location;
    private String profession;
    private double minRating;
}
