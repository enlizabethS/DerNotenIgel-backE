package com.example.dernotenigel.model;

import java.util.Arrays;
import java.util.List;

public class Scale {
    private static final List<String> CHROMATIC_SCALE = Arrays.asList("C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B");

    public static List<String> getChromaticScale() {
        return CHROMATIC_SCALE;
    }
}
