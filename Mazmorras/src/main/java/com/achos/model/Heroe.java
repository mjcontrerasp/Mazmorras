package com.achos.model;

import com.achos.enums.TipoPersonaje;

public class Heroe extends Personaje {

    /**
     * Constructor de la clase Heroe
     * @param nombre
     * @param velocidad
     * @param fuerza
     * @param tipoPersonaje
     */
    public Heroe(String nombre, int velocidad, int fuerza, TipoPersonaje tipoPersonaje) {
        super(nombre, velocidad, fuerza, tipoPersonaje);
    }
}
