package com.example.craftycrew.repository;

import com.example.craftycrew.model.Reviews;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepo extends JpaRepository<Reviews,Integer> {
    public List<Reviews> findByProfId(int professionalId);
}
