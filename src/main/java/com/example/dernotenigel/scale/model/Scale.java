package com.example.dernotenigel.scale.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "scales")
public class Scale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ElementCollection
    @CollectionTable(name = "scale_notes", joinColumns = @JoinColumn(name = "scale_id"))
    @Column(name = "note")
    private List<String> notes;
}

