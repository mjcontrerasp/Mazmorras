package com.achos.model;

import com.achos.enums.TipoPersonaje;

public class Enemigo extends Personaje{
    private int percepcion;

    public Enemigo(String nombre, int velocidad, int fuerza, TipoPersonaje tipoPersonaje, int percepcion){
        super(nombre, velocidad, fuerza, tipoPersonaje);
        this.percepcion = percepcion;
    }
}
