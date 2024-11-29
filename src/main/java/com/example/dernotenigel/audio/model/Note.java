package com.example.dernotenigel.audio.model;

public class Note {
    private String pitch; // Нота (например, "C4")
    private double duration; // Длительность ноты

    // Конструкторы, геттеры и сеттеры
    public Note(String pitch, double duration) {
        this.pitch = pitch;
        this.duration = duration;
    }

    public String getPitch() {
        return pitch;
    }

    public void setPitch(String pitch) {
        this.pitch = pitch;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }
}

