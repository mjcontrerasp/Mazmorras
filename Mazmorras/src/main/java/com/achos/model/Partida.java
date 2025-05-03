package com.achos.model;

import java.util.ArrayList;
import java.util.TreeSet;

import com.achos.enums.TipoPersonaje;
import com.achos.utilities.LectorPersonaje;
import com.achos.utilities.Posicion;

public class Partida {
    private static Partida instance;
    private Mapa mapa;
    private TreeSet<Personaje> personajes;
    private String pathPersonajes;
    private String pathMapa;
    private Heroe heroe;
    private int[][] spawn = new int[][] { { 1, 13 }, { 13, 5 }, { 1, 8 }, { 13, 1 } };

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
    private void buscarPersonaje() {
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

    public void moverPersonajes(int[] posicion) {
        buscarPersonaje();
        ArrayList<Personaje> personajesCopia = new ArrayList<>(personajes);
        for (int i = 0; i < personajesCopia.size(); i++) {
            if (personajesCopia.get(i) instanceof Heroe) {
                moverHeroe(posicion);
            } else {
                Enemigo enemigo = (Enemigo) personajesCopia.get(i);
                moverEnemigo(enemigo);
            }
        }
        personajes = new TreeSet<>(personajesCopia);
    }

    /* Mover heroe almacenado en partida */
    public void moverHeroe(int[] movimiento) {
        int[] nuevaPosicion = Posicion.mover(heroe.getPosicicion(), movimiento);
        if (Posicion.dentroLimites(nuevaPosicion, mapa) && Posicion.noPared(nuevaPosicion, mapa)) {
            if (buscarCelda(nuevaPosicion).getOcupadoPor() instanceof Enemigo) {
                buscarCelda(nuevaPosicion).getOcupadoPor().perderVida(heroe.atacar());
            } else {
                heroe.setPosicion(nuevaPosicion);
            }
        }
    }

    public void moverEnemigo(Enemigo enemigo) {
        if (enemigo.getVida() > 0
                && Posicion.distancia(heroe.getPosicicion(), enemigo.getPosicicion()) <= enemigo.getPercepcion()) {
            ArrayList<int[]> cruceta = Posicion.crearCruceta(enemigo.getPosicicion());
            Posicion.limpiarFueraLimites(cruceta, mapa);
            Posicion.limpiarMuro(cruceta, mapa);
            int[] posicionMasCerca = Posicion.posicionMasCerca(heroe.getPosicicion(), cruceta);
            if (posicionMasCerca == heroe.getPosicicion()) {
                heroe.perderVida(enemigo.atacar());
            } else {
                enemigo.setPosicion(posicionMasCerca);
            }
        }

    }
}
