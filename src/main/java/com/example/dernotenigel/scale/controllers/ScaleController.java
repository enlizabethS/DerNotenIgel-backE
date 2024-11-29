package com.example.dernotenigel.scale.controllers;

import com.example.dernotenigel.scale.model.Scale;
import com.example.dernotenigel.scale.service.ScaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/scales")
public class ScaleController {

    @Autowired
    private ScaleService scaleService;

    @GetMapping
    public List<Scale> getAllScales() {
        return scaleService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Scale> getScaleById(@PathVariable Long id) {
        Scale scale = scaleService.findById(id);
        return scale != null ? ResponseEntity.ok(scale) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Scale createScale(@RequestBody Scale scale) {
        return scaleService.save(scale);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteScale(@PathVariable Long id) {
        scaleService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
