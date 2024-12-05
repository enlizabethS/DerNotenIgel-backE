package com.example.dernotenigel.audio.service;

import be.tarsos.dsp.AudioDispatcher;
import be.tarsos.dsp.io.jvm.AudioDispatcherFactory;
import be.tarsos.dsp.pitch.PitchDetectionHandler;
import be.tarsos.dsp.pitch.PitchProcessor;
import com.example.dernotenigel.audio.model.SheetMusic;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

@Service
public class AudioToSheetMusicService {

    // Список для хранения нот
    private final List<String> notes = new ArrayList<>();

    public SheetMusic convertAudioToSheetMusic(MultipartFile audioFile) {
        notes.clear(); // Очистка списка нот перед началом анализа
        try {
            // Сохранение аудиофайла во временный файл
            File tempFile = Files.createTempFile("audio", ".wav").toFile();
            try (InputStream audioInputStream = audioFile.getInputStream();
                 FileOutputStream fileOutputStream = new FileOutputStream(tempFile)) {
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = audioInputStream.read(buffer)) != -1) {
                    fileOutputStream.write(buffer, 0, bytesRead);
                }
            }

            // Создание диспетчера для обработки аудио
            AudioDispatcher dispatcher = AudioDispatcherFactory.fromFile(tempFile, 2048, 1024);

            // Создание обработчика высоты звука
            PitchDetectionHandler pitchDetectionHandler = (pitchDetectionResult, audioEvent) -> {
                if (pitchDetectionResult.getPitch() != -1) { // -1 означает отсутствие детектированной высоты
                    String note = convertPitchToNoteName(pitchDetectionResult.getPitch());
                    if (note != null) {
                        notes.add(note);
                    }
                }
            };

            PitchProcessor pitchProcessor = new PitchProcessor(
                    PitchProcessor.PitchEstimationAlgorithm.FFT_YIN,
                    44100,
                    2048,
                    pitchDetectionHandler
            );

            dispatcher.addAudioProcessor(pitchProcessor);

            // Запуск обработки
            dispatcher.run();

            // Удаление временного файла
            tempFile.delete();

            // Возврат преобразованной партитуры
            return new SheetMusic(notes);

        } catch (Exception e) {
            e.printStackTrace();
            return null; // Возврат null в случае ошибки
        }
    }

    // Метод для преобразования частоты в название ноты
    private String convertPitchToNoteName(float pitch) {
        if (pitch <= 0) return null; // Невалидная частота

        // Ноты западной музыкальной системы
        String[] noteNames = {"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B"};

        // Стандартный частотный базис для ноты A4 (440 Гц)
        final float A4_FREQUENCY = 440.0f;

        // Вычисление номера ноты
        int noteNumber = (int) Math.round(12 * (Math.log(pitch / A4_FREQUENCY) / Math.log(2)) + 69);

        if (noteNumber < 0 || noteNumber >= 128) {
            return null; // Нота вне диапазона MIDI
        }

        // Получение имени ноты
        int noteIndex = noteNumber % 12;
        int octave = (noteNumber / 12) - 1; // Вычисление октавы

        return noteNames[noteIndex] + octave;
    }
}