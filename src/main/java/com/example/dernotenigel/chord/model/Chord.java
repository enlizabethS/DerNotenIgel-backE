package com.example.dernotenigel.chord.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "chords")
public class Chord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ElementCollection
    @CollectionTable(name = "chord_notes", joinColumns = @JoinColumn(name = "chord_id"))
    @Column(name = "note")
    private List<String> notes;
}
