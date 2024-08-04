package com.example.dernotenigel.controller;

import com.example.dernotenigel.model.Melody;
import com.example.dernotenigel.model.Note;
import com.example.dernotenigel.service.MelodyGenerationService;
import com.example.dernotenigel.service.MelodyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/melodies")
public class MelodyController {

    @Autowired
    private MelodyService melodyService;

    @Autowired
    private MelodyGenerationService melodyGenerationService;

    /**
     * Создает или обновляет мелодию.
     *
     * @param melody объект мелодии для сохранения
     * @return сохраненная мелодия
     */
    @PostMapping("/createOrUpdate")
    public Melody createOrUpdateMelody(@RequestBody Melody melody) {
        return melodyService.createOrUpdateMelody(melody);
    }

    /**
     * Получает мелодию по ее идентификатору.
     *
     * @param id идентификатор мелодии
     * @return мелодия, если найдена
     */
    @GetMapping("/{id}")
    public Optional<Melody> getMelodyById(@PathVariable Long id) {
        return melodyService.getMelodyById(id);
    }

    /**
     * Удаляет мелодию по ее идентификатору.
     *
     * @param id идентификатор мелодии
     */
    @DeleteMapping("/{id}")
    public void deleteMelody(@PathVariable Long id) {
        melodyService.deleteMelody(id);
    }

    /**
     * Получает список всех мелодий.
     *
     * @return список всех мелодий
     */
    @GetMapping("/all")
    public List<Melody> getAllMelodies() {
        return melodyService.getAllMelodies();
    }

    /**
     * Генерирует окончание для текущей мелодии.
     *
     * @param currentMelody текущая мелодия
     * @param length длина окончания мелодии
     * @return список нот для окончания мелодии
     */
    @PostMapping("/generateEnding")
    public List<Note> generateMelodyEnding(@RequestBody List<Note> currentMelody, @RequestParam(defaultValue = "4") int length) {
        return melodyGenerationService.generateMelodyEnding(currentMelody, length);
    }
}


