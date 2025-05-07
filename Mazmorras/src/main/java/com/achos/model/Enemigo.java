package com.achos.model;

import com.achos.enums.TipoPersonaje;

public class Enemigo extends Personaje {
    private int percepcion;
    /**
     * Constructor de la clase Enemigo
     * @param nombre
     * @param velocidad
     * @param fuerza
     * @param tipoPersonaje
     * @param percepcion
     */
    public Enemigo(String nombre, int velocidad, int fuerza, TipoPersonaje tipoPersonaje, int percepcion) {
        super(nombre, velocidad, fuerza, tipoPersonaje);
        this.percepcion = percepcion;
    }
    /**
     * Devuelve la percepcion del enemigo
     * @return
     */
    public int getPercepcion() {
        return percepcion;
    }
}
