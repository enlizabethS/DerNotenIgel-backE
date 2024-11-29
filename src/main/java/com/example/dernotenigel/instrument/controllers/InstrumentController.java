package com.example.dernotenigel.instrument.controllers;

import com.example.dernotenigel.instrument.model.Instrument;
import com.example.dernotenigel.instrument.service.InstrumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/instruments")
public class InstrumentController {

    @Autowired
    private InstrumentService instrumentService;

    @GetMapping
    public List<Instrument> getAllInstruments() {
        return instrumentService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Instrument> getInstrumentById(@PathVariable Long id) {
        Instrument instrument = instrumentService.findById(id);
        return instrument != null ? ResponseEntity.ok(instrument) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Instrument createInstrument(@RequestBody Instrument instrument) {
        return instrumentService.save(instrument);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInstrument(@PathVariable Long id) {
        instrumentService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
