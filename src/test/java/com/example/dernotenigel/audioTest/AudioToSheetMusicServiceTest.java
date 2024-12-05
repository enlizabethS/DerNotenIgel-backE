package com.example.dernotenigel.audioTest;

import com.example.dernotenigel.audio.exceptions.AudioProcessingException;
import com.example.dernotenigel.audio.model.SheetMusic;
import com.example.dernotenigel.audio.service.AudioToSheetMusicService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

@SpringBootTest
public class AudioToSheetMusicServiceTest {

    @Autowired
    private AudioToSheetMusicService audioToSheetMusicService;

    @Test
    void convertValidAudio_shouldReturnSheetMusic() {
        MultipartFile mockFile = new MockMultipartFile("file", "test.wav", "audio/wav", "audio data".getBytes());
        SheetMusic sheetMusic = audioToSheetMusicService.convertAudioToSheetMusic(mockFile);
        Assertions.assertNotNull(sheetMusic);
        Assertions.assertFalse(sheetMusic.getNotes().isEmpty());
    }

    @Test
    void convertInvalidAudio_shouldThrowException() {
        MultipartFile invalidFile = new MockMultipartFile("file", "test.wav", "audio/wav", new byte[0]);
        Assertions.assertThrows(AudioProcessingException.class, () -> audioToSheetMusicService.convertAudioToSheetMusic(invalidFile));
    }
}
