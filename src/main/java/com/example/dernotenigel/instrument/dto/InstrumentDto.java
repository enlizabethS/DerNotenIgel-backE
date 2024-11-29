package com.example.dernotenigel.instrument.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class InstrumentDto {
    @Schema(description = "ID of the instrument")
    private Long id;
    @Schema(description = "Name of the instrument")
    private String name;
    @Schema(description = "Type of the instrument")
    private String type;
}

