package com.example.craftycrew.controller;


import com.example.craftycrew.model.Professionals;
import com.example.craftycrew.payload.LoginResponse;
import com.example.craftycrew.payload.RegisterResponse;
import com.example.craftycrew.payload.professionals.RegisterRequest;
import com.example.craftycrew.payload.users.LoginRequest;
import com.example.craftycrew.service.ProfessionalService;
import com.example.craftycrew.util.ProfessionalsFilterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professionals")
public class ProfessionalController {

    @Autowired
    ProfessionalService profService;

    @PostMapping("/login")
    public LoginResponse professionalLogin(@RequestBody LoginRequest loginRequest){
        Professionals prof = profService.findProfessionalByEmail(loginRequest.getEmail());
        if(prof==null){
            return new LoginResponse(false,"Account does not exists",-1);
        }
        if(!prof.getProfPassword().equals(loginRequest.getPassword())){
            return new LoginResponse(false,"Incorrect credentials",-1);
        }
        return new LoginResponse(true,"Login successful",prof.getProfId());
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

    @PostMapping("/filter")
    public List<Professionals> filterProfs(@RequestBody ProfessionalsFilterRequest professionalsFilterRequest){
        return profService.getProfessionalsByFilter(professionalsFilterRequest);
    }

    @GetMapping("/{profId}")
    public Professionals getProfessional(@PathVariable int profId){
        return profService.getProfessionalById(profId);
    }
}
