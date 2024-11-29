package com.example.dernotenigel.chord.dto;

import com.example.dernotenigel.chord.model.Chord;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ChordDto {

        @Schema(description = "ID of the chord")
        private Long id;

        @Schema(description = "Name of the chord")
        private String name;

        @Schema(description = "List of notes that make up the chord")
        private List<String> notes;

        public static ChordDto from(Chord chord) {
            return ChordDto.builder()
                    .id(chord.getId())
                    .name(chord.getName())
                    .notes(chord.getNotes())
                    .build();
        }

        public static List<ChordDto> from(List<Chord> chords) {
            return chords.stream()
                    .map(ChordDto::from)
                    .collect(Collectors.toList());
        }
}
