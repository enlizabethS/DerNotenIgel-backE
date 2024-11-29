package com.example.dernotenigel.instrument.repository;

import com.example.dernotenigel.instrument.model.Instrument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstrumentRepository extends JpaRepository<Instrument, Long> {
}


