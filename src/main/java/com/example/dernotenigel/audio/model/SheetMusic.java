package com.example.dernotenigel.audio.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SheetMusic {
    private List<String> notes; // Список нот в партитуре
}

