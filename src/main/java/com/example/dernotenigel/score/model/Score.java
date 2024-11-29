package com.example.dernotenigel.score.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "scores")
public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @ElementCollection
    @CollectionTable(name = "score_notes", joinColumns = @JoinColumn(name = "score_id"))
    @Column(name = "note")
    private List<String> notes;
}

