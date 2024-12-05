package com.example.dernotenigel.audio.controllers;

import com.example.dernotenigel.audio.dto.SheetMusicDto;
import com.example.dernotenigel.audio.exceptions.AudioProcessingException;
import com.example.dernotenigel.audio.model.SheetMusic;
import com.example.dernotenigel.audio.service.AudioToSheetMusicService;
import com.example.dernotenigel.audio.service.AudioValidationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/audio")
public class AudioController {

    private final AudioToSheetMusicService audioToSheetMusicService;
    private final AudioValidationService audioValidationService;

    public AudioController(AudioToSheetMusicService audioToSheetMusicService, AudioValidationService audioValidationService) {
        this.audioToSheetMusicService = audioToSheetMusicService;
        this.audioValidationService = audioValidationService;
    }

    @PostMapping("/convert-audio")
    public ResponseEntity<SheetMusicDto> convertAudioToSheetMusic(@RequestParam("audioFile") MultipartFile audioFile) {
        audioValidationService.validateAudioFile(audioFile); // Validate file before processing
        SheetMusic sheetMusic = audioToSheetMusicService.convertAudioToSheetMusic(audioFile);
        SheetMusicDto sheetMusicDto = SheetMusicDto.from(sheetMusic);
        return ResponseEntity.ok(sheetMusicDto);
    }

    @ExceptionHandler({AudioProcessingException.class, IllegalArgumentException.class})
    public ResponseEntity<String> handleExceptions(Exception e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ошибка: " + e.getMessage());
    }
}

