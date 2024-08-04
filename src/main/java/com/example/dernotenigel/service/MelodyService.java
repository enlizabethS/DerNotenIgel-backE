package com.example.dernotenigel.service;

import com.example.dernotenigel.model.Melody;
import com.example.dernotenigel.model.Note;
import com.example.dernotenigel.repository.MelodyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MelodyService {

    @Autowired
    private MelodyRepository melodyRepository;

    @Autowired
    private MelodyGenerationService melodyGenerationService;

    /**
     * Создает или обновляет мелодию.
     *
     * @param melody объект мелодии для сохранения
     * @return сохраненная мелодия
     */
    public Melody createOrUpdateMelody(Melody melody) {
        return melodyRepository.save(melody);
    }

    /**
     * Возвращает мелодию по её идентификатору.
     *
     * @param id идентификатор мелодии
     * @return мелодия, если найдена
     */
    public Optional<Melody> getMelodyById(Long id) {
        return melodyRepository.findById(id);
    }

    /**
     * Удаляет мелодию по её идентификатору.
     *
     * @param id идентификатор мелодии
     */
    public void deleteMelody(Long id) {
        melodyRepository.deleteById(id);
    }

    /**
     * Возвращает список всех мелодий.
     *
     * @return список всех мелодий
     */
    public List<Melody> getAllMelodies() {
        return melodyRepository.findAll();
    }

    /**
     * Генерирует окончание для текущей мелодии.
     *
     * @param currentMelody текущая мелодия
     * @param length длина окончания мелодии
     * @return список нот для окончания мелодии
     */
    public List<Note> generateMelodyEnding(List<Note> currentMelody, int length) {
        return melodyGenerationService.generateMelodyEnding(currentMelody, length);
    }
}


