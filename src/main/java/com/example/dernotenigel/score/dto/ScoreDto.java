package com.example.dernotenigel.score.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ScoreDto {
    @Schema(description = "ID of the score")
    private Long id;
    @Schema(description = "Title of the score")
    private String title;
    @Schema(description = "List of notes in the score")
    private List<String> notes;
}

