package com.example.dernotenigel.note.controllers;

import com.example.dernotenigel.note.model.Note;
import com.example.dernotenigel.note.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notes")
public class NoteController {

    @Autowired
    private NoteService noteService;

    @GetMapping
    public List<Note> getAllNotes() {
        return noteService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Note> getNoteById(@PathVariable Long id) {
        Note note = noteService.findById(id);
        return note != null ? ResponseEntity.ok(note) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Note createNote(@RequestBody Note note) {
        return noteService.save(note);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNote(@PathVariable Long id) {
        noteService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
