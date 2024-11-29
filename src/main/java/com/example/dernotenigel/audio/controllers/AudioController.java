package com.example.dernotenigel.audio.controllers;

import com.example.dernotenigel.audio.model.SheetMusic;
import com.example.dernotenigel.audio.service.AudioToSheetMusicService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/audio")
public class AudioController {

    private final AudioToSheetMusicService audioToSheetMusicService;

    public AudioController(AudioToSheetMusicService audioToSheetMusicService) {
        this.audioToSheetMusicService = audioToSheetMusicService;
    }

//    @PostMapping("/convert")
//    public ResponseEntity<SheetMusic> convertAudioToSheetMusic(@ModelAttribute AudioRequestDto audioRequest) {
//        MultipartFile audioFile = audioRequest.getAudioFile();
//        SheetMusic sheetMusic = audioToSheetMusicService.convertAudioToSheetMusic(audioFile);
//        return ResponseEntity.ok(sheetMusic);
//    }
}

