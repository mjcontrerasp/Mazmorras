package com.achos.model;

import com.achos.enums.TipoCelda;
import java.util.Objects;

public class Celda {
    private TipoCelda tipoCelda;
    private int[] posicion;
    private Personaje ocupadaPor;

    public Celda() {
    }

    public Celda(TipoCelda tipoCelda, int x, int y) {
        this.tipoCelda = tipoCelda;
        this.posicion = new int[2];
        posicion[0] = x;
        posicion[1] = y;
    }

    public TipoCelda getTipoCelda() {
        return this.tipoCelda;
    }

    public int[] getPosicicion() {
        return posicion;
    }

    public void setOcupadoPor(Personaje personaje) {
        if (ocupadaPor == null) {
            ocupadaPor = personaje;
        }
    }

    public Personaje getOcupadoPor(){
        return ocupadaPor;
    }
}
