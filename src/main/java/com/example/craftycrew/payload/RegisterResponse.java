package com.example.craftycrew.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class RegisterResponse {
    private boolean status;
    private String message;
}
