package com.example.dernotenigel.chord.controllers;

import com.example.dernotenigel.chord.model.Chord;
import com.example.dernotenigel.chord.service.ChordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chords")
public class ChordController {

    @Autowired
    private ChordService chordService;

    @GetMapping
    public List<Chord> getAllChords() {
        return chordService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Chord> getChordById(@PathVariable Long id) {
        Chord chord = chordService.findById(id);
        return chord != null ? ResponseEntity.ok(chord) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Chord createChord(@RequestBody Chord chord) {
        return chordService.save(chord);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteChord(@PathVariable Long id) {
        chordService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
