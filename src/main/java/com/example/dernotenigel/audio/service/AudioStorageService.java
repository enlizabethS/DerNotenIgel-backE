package com.example.dernotenigel.audio.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class AudioStorageService {

    private final Path storagePath = Paths.get("audio-storage");

    public File storeAudio(MultipartFile audioFile) throws IOException {
        if (!Files.exists(storagePath)) {
            Files.createDirectories(storagePath);
        }
        Path targetPath = storagePath.resolve(audioFile.getOriginalFilename());
        Files.copy(audioFile.getInputStream(), targetPath, StandardCopyOption.REPLACE_EXISTING);
        return targetPath.toFile();
    }
}

