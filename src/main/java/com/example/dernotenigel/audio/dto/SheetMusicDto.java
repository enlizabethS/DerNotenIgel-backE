package com.example.dernotenigel.audio.dto;

import com.example.dernotenigel.audio.model.SheetMusic;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SheetMusicDto {

    @Schema(description = "Список нот в партитуре")
    private List<String> notes;

    public static SheetMusicDto from(SheetMusic sheetMusic) {
        return SheetMusicDto.builder()
                .notes(sheetMusic.getNotes())
                .build();
    }
}

