package com.example.dernotenigel.instrument.service;

import com.example.dernotenigel.instrument.model.Instrument;
import com.example.dernotenigel.instrument.repository.InstrumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstrumentService {

    @Autowired
    private InstrumentRepository instrumentRepository;

    public List<Instrument> findAll() {
        return instrumentRepository.findAll();
    }

    public Instrument findById(Long id) {
        return instrumentRepository.findById(id).orElse(null);
    }

    public Instrument save(Instrument instrument) {
        return instrumentRepository.save(instrument);
    }

    public void deleteById(Long id) {
        instrumentRepository.deleteById(id);
    }
}
