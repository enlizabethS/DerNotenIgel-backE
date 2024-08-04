package com.example.dernotenigel.service;

import be.tarsos.dsp.AudioDispatcher;
import be.tarsos.dsp.io.jvm.AudioDispatcherFactory;
import be.tarsos.dsp.pitch.PitchDetectionHandler;
import be.tarsos.dsp.pitch.PitchProcessor;
import be.tarsos.dsp.pitch.PitchProcessor.PitchEstimationAlgorithm;
import com.example.dernotenigel.model.Note;
import org.springframework.stereotype.Service;

import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class AudioProcessingService {

    public List<Note> processAudioFile(File audioFile) throws IOException, UnsupportedAudioFileException {
        List<Note> notes = new ArrayList<>();
        AudioDispatcher dispatcher = AudioDispatcherFactory.fromFile(audioFile, 2048, 1024);

        final float[] previousTime = {0};
        PitchDetectionHandler handler = (res, e) -> {
            if (res.getPitch() != -1) {
                Note note = new Note();
                note.setPitch(Float.toString(res.getPitch()));
                note.setInstrument(instrument);

                float currentTime = (float) e.getTimeStamp();
                note.setDuration(Float.toString(currentTime - previousTime[0]));
                previousTime[0] = currentTime;

                notes.add(note);
            }
        };

        dispatcher.addAudioProcessor(new PitchProcessor(PitchEstimationAlgorithm.YIN, 44100, 2048, handler));
        dispatcher.run();

        return notes;
    }
}
