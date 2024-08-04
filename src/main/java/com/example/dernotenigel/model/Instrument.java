package com.example.dernotenigel.model;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
public class Instrument {
    private String name;

    public Instrument() {}

    public Instrument(String name) {
        this.name = name;
    }

}
