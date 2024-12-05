package com.example.dernotenigel.audio.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FileStorageService {
    private final Path audioStoragePath = Paths.get("audio-storage");

    public Path storeFile(MultipartFile file) throws IOException {
        if (!Files.exists(audioStoragePath)) {
            Files.createDirectories(audioStoragePath);
        }
        Path targetPath = audioStoragePath.resolve(file.getOriginalFilename());
        Files.copy(file.getInputStream(), targetPath, StandardCopyOption.REPLACE_EXISTING);
        return targetPath;
    }
}
