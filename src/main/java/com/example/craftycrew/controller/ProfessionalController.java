package com.example.craftycrew.controller;


import com.example.craftycrew.model.Professionals;
import com.example.craftycrew.payload.LoginResponse;
import com.example.craftycrew.payload.RegisterResponse;
import com.example.craftycrew.payload.professionals.RegisterRequest;
import com.example.craftycrew.payload.users.LoginRequest;
import com.example.craftycrew.service.ProfessionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/professionals")
public class ProfessionalController {

    @Autowired
    ProfessionalService profService;

    @PostMapping("/login")
    public LoginResponse professionalLogin(@RequestBody LoginRequest loginRequest){
        Professionals prof = profService.findProfessionalByEmail(loginRequest.getEmail());
        if(prof==null){
            return new LoginResponse(false,"Account does not exists");
        }
        if(!prof.getPassword().equals(loginRequest.getPassword())){
            return new LoginResponse(false,"Incorrect credentials");
        }
        return new LoginResponse(true,"Login successful");
    }

    @PostMapping("/register")
    public RegisterResponse professionalRegister(@RequestBody RegisterRequest registerRequest){
        Professionals prof = profService.findProfessionalByEmail(registerRequest.getEmail());
        if(prof!=null){
            return new RegisterResponse(false,"Account already exists");
        }
        prof = new Professionals(registerRequest.getName(),registerRequest.getEmail(), registerRequest.getPassword(), registerRequest.getAddress(), registerRequest.getLocation(), registerRequest.getProfession());
        prof = profService.addNewProfessional(prof);
        if(prof!=null){
            return new RegisterResponse(true,"Registration successful");
        }
        return new RegisterResponse(false,"Unable to register now!");
    }
}
