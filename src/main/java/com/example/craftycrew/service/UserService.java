package com.example.craftycrew.service;

import com.example.craftycrew.model.Users;
import com.example.craftycrew.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    public Users addNewUser(Users user){
        return userRepo.save(user);
    }

    public Users findUserByEmail(String email){
        return userRepo.findUserByUserEmail(email);
    }

    public Users findUserById(int id){
        return userRepo.findUserByUserId(id);
    }

}
