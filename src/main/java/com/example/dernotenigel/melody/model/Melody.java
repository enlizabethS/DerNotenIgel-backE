package com.example.dernotenigel.melody.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "melodies")
public class Melody {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @ElementCollection
    @CollectionTable(name = "melody_notes", joinColumns = @JoinColumn(name = "melody_id"))
    @Column(name = "note")
    private List<String> notes;
}

