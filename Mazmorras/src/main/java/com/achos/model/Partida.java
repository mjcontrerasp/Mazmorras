package com.achos.model;

import java.util.ArrayList;
import java.util.TreeSet;

import com.achos.enums.TipoPersonaje;
import com.achos.utilities.LectorPersonaje;
import com.achos.utilities.Posicion;

public class Partida {
    private static Partida instance;
    private TreeSet<Personaje> personajes;
    private String pathPersonajes = "/data/personajes.csv";
    private Heroe heroe;
    private int[][] spawn = new int[][] { { 1, 13 }, { 13, 5 }, { 1, 8 }, { 13, 1 } };
    private String nombreMapa;
    private Mapa mapa;

    private Partida() {
        personajes = LectorPersonaje.leerPersonajes(pathPersonajes);
        buscarHeroe();
        personajesToSpawn();
        nombreMapa = "mapa1";
        mapa = new Mapa(nombreMapa);
    }

    public Partida getInstance() {
        if (instance == null) {
            instance = new Partida();
        }
        return instance;
    }

    /* Encuentra y guarda el Heroe de la lista de personajes */
    private void buscarHeroe() {
        for (Personaje personaje : personajes) {
            if (personaje instanceof Heroe) {
                this.heroe = (Heroe) personaje;
            }
        }
    }

    /* Asignar personajes a sus celdas spawn */
    public void personajesToSpawn() {
        buscarCelda(spawn[0]).setOcupadoPor(buscarPersonaje(TipoPersonaje.PABLO));
        buscarCelda(spawn[1]).setOcupadoPor(buscarPersonaje(TipoPersonaje.MANU));
        buscarCelda(spawn[2]).setOcupadoPor(buscarPersonaje(TipoPersonaje.GLORIA));
        buscarCelda(spawn[3]).setOcupadoPor(buscarPersonaje(TipoPersonaje.GABINO));
    }

    /* Buscar personaje por tipo */
    public Personaje buscarPersonaje(TipoPersonaje tipoPersonaje) {
        Personaje personajeEncontrado = null;
        for (Personaje personaje : personajes) {
            if (personaje.getTipoPersonaje() == tipoPersonaje) {
                personajeEncontrado = personaje;
            }
        }
        return personajeEncontrado;
    }

    /* Buscar celda */
    public Celda buscarCelda(int[] posicion) {
        Celda celdaEncontrada = null;
        if (Posicion.dentroLimites(posicion, mapa)) {
            celdaEncontrada = mapa.getCeldas().get(posicion[1]).get(posicion[0]);
        }
        return celdaEncontrada;
    }

    /* Aplica movimiento por orden de velocidad a todos los personajes */
    public void moverPersonajes(int[] posicion) {
        buscarHeroe();
        ArrayList<Personaje> personajesCopia = new ArrayList<>(personajes);
        for (int i = 0; i < personajesCopia.size(); i++) {
            if (personajesCopia.get(i) instanceof Heroe) {
                moverHeroe(posicion);
            } else {
                Enemigo enemigo = (Enemigo) personajesCopia.get(i);
                moverEnemigo(enemigo);
            }
            if (gameOver() || victoria()) {
                break;
            }
        }
        personajes = new TreeSet<>(personajesCopia);
    }

    /* Mover heroe almacenado en partida */
    public void moverHeroe(int[] movimiento) {
        int[] nuevaPosicion = Posicion.mover(heroe.getPosicion(), movimiento);
        if (Posicion.dentroLimites(nuevaPosicion, mapa) && Posicion.noPared(nuevaPosicion, mapa)) {
            if (buscarCelda(nuevaPosicion).getOcupadoPor() instanceof Enemigo) {
                buscarCelda(nuevaPosicion).getOcupadoPor().perderVida(heroe.atacar());
            } else {
                heroe.setPosicion(nuevaPosicion);
            }
        }
    }

    /* Mover cualquier enemigo */
    public void moverEnemigo(Enemigo enemigo) {
        if (enemigo.getVida() > 0
                && Posicion.distancia(heroe.getPosicion(), enemigo.getPosicion()) <= enemigo.getPercepcion()) {
            ArrayList<int[]> cruceta = Posicion.crearCruceta(enemigo.getPosicion());
            Posicion.limpiarFueraLimites(cruceta, mapa);
            Posicion.limpiarMuro(cruceta, mapa);
            int[] posicionMasCerca = Posicion.posicionMasCerca(heroe.getPosicion(), cruceta);
            if (posicionMasCerca == heroe.getPosicion()) {
                heroe.perderVida(enemigo.atacar());
            } else {
                enemigo.setPosicion(posicionMasCerca);
            }
        }
    }

    /* Game Over si el heroe tiene vida menor o igual a cero */
    public boolean gameOver() {
        if (heroe.getVida() <= 0) {
            return true;
        } else {
            return false;
        }
    }

    /*
     * Victoria es true por defecto a menos que algun personaje enemigo tenga vida
     * mayor de 0
     */
    public boolean victoria() {
        for (Personaje personaje : personajes) {
            if (personaje instanceof Enemigo && personaje.getVida() >= 0) {
                return false;
            }
        }
        return true;
    }
}
