package com.example.dernotenigel.chord.service;

import com.example.dernotenigel.chord.model.Chord;
import com.example.dernotenigel.chord.repository.ChordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChordService {

    @Autowired
    private ChordRepository chordRepository;

    public List<Chord> findAll() {
        return chordRepository.findAll();
    }

    public Chord findById(Long id) {
        return chordRepository.findById(id).orElse(null);
    }

    public Chord save(Chord chord) {
        return chordRepository.save(chord);
    }

    public void deleteById(Long id) {
        chordRepository.deleteById(id);
    }
}

