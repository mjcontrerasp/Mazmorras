package com.achos.model;

import java.util.TreeSet;
import com.achos.utilities.lectorPersonaje;

public class Partida {
    private static Partida instance;
    private Mapa mapa;
    private TreeSet<Personaje> personajes;
    private String pathPersonajes;
    private String pathMapa;

    private Partida() {
        personajes = lectorPersonaje.leerPersonajes(pathPersonajes);
    }

    public Partida getInstance() {
        if (instance == null) {
            instance = new Partida();
        }
        return instance;
    }
}
