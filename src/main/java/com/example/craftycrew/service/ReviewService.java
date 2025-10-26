package com.example.craftycrew.service;


import com.example.craftycrew.model.Professionals;
import com.example.craftycrew.model.Reviews;
import com.example.craftycrew.repository.ProfessionalRepo;
import com.example.craftycrew.repository.ReviewRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    @Autowired
    ReviewRepo reviewRepo;

    @Autowired
    ProfessionalRepo profRepo;

    public Reviews addReview(int profId,Reviews reviews){
        Professionals prof = profRepo.findByProfId(profId);
        if(prof!=null){
            double avgRating = prof.getProfRating()*prof.getReviewCount();
            avgRating+=reviews.getRatingPoints();
            avgRating=avgRating/(prof.getReviewCount()+1);
            prof.setReviewCount(prof.getReviewCount()+1);
            prof.setProfRating(avgRating);
            profRepo.save(prof);

            reviews.setProfId(profId);
            reviewRepo.save(reviews);

        }
        return reviews;
    }

    public List<Reviews> getReviewsByProfId(int profId){
        return reviewRepo.findByProfId(profId);
    }
}
