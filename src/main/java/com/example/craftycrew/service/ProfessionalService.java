package com.example.craftycrew.service;

import com.example.craftycrew.model.Professionals;
import com.example.craftycrew.repository.ProfessionalRepo;
import com.example.craftycrew.util.ProfessionalsFilterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessionalService {

    @Autowired
    ProfessionalRepo professionalRepo;

    public List<Professionals> getProfessionalsByFilter(ProfessionalsFilterRequest filterRequest){
        List<Professionals> profs = professionalRepo.findAll();
        return profs.stream()
                .filter(professionals -> filterRequest.getLocation()==null || professionals.getProfLocation().equalsIgnoreCase(filterRequest.getLocation()))
                .filter(professionals -> filterRequest.getProfession()==null || professionals.getProfProfession().equalsIgnoreCase(filterRequest.getProfession()))
                .filter(professionals -> filterRequest.getMinRating()==0 || professionals.getProfRating()>filterRequest.getMinRating())
                .toList();
    }


    public Professionals addNewProfessional(Professionals professional){
        return professionalRepo.save(professional);
    }

    public Professionals findProfessionalByEmail(String email){
        return professionalRepo.findProfessionalByProfEmail(email);
    }

    public Professionals getProfessionalById(int profId) {
        return professionalRepo.findByProfId(profId);
    }
}
