package com.achos.model;

import com.achos.enums.TipoPersonaje;

public class Heroe extends Personaje {

    /**
     * Constructor de la clase Heroe
     * @param nombre nombre del heroe
     * @param velocidad velocidad del heroe
     * @param fuerza fuerza del heroe
     * @param tipoPersonaje tipo de personaje del heroe
     */
    public Heroe(String nombre, int velocidad, int fuerza, TipoPersonaje tipoPersonaje) {
        super(nombre, velocidad, fuerza, tipoPersonaje);
    }
}
