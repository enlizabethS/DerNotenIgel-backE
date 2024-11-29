package com.example.dernotenigel.audio.repository;

import com.example.dernotenigel.audio.model.SheetMusic;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SheetMusicRepository {

    private final List<SheetMusic> sheetMusicList = new ArrayList<>(); // Имитация хранилища

    public void save(SheetMusic sheetMusic) {
        sheetMusicList.add(sheetMusic);
    }

    public List<SheetMusic> findAll() {
        return new ArrayList<>(sheetMusicList);
    }
}

