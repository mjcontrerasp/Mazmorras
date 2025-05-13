package com.achos.model;

import com.achos.enums.TipoPersonaje;
/**
 * Clase Enemigo
 * Esta clase representa un enemigo en el juego. Hereda de la clase Personaje y añade un atributo
 * para la percepción del enemigo.
 * La percepción del enemigo se utiliza para determinar si puede detectar al jugador o no.
 */
public class Enemigo extends Personaje {
    private int percepcion;
    /**
     * Constructor de la clase Enemigo
     * @param nombre nombre del enemigo
     * @param velocidad velocidad del enemigo
     * @param fuerza fuerza del enemigo
     * @param tipoPersonaje     tipo de personaje del enemigo
     * @param percepcion percepción del enemigo
     */
    public Enemigo(String nombre, int velocidad, int fuerza, TipoPersonaje tipoPersonaje, int percepcion) {
        super(nombre, velocidad, fuerza, tipoPersonaje);
        this.percepcion = percepcion;
    }
    /**
     * Devuelve la percepcion del enemigo
     * @return de tipo int
     */
    public int getPercepcion() {
        return percepcion;
    }
}
