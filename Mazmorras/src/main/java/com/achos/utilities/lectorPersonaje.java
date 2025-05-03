package com.achos.utilities;

import java.util.TreeSet;

import com.achos.model.Personaje;

public class LectorPersonaje {

    public static TreeSet<Personaje> leerPersonajes(String path) {
        TreeSet<Personaje> personajes = new TreeSet<>();
        // aqui ocurre la magia
        /*
         * Cada linea es un personaje distinto, cuando leeas una linea creas un
         * personaje y haces un personajes.add(personaje creado)
         * De esta forma los personajes se van a ir ordenando por si solos en el TreeSet
         * debido a que implementan Comparable (en funcion de la velocidad)
         */
        /*
         * Posicion 1 es new Heroe() y es TipoPersonaje.PABLO
         * Posicion +1 es siempre new Enemigo() y es tipoPersonaje TipoPersonaje.MANU,
         * .GLORIA o .GABINO en función del número de línea del .csv
         */
        return personajes;
    }

}
