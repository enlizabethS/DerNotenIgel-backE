package com.example.dernotenigel.score.service;

import com.example.dernotenigel.score.model.Score;
import com.example.dernotenigel.score.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreService {

    @Autowired
    private ScoreRepository scoreRepository;

    public List<Score> findAll() {
        return scoreRepository.findAll();
    }

    public Score findById(Long id) {
        return scoreRepository.findById(id).orElse(null);
    }

    public Score save(Score score) {
        return scoreRepository.save(score);
    }

    public void deleteById(Long id) {
        scoreRepository.deleteById(id);
    }
}

