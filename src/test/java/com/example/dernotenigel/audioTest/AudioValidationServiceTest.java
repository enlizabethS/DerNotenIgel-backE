package com.example.dernotenigel.audioTest;

import com.example.dernotenigel.audio.service.AudioValidationService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

@SpringBootTest
public class AudioValidationServiceTest {

    @Autowired
    private AudioValidationService audioValidationService;

    @Test
    void validateEmptyFile_shouldThrowException() {
        MultipartFile emptyFile = new MockMultipartFile("file", "", "audio/wav", new byte[0]);
        Assertions.assertThrows(IllegalArgumentException.class, () -> audioValidationService.validateAudioFile(emptyFile));
    }

    @Test
    void validateLargeFile_shouldThrowException() {
        byte[] largeContent = new byte[11 * 1024 * 1024]; // 11 MB
        MultipartFile largeFile = new MockMultipartFile("file", "large.wav", "audio/wav", largeContent);
        Assertions.assertThrows(IllegalArgumentException.class, () -> audioValidationService.validateAudioFile(largeFile));
    }

    @Test
    void validateNonAudioFile_shouldThrowException() {
        MultipartFile nonAudioFile = new MockMultipartFile("file", "text.txt", "text/plain", "Invalid content".getBytes());
        Assertions.assertThrows(IllegalArgumentException.class, () -> audioValidationService.validateAudioFile(nonAudioFile));
    }

    @Test
    void validateValidAudioFile_shouldPass() {
        MultipartFile validAudioFile = new MockMultipartFile("file", "audio.wav", "audio/wav", "Valid content".getBytes());
        Assertions.assertDoesNotThrow(() -> audioValidationService.validateAudioFile(validAudioFile));
    }
}



