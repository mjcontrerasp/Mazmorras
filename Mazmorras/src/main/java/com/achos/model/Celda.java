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

    /**
     * Devuelve el tipo de celda
     * @return
     */
    public TipoCelda getTipoCelda() {
        return this.tipoCelda;
        
    }
    /**
     * Devuelve el tipo de celda
     * @return
     */
    public int[] getPosicicion() {
        return posicion;
    }
    /**
     * Devuelve la posicion de la celda
     * @param personaje
     */
    public void setOcupadoPor(Personaje personaje) {
        if (ocupadaPor == null) {
            ocupadaPor = personaje;
        } else {
            ocupadaPor = null;
        }
    }
    /**
     * Devuelve el personaje que ocupa la celda
     * @return
     */
    public Personaje getOcupadoPor() {
        return ocupadaPor;
    }

}
