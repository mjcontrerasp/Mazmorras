package com.achos.model;

import com.achos.enums.TipoCelda;

/**
 * clase Celda
 * Esta clase representa una celda en el laberinto. Cada celda tiene un tipo
 * (suelo o pared),
 * una posición (fila y columna) y puede estar ocupada por un personaje.
 * La celda puede ser ocupada por un personaje, y si es así, se guarda una
 * referencia a ese personaje.
 * La celda también tiene un método para cambiar su estado de ocupación.
 * La celda puede ser de tipo suelo o pared y su posición se representa como un
 * array de dos enteros.
 */
public class Celda {
    private TipoCelda tipoCelda;
    private int[] posicion;
    private Personaje ocupadaPor;
    private int dano = 0;
    private boolean peligrosa = false;

    public boolean isPeligrosa() {
        return tipoCelda == tipoCelda.TRAMPA;
    }

    public void setPeligrosa(boolean peligrosa) {
        this.peligrosa = peligrosa;
    }

    public int getDano() {
        return dano;
    }

    public void setDano(int dano) {
        this.dano = dano;
    }

    /**
     * Constructor por defecto
     * Inicializa la celda sin tipo ni posición.
     */
    public Celda() {
    }

    // revisar orden de fila y columna
    // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    public Celda(TipoCelda tipoCelda, int x, int y) {
        this.tipoCelda = tipoCelda;
        this.posicion = new int[] { y, x };
    }

    /**
     * Devuelve el tipo de celda
     * 
     * @return de tipo TipoCelda
     */
    public TipoCelda getTipoCelda() {
        return this.tipoCelda;

    }

    /**
     * Devuelve el tipo de celda
     * 
     * @return de tipo TipoCelda
     */
    public int[] getPosicicion() {
        return posicion;
    }

    /**
     * Devuelve la posicion de la celda
     * 
     * @param personaje el personaje que ocupa la celda
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
     * 
     * @return de tipo Personaje
     */
    public Personaje getOcupadoPor() {
        return ocupadaPor;
    }

}