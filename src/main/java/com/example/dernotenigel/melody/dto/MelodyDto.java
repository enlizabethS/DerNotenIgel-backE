package com.example.dernotenigel.melody.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class MelodyDto {
    @Schema(description = "ID of the melody")
    private Long id;
    @Schema(description = "Title of the melody")
    private String title;
    @Schema(description = "List of notes in the melody")
    private List<String> notes;
}

