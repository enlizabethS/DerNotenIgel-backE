package com.example.dernotenigel.service;

import com.example.dernotenigel.model.Note;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class NoteService {

    private final List<Note> notes = new ArrayList<>();
    private long idCounter = 1;

    public Note addOrUpdate(Note note) {
        if (note.getPitch() == null || note.getPitch().isEmpty()) {
            throw new IllegalArgumentException("Note pitch cannot be null or empty");
        }
        note.setPitch(note.getPitch().toUpperCase()); // Пример преобразования
        // Если нота уже существует, обновляем ее
        Optional<Note> existingNote = notes.stream()
                .filter(n -> n.getPitch().equals(note.getPitch()))
                .findFirst();
        if (existingNote.isPresent()) {
            notes.remove(existingNote.get());
        } else {
            note.setId(idCounter++);
        }
        notes.add(note);
        return note;
    }

    public Note getNoteById(Long id) {
        return notes.stream().filter(note -> note.getId().equals(id)).findFirst().orElse(null);
    }

    public void deleteNoteById(Long id) {
        notes.removeIf(note -> note.getId().equals(id));
    }

    public List<Note> getAllNotes() {
        return new ArrayList<>(notes);
    }
}

