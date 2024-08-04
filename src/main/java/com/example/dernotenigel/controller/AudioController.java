package com.example.dernotenigel.controller;

import com.example.dernotenigel.model.Note;
import com.example.dernotenigel.service.AudioProcessingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/audio")
public class AudioController {

    @Autowired
    private AudioProcessingService audioProcessingService;

    @PostMapping("/upload")
    public List<Note> uploadAudioFile(@RequestParam("file") MultipartFile file) throws IOException, UnsupportedAudioFileException {
        File convFile = new File(System.getProperty("java.io.tmpdir") + "/" + file.getOriginalFilename());
        file.transferTo(convFile);
        return audioProcessingService.processAudioFile(convFile);
    }
}
