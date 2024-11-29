package com.example.dernotenigel.scale.service;

import com.example.dernotenigel.scale.model.Scale;
import com.example.dernotenigel.scale.repository.ScaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScaleService {

    @Autowired
    private ScaleRepository scaleRepository;

    public List<Scale> findAll() {
        return scaleRepository.findAll();
    }

    public Scale findById(Long id) {
        return scaleRepository.findById(id).orElse(null);
    }

    public Scale save(Scale scale) {
        return scaleRepository.save(scale);
    }

    public void deleteById(Long id) {
        scaleRepository.deleteById(id);
    }
}
