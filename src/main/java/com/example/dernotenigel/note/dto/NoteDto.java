package com.example.dernotenigel.note.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class NoteDto {
    @Schema(description = "ID of the note")
    private Long id;
    @Schema(description = "Name of the note")
    private String name;
    @Schema(description = "Pitch of the note")
    private String pitch;
}

