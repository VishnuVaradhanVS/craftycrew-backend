package com.example.craftycrew.payload.users;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class RegisterRequest {
    private String name;
    private String email;
    private String password;
    private String location;
}
