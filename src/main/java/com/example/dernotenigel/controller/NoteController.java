package com.example.dernotenigel.controller;

import com.example.dernotenigel.model.Note;
import com.example.dernotenigel.service.NoteService; // Сервис для управления нотами
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notes")
public class NoteController {

    @Autowired
    private NoteService noteService;

    @PostMapping("/add")
    public Note addNote(@RequestBody Note note) {
        return noteService.addOrUpdate(note);
    }

    @GetMapping("/get/{id}")
    public Note getNoteById(@PathVariable Long id) {
        return noteService.getNoteById(id);
    }

    @PutMapping("/update/{id}")
    public Note updateNote(@PathVariable Long id, @RequestBody Note note) {
        return noteService.addOrUpdate(note); // Метод для обновления
    }

    @DeleteMapping("/delete/{id}")
    public void deleteNote(@PathVariable Long id) {
        noteService.deleteNoteById(id);
    }

    @GetMapping("/all")
    public List<Note> getAllNotes() {
        return noteService.getAllNotes();
    }
}

