package com.achos.model;

import java.util.TreeSet;

import com.achos.enums.TipoPersonaje;
import com.achos.utilities.LectorPersonaje;

public class Partida {
    private static Partida instance;
    private Mapa mapa;
    private TreeSet<Personaje> personajes;
    private String pathPersonajes;
    private String pathMapa;

    private Partida() {
        personajes = LectorPersonaje.leerPersonajes(pathPersonajes);
    }

    public Partida getInstance() {
        if (instance == null) {
            instance = new Partida();
        }
        return instance;
    }

    public void moverPersonajes(int x, int y){
        for (Personaje personaje : personajes) {
            if (personaje.getTipoPersonaje() != TipoPersonaje.PABLO) {
                if (per) {
                    
                }
            }
        }
    }
}
