package com.example.dernotenigel.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String instrument;
    private String pitch;
    private String duration;
    public Note() {}

    public Note(String pitch, String duration, String instrument) {
        this.pitch = pitch;
        this.duration = duration;
        this.instrument = instrument;
    }
}
