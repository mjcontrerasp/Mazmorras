package com.achos.model;

import com.achos.enums.TipoPersonaje;
import com.achos.utilities.Posicion;

public class Heroe extends Personaje{
    

    public Heroe(String nombre, int velocidad, int fuerza, TipoPersonaje tipoPersonaje){
        super(nombre, velocidad, fuerza, tipoPersonaje);
    }

    public void mover(int[] movimiento){
        this.posicion = Posicion.mover(this.posicion, movimiento);
    }
}
