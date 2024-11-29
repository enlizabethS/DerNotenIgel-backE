package com.example.dernotenigel.melody.controllers;

import com.example.dernotenigel.melody.model.Melody;
import com.example.dernotenigel.melody.service.MelodyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/melodies")
public class MelodyController {

    @Autowired
    private MelodyService melodyService;

    @GetMapping
    public List<Melody> getAllMelodies() {
        return melodyService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Melody> getMelodyById(@PathVariable Long id) {
        Melody melody = melodyService.findById(id);
        return melody != null ? ResponseEntity.ok(melody) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Melody createMelody(@RequestBody Melody melody) {
        return melodyService.save(melody);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMelody(@PathVariable Long id) {
        melodyService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
