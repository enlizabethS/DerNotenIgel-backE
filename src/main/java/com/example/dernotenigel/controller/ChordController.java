package com.example.dernotenigel.controller;

import com.example.dernotenigel.model.Chord;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chords")
public class ChordController {

    @GetMapping("/get/{type}")
    public List<String> getChord(@PathVariable String type) {
        return Chord.getChord(type);
    }

    @GetMapping("/create")
    public List<String> createChord(@RequestParam String root, @RequestParam String type) {
        return Chord.createChord(root, type);
    }
}
