package com.achos.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

import com.achos.enums.TipoPersonaje;
import com.achos.interfaces.Observer;
import com.achos.utilities.LectorPersonajes;
import com.achos.utilities.Posicion;

public class Partida {
    private static Partida instance;
    private TreeSet<Personaje> personajes;
    private String pathPersonajes = "Mazmorras/src/main/resources/com/achos/data/personajes.json";
    private Heroe heroe;
    private int[][] spawn = new int[][] { { 13, 1 }, { 5, 13 }, { 8, 1 }, { 1, 13 } };
    private String nombreMapa;
    private Mapa mapa;

    private ArrayList<Observer> observers = new ArrayList<>();

    public void subscribe(Observer observer) {
        observers.add(observer);
    }

    public void notifyObservers() {
        observers.forEach(i -> i.onChange());
    }

    private Partida() {
        personajes = LectorPersonajes.leerPersonajes(pathPersonajes);
        buscarHeroe();
        nombreMapa = "mapa3";
        mapa = new Mapa(nombreMapa);
        if (mapa.getCeldas() == null || mapa.getCeldas().isEmpty()) {
            throw new IllegalStateException("El mapa no se cargó correctamente.");
        }
        personajesToSpawn();
    
    }

    public static Partida getInstance() {
        if (instance == null) {
            instance = new Partida();
        }
        return instance;
    }

    /* Getters and setters */
    public TreeSet<Personaje> getPersonajes() {
        return personajes;
    }

    public Mapa getMapa() {
        return mapa;
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
        buscarPersonaje(TipoPersonaje.PABLO).setPosicion(spawn[0]);
        buscarCelda(spawn[1]).setOcupadoPor(buscarPersonaje(TipoPersonaje.MANU));
        buscarPersonaje(TipoPersonaje.MANU).setPosicion(spawn[1]);
        buscarCelda(spawn[2]).setOcupadoPor(buscarPersonaje(TipoPersonaje.GLORIA));
        buscarPersonaje(TipoPersonaje.GLORIA).setPosicion(spawn[2]);
        buscarCelda(spawn[3]).setOcupadoPor(buscarPersonaje(TipoPersonaje.GABINO));
        buscarPersonaje(TipoPersonaje.GABINO).setPosicion(spawn[3]);
    }

    /*
     * Buscar personaje por tipo. Sirve solo para buscar a un unico Heroe. Si buscas
     * a un Enemigo, te devolverá el primer Enemigo encontrado.
     */
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
            celdaEncontrada = mapa.getCeldas().get(posicion[0]).get(posicion[1]);
        }
        return celdaEncontrada;
    }

    /* Aplica movimiento por orden de velocidad a todos los personajes */
    public void moverPersonajes(int[] posicion) {
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
        notifyObservers();
    }

    /* Mover heroe almacenado en partida */
    public void moverHeroe(int[] movimiento) {
        int[] nuevaPosicion = Posicion.mover(heroe.getPosicion(), movimiento);
        if (Posicion.dentroLimites(nuevaPosicion, mapa)) {
            if (Posicion.noPared(nuevaPosicion, mapa)) {
                if (buscarCelda(nuevaPosicion).getOcupadoPor() instanceof Enemigo) {
                    buscarCelda(nuevaPosicion).getOcupadoPor().perderVida(heroe.atacar());
                } else {
                    buscarCelda(heroe.getPosicion()).setOcupadoPor(null);
                    heroe.setPosicion(nuevaPosicion);
                    buscarCelda(heroe.getPosicion()).setOcupadoPor(heroe);
                }
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
            if (buscarCelda(posicionMasCerca).getOcupadoPor() != null) {
                if (Arrays.equals(posicionMasCerca, heroe.getPosicion())) {
                    heroe.perderVida(enemigo.atacar());
                }
            } else {
                buscarCelda(enemigo.getPosicion()).setOcupadoPor(null);
                enemigo.setPosicion(posicionMasCerca);
                buscarCelda(enemigo.getPosicion()).setOcupadoPor(enemigo);
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

    private void testeo() {
        Scanner sc = new Scanner(System.in);
        String mov;
        boolean flag = true;
        int[] posicion = new int[2];
        System.out.println(getMapa().toString());
        System.out.println(this.getPersonajes().toString());
        while (flag) {
            System.out.print("Movimiento: ");
            mov = sc.nextLine();
            switch (mov) {
                case "a":
                    posicion = new int[] { 0, -1 };
                    break;
                case "w":
                    posicion = new int[] { -1, 0 };
                    break;
                case "s":
                    posicion = new int[] { 1, 0 };
                    break;
                case "d":
                    posicion = new int[] { 0, 1 };
                    break;

                default:
                    flag = false;
                    break;
            }
            moverPersonajes(posicion);
            System.out.println(getMapa().toString());
            System.out.println(this.getPersonajes().toString());
        }
        sc.close();
    }

    /* Testear */
    public static void main(String[] args) {
        Partida partida = new Partida();
        partida.testeo();

    }
}
