package com.example.dernotenigel.scale.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ScaleDto {
    @Schema(description = "ID of the scale")
    private Long id;
    @Schema(description = "Name of the scale")
    private String name;
    @Schema(description = "List of notes in the scale")
    private List<String> notes;
}

