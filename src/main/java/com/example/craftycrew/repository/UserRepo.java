package com.example.craftycrew.repository;

import com.example.craftycrew.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<Users,Integer> {
    Users findUserByUserEmail(String email);
    Users findUserByUserId(int id);
}
