package com.example.craftycrew.controller;

import com.example.craftycrew.model.Reviews;
import com.example.craftycrew.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    ReviewService reviewService;

    @PostMapping("{profId}")
    public Reviews addReview(@PathVariable int profId,@RequestBody Reviews reviews){
        return reviewService.addReview(profId,reviews);
    }

    @GetMapping("{profId}")
    public List<Reviews> getReviews(@PathVariable int profId){
        return reviewService.getReviewsByProfId(profId);
    }

}
