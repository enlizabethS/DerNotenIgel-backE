package com.example.dernotenigel.audio.service;

public class AudioUtils {
    public static boolean isSupportedFormat(String fileName) {
        return fileName.endsWith(".wav") || fileName.endsWith(".mp3");
    }
}

