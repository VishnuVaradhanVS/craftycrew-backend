package com.example.craftycrew.repository;

import com.example.craftycrew.model.Professionals;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessionalRepo extends JpaRepository<Professionals,Integer> {
    public Professionals findProfessionalByEmail(String email);
}
