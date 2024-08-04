package com.example.dernotenigel.service;

import com.example.dernotenigel.model.Note;
import com.example.dernotenigel.model.Chord;
import com.example.dernotenigel.model.Scale;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class MelodyGenerationService {

    private final Random random = new Random();

    public List<Note> generateMelodyEnding(List<Note> currentMelody, int length) {
        List<Note> ending = new ArrayList<>();

        // Определите аккорд и шкалу для завершения мелодии
        List<String> scale = Scale.getChromaticScale();
        List<String> chord = Chord.getChord("major"); // Можно использовать другой аккорд или сменять аккорды

        // Генерация окончания на основе аккорда и шкалы
        for (int i = 0; i < length; i++) {
            Note note = new Note();
            note.setPitch(generatePitch(chord, scale));
            note.setDuration(generateRandomDuration());
            note.setInstrument("Piano"); // Выберите инструмент или сделайте это настраиваемым
            ending.add(note);
        }

        return ending;
    }

    private String generatePitch(List<String> chord, List<String> scale) {
        // Генерация ноты на основе аккорда
        if (random.nextBoolean()) {
            return chord.get(random.nextInt(chord.size()));
        } else {
            return scale.get(random.nextInt(scale.size()));
        }
    }

    private String generateRandomDuration() {
        // Пример генерации случайной длительности (можно заменить на реальное значение)
        int duration = 1 + random.nextInt(4); // Длительность от 1 до 4
        return Integer.toString(duration) + "s";
    }
}

