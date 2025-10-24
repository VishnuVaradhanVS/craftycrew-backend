package com.example.craftycrew.controller;

import com.example.craftycrew.model.Reviews;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    @PostMapping("/addReview")
    public Reviews addReview(@RequestBody ){

    }

}
