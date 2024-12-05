package com.example.dernotenigel.audio.dto;

import org.springframework.web.multipart.MultipartFile;

public class AudioRequestDto {
    private MultipartFile audioFile;

    public MultipartFile getAudioFile() {
        return audioFile;
    }

    public void setAudioFile(MultipartFile audioFile) {
        this.audioFile = audioFile;
    }
}

