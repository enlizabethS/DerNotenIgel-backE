package com.example.dernotenigel.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Chord {

    // Простые аккорды
    public static final List<String> MAJOR_CHORD = Arrays.asList("C", "E", "G");
    public static final List<String> MINOR_CHORD = Arrays.asList("C", "D#", "G");
    public static final List<String> DIMINISHED_CHORD = Arrays.asList("C", "D#", "F#"); // Уменьшенный аккорд
    public static final List<String> AUGMENTED_CHORD = Arrays.asList("C", "E", "G#"); // Увеличенный аккорд

    private static final Map<String, List<String>> CHORDS = new HashMap<>();

    static {
        CHORDS.put("major", MAJOR_CHORD);
        CHORDS.put("minor", MINOR_CHORD);
        CHORDS.put("diminished", DIMINISHED_CHORD);
        CHORDS.put("augmented", AUGMENTED_CHORD);
    }

    public static List<String> getChord(String type) {
        return CHORDS.getOrDefault(type.toLowerCase(), MAJOR_CHORD); // Возвращает мажорный аккорд по умолчанию
    }

    public static List<String> createChord(String root, String type) {
        List<String> chord = new ArrayList<>();
        // Базовый алгоритм построения аккорда (очень упрощенный)
        switch (type.toLowerCase()) {
            case "major":
                chord.add(root);
                chord.add(nextNoteInScale(root, 4));  // Большая терция
                chord.add(nextNoteInScale(root, 7));  // Чистая квинта
                break;
            case "minor":
                chord.add(root);
                chord.add(nextNoteInScale(root, 3));  // Малая терция
                chord.add(nextNoteInScale(root, 7));  // Чистая квинта
                break;
            case "diminished":
                chord.add(root);
                chord.add(nextNoteInScale(root, 3));  // Малая терция
                chord.add(nextNoteInScale(root, 6));  // Уменьшенная квинта
                break;
            case "augmented":
                chord.add(root);
                chord.add(nextNoteInScale(root, 4));  // Большая терция
                chord.add(nextNoteInScale(root, 8));  // Увеличенная квинта
                break;
            default:
                chord.add(root);
                chord.add(nextNoteInScale(root, 4));  // Большая терция
                chord.add(nextNoteInScale(root, 7));  // Чистая квинта
                break;
        }
        return chord;
    }

    private static String nextNoteInScale(String root, int interval) {
        List<String> scale = Scale.getChromaticScale();
        int rootIndex = scale.indexOf(root);
        int targetIndex = (rootIndex + interval) % scale.size();
        return scale.get(targetIndex);
    }
}


