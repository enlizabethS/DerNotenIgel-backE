package com.example.dernotenigel.audio.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class AudioValidationService {

    public void validateAudioFile(MultipartFile audioFile) {
        if (audioFile.isEmpty()) {
            throw new IllegalArgumentException("Файл пустой!");
        }
        if (!audioFile.getContentType().startsWith("audio/")) {
            throw new IllegalArgumentException("Файл не является аудиофайлом!");
        }
        if (audioFile.getSize() > 10 * 1024 * 1024) { // Ограничение на 10 MB
            throw new IllegalArgumentException("Файл превышает допустимый размер!");
        }
    }
}

