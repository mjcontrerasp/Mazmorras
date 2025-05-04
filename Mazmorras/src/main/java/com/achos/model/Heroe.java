package com.achos.model;

import com.achos.enums.TipoPersonaje;

public class Heroe extends Personaje {

    public Heroe(String nombre, int velocidad, int fuerza, TipoPersonaje tipoPersonaje) {
        super(nombre, velocidad, fuerza, tipoPersonaje);
    }
}
