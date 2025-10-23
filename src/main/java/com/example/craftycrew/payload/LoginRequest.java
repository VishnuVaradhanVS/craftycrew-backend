package com.example.craftycrew.payload;

import com.example.craftycrew.util.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class LoginRequest {
    private String email;
    private String password;
    private Role role;
}
