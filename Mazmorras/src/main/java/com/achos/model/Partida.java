package com.achos.model;

import java.util.ArrayList;
import java.util.TreeSet;

import com.achos.enums.TipoPersonaje;
import com.achos.utilities.LectorPersonaje;

public class Partida {
    private static Partida instance;
    private Mapa mapa;
    private TreeSet<Personaje> personajes;
    private String pathPersonajes;
    private String pathMapa;
    private Heroe heroe;

    private Partida() {
        personajes = LectorPersonaje.leerPersonajes(pathPersonajes);
    }

    public Partida getInstance() {
        if (instance == null) {
            instance = new Partida();
        }
        return instance;
    }

    /* Encuentra y guarda el Heroe de la lista de personajes */
    public void buscarPersonaje() {
        for (Personaje personaje : personajes) {
            if (personaje instanceof Heroe) {
                this.heroe = (Heroe) personaje;
            }
        }
    }

    public void moverPersonajes(int[] posicion) {
        ArrayList<Personaje> personajesCopia = new ArrayList<>(personajes);
        for (int i = 0; i < personajesCopia.size(); i++) {
            if (personajesCopia.get(i) instanceof Heroe) {
                personajesCopia.get(i).mover(x, y);
            }
        }
    }
}
