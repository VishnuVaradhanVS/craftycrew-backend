package com.example.craftycrew.repository;

import com.example.craftycrew.model.Professionals;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfessionalRepo extends JpaRepository<Professionals,Integer> {
    public Professionals findProfessionalByEmail(String email);
    public List<Professionals> findProfessionalsByLocation(String location);
    public List<Professionals> findProfessionalsByProfession(String profession);
}
