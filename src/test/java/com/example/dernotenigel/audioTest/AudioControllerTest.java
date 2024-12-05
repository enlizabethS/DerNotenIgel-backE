package com.example.dernotenigel.audioTest;

import com.example.dernotenigel.audio.controllers.AudioController;
import com.example.dernotenigel.audio.model.SheetMusic;
import com.example.dernotenigel.audio.service.AudioToSheetMusicService;
import com.example.dernotenigel.audio.service.AudioValidationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AudioController.class)
public class AudioControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AudioToSheetMusicService audioToSheetMusicService;

    @MockBean
    private AudioValidationService audioValidationService;

    @Test
    void convertAudioEndpoint_shouldReturnSheetMusic() throws Exception {
        MockMultipartFile mockFile = new MockMultipartFile("audioFile", "test.wav", "audio/wav", "audio data".getBytes());
        when(audioToSheetMusicService.convertAudioToSheetMusic(any())).thenReturn(new SheetMusic(List.of("C4", "D4", "E4")));

        mockMvc.perform(multipart("/api/audio/convert-audio").file(mockFile))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) jsonPath("$.notes", hasSize(3)))
                .andExpect((ResultMatcher) jsonPath("$.notes[0]").value("C4"));
    }

    @Test
    void convertAudioEndpoint_withInvalidFile_shouldReturnBadRequest() throws Exception {
        MockMultipartFile invalidFile = new MockMultipartFile("audioFile", "", "audio/wav", new byte[0]);

        mockMvc.perform(multipart("/api/audio/convert-audio").file(invalidFile))
                .andExpect(status().isBadRequest());
    }
}
