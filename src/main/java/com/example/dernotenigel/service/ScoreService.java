package com.example.dernotenigel.service;

import com.example.dernotenigel.model.Note;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreService {

    public void updateNoteDuration(List<Note> notes, int index, String newDuration) {
        if (index >= 0 && index < notes.size()) {
            notes.get(index).setDuration(newDuration);
        }
    }

    public void updateNotePitch(List<Note> notes, int index, String newPitch) {
        if (index >= 0 && index < notes.size()) {
            notes.get(index).setPitch(newPitch);
        }
    }
}
