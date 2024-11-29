package com.example.dernotenigel.melody.service;

import com.example.dernotenigel.melody.model.Melody;
import com.example.dernotenigel.melody.repository.MelodyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MelodyService {

    @Autowired
    private MelodyRepository melodyRepository;

    public List<Melody> findAll() {
        return melodyRepository.findAll();
    }

    public Melody findById(Long id) {
        return melodyRepository.findById(id).orElse(null);
    }

    public Melody save(Melody melody) {
        return melodyRepository.save(melody);
    }

    public void deleteById(Long id) {
        melodyRepository.deleteById(id);
    }
}
