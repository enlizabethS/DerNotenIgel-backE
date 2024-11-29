package com.example.dernotenigel.scale.repository;

import com.example.dernotenigel.scale.model.Scale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScaleRepository extends JpaRepository<Scale, Long> {
}

