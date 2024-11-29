package com.example.dernotenigel.audio.service;

import com.example.dernotenigel.audio.dto.SheetMusicDto;
import com.example.dernotenigel.audio.model.SheetMusic;
import com.example.dernotenigel.audio.repository.SheetMusicRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class SheetMusicService {

    private final AudioToSheetMusicService audioToSheetMusicService;
    private final SheetMusicRepository sheetMusicRepository;

    public SheetMusicService(AudioToSheetMusicService audioToSheetMusicService, SheetMusicRepository sheetMusicRepository) {
        this.audioToSheetMusicService = audioToSheetMusicService;
        this.sheetMusicRepository = sheetMusicRepository;
    }

    public SheetMusicDto createSheetMusicFromAudio(MultipartFile audioFile) {
        SheetMusic sheetMusic = audioToSheetMusicService.convertAudioToSheetMusic(audioFile);
        sheetMusicRepository.save(sheetMusic); // Сохранение в репозиторий
        return SheetMusicDto.from(sheetMusic);
    }
}

