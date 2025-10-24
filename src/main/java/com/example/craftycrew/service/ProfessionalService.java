package com.example.craftycrew.service;

import com.example.craftycrew.model.Professionals;
import com.example.craftycrew.repository.ProfessionalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessionalService {

    @Autowired
    ProfessionalRepo professionalRepo;

    public Professionals addNewProfessional(Professionals professional){
        return professionalRepo.save(professional);
    }

    public Professionals findProfessionalByEmail(String email){
        return professionalRepo.findProfessionalByEmail(email);
    }

    public List<Professionals> findProfessionalByLocation(String location){
        return professionalRepo.findProfessionalsByLocation(location);
    }

    public List<Professionals> findProfessionalsByProfession(String profession){
        return professionalRepo.findProfessionalsByProfession(profession);
    }
}
