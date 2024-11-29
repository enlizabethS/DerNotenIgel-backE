package com.example.dernotenigel.chord.repository;

import com.example.dernotenigel.chord.model.Chord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChordRepository extends JpaRepository<Chord, Long> {
}

