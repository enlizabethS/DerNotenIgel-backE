package com.example.dernotenigel.score.controllers;

import com.example.dernotenigel.score.model.Score;
import com.example.dernotenigel.score.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/scores")
public class ScoreController {

    @Autowired
    private ScoreService scoreService;

    @GetMapping
    public List<Score> getAllScores() {
        return scoreService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Score> getScoreById(@PathVariable Long id) {
        Score score = scoreService.findById(id);
        return score != null ? ResponseEntity.ok(score) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Score createScore(@RequestBody Score score) {
        return scoreService.save(score);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteScore(@PathVariable Long id) {
        scoreService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
