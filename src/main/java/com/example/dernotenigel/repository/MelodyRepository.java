package com.example.dernotenigel.repository;

import com.example.dernotenigel.model.Melody;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MelodyRepository extends JpaRepository<Melody, Long> {
}

