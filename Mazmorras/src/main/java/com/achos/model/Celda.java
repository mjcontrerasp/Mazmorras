package com.achos.model;

import com.achos.enums.TipoCelda;

public class Celda {
    private TipoCelda tipoCelda;
    private int[] posicion;
    private Personaje ocupadaPor;

    public Celda() {
    }
    //revisar orden de fila y columna !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    public Celda(TipoCelda tipoCelda, int x, int y) {
        this.tipoCelda = tipoCelda;
        this.posicion = new int[] { y, x };
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
        } else {
            ocupadaPor = null;
        }
    }

    public Personaje getOcupadoPor() {
        return ocupadaPor;
    }

}
