package com.example.craftycrew.config;

import com.example.craftycrew.model.Professionals;
import com.example.craftycrew.model.Reviews;
import com.example.craftycrew.repository.ProfessionalRepo;
import com.example.craftycrew.repository.ReviewRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DataSeeder {

    @Bean
    CommandLineRunner initDatabase(ProfessionalRepo profRepo, ReviewRepo reviewRepo) {
        return args -> {

            // -------------------------------
            // Step 1: Seed Professionals
            // -------------------------------
            if (profRepo.count() == 0) {
                Professionals[] professionals = {
                        new Professionals("John Mason", "john@gmail.com", "pass123", "123 Green St", "Chennai", "Electrician"),
                        new Professionals("Priya Das", "priya@gmail.com", "pass123", "45 Anna Nagar", "Chennai", "Plumber"),
                        new Professionals("Arjun Rao", "arjun@gmail.com", "pass123", "22 MG Road", "Bangalore", "Carpenter"),
                        new Professionals("Sneha Patel", "sneha@gmail.com", "pass123", "5 Lotus St", "Mumbai", "Painter"),
                        new Professionals("Vikram Singh", "vikram@gmail.com", "pass123", "78 Lake View", "Mumbai", "Mechanic"),
                        new Professionals("Karthik Menon", "karthik@gmail.com", "pass123", "32 Beach Road", "Bangalore", "Electrician"),
                        new Professionals("Ananya Iyer", "ananya@gmail.com", "pass123", "15 Race Course", "Delhi", "Carpenter"),
                        new Professionals("Deepak Sharma", "deepak@gmail.com", "pass123", "8 Sector 14", "Delhi", "Painter"),
                        new Professionals("Ravi Kumar", "ravi@gmail.com", "pass123", "19 Gandhi Street", "Chennai", "Plumber"),
                        new Professionals("Meera Joshi", "meera@gmail.com", "pass123", "10 Station Road", "Mumbai", "Mechanic"),
                        new Professionals("Suresh Reddy", "suresh@gmail.com", "pass123", "45 Banjara Hills", "Chennai", "Electrician"),
                        new Professionals("Neha Kapoor", "neha@gmail.com", "pass123", "2 Park Avenue", "Delhi", "Carpenter"),
                        new Professionals("Manoj Pillai", "manoj@gmail.com", "pass123", "99 MG Street", "Bangalore", "Plumber"),
                        new Professionals("Ritika Sen", "ritika@gmail.com", "pass123", "44 Salt Lake", "Bangalore", "Painter"),
                        new Professionals("Harish Nair", "harish@gmail.com", "pass123", "6 Canal Road", "Delhi", "Mechanic"),
                        new Professionals("Divya Raj", "divya@gmail.com", "pass123", "23 Lakeview", "Chennai", "Electrician"),
                        new Professionals("Tarun Verma", "tarun@gmail.com", "pass123", "9 Park Street", "Delhi", "Interior Designer"),
                        new Professionals("Lakshmi Devi", "lakshmi@gmail.com", "pass123", "14 Temple Street", "Mumbai", "Carpenter"),
                        new Professionals("Rohit Shetty", "rohit@gmail.com", "pass123", "70 Palm Grove", "Mumbai", "Painter"),
                        new Professionals("Asha Thomas", "asha@gmail.com", "pass123", "34 Fort Road", "Chennai", "Plumber")
                };

                profRepo.saveAll(List.of(professionals));
            }

            // -------------------------------
            // Step 2: Seed Reviews
            // -------------------------------
            if (reviewRepo.count() == 0) {
                Reviews[] reviews = {
                        new Reviews(0, "Excellent service and polite attitude!", 4.8, "user1", 1),
                        new Reviews(0, "Fixed the wiring perfectly. Highly recommend!", 4.6, "user2", 1),
                        new Reviews(0, "Quick fix for my leaking tap.", 4.2, "user3", 2),
                        new Reviews(0, "Creative designs and great finishing!", 4.9, "user4", 7),
                        new Reviews(0, "Clean painting job. Worth the price.", 4.3, "user5", 4),
                        new Reviews(0, "Came late but did the repair well.", 3.7, "user6", 5),
                        new Reviews(0, "Neat and professional work!", 4.5, "user7", 3),
                        new Reviews(0, "Affordable pricing, good work.", 4.1, "user8", 2),
                        new Reviews(0, "Responsive and punctual.", 4.4, "user9", 8),
                        new Reviews(0, "Engine repair done well.", 4.2, "user10", 10),
                        new Reviews(0, "Friendly and knowledgeable electrician.", 4.7, "user11", 11),
                        new Reviews(0, "Good finishing, took extra time though.", 3.9, "user12", 12),
                        new Reviews(0, "Great attention to detail.", 4.6, "user13", 13),
                        new Reviews(0, "Wall paint looks amazing!", 4.8, "user14", 14),
                        new Reviews(0, "Car service was smooth and quick.", 4.5, "user15", 15),
                        new Reviews(0, "Excellent lighting setup done.", 4.9, "user16", 16),
                        new Reviews(0, "Superb creativity and neat interior work.", 5.0, "user17", 17),
                        new Reviews(0, "Simple carpenter, decent rates.", 3.8, "user18", 18),
                        new Reviews(0, "Good customer service and reliable.", 4.4, "user19", 19),
                        new Reviews(0, "Professional and efficient plumbing.", 4.6, "user20", 20)
                };

                reviewRepo.saveAll(List.of(reviews));
            }

            // -------------------------------
            // Step 3: Auto-calculate profRating & reviewCount
            // -------------------------------
            for (Professionals p : profRepo.findAll()) {
                List<Reviews> profReviews = reviewRepo.findByProfId(p.getProfId());
                if (!profReviews.isEmpty()) {
                    double avgRating = profReviews.stream()
                            .mapToDouble(Reviews::getRatingPoints)
                            .average()
                            .orElse(0.0);
                    p.setProfRating(Math.round(avgRating * 100.0) / 100.0); // round to 2 decimals
                    p.setReviewCount(profReviews.size());
                    profRepo.save(p);
                }
            }
        };
    }
}
