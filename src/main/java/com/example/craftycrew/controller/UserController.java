package com.example.craftycrew.controller;

import com.example.craftycrew.model.Users;
import com.example.craftycrew.payload.users.LoginRequest;
import com.example.craftycrew.payload.LoginResponse;
import com.example.craftycrew.payload.users.RegisterRequest;
import com.example.craftycrew.payload.RegisterResponse;
import com.example.craftycrew.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/users")
public class UserController{

    @Autowired
    UserService userService;

    @PostMapping("/login")
    public LoginResponse userLogin(@RequestBody LoginRequest loginRequest){
        Users user = userService.findUserByEmail(loginRequest.getEmail());
        if(user==null){
            return new LoginResponse(false,"Account does not exists");
        }
        if(!(user.getUserPassword().equals(loginRequest.getPassword()))){
            return new LoginResponse(false,"Incorrect password");
        }
        return new LoginResponse(true,"Login successful");
    }

    @PostMapping("/register")
    public RegisterResponse userRegister(@RequestBody RegisterRequest registerRequest){
        Users user = userService.findUserByEmail(registerRequest.getEmail());
        if(user!=null){
            return new RegisterResponse(false,"Account already exists");
        }
        user = new Users(registerRequest.getName(),registerRequest.getEmail(),registerRequest.getPassword(),registerRequest.getLocation());
        user = userService.addNewUser(user);
        if(user!=null){
            return new RegisterResponse(true,"Registration Successful");
        }
        return new RegisterResponse(false,"Unable to register now!");
    }

    @GetMapping("/{id}")
    public Users getUser(@PathVariable int id){
        return userService.findUserById(id);
    }
}
