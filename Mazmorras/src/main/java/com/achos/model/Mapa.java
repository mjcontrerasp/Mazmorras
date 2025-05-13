package com.achos.model;

import java.util.ArrayList;

import com.achos.enums.TipoCelda;
import com.achos.utilities.LectorMapa;
/**
 * Clase Mapa
 * Esta clase representa un mapa en el juego. Contiene una lista de listas de celdas que representan
 * el mapa y un nombre para identificarlo.
 */
public class Mapa {
    private ArrayList<ArrayList<Celda>> celdas;
    private String nombre;
    private String path;

    public Mapa() {
    }
    /**
     * Constructor de la clase Mapa
     * @param nombre nombre del mapa
     */
    public Mapa(String nombre) {
        this.nombre = nombre;
        this.path = createPath(nombre);
        this.celdas = LectorMapa.leerMapa(path);
    }
    /**
     * Constructor de la clase Mapa
     * @param nombre nombre del mapa
     * @param celdas lista de listas de celdas que representan el mapa
     */
    public ArrayList<ArrayList<Celda>> getCeldas() {
        return this.celdas;
    }
    /**
     * Constructor de la clase Mapa
     * @param celdas lista de listas de celdas que representan el mapa
     */
    public void setCeldas(ArrayList<ArrayList<Celda>> celdas) {
        this.celdas = celdas;
    }
    /**
     * Devuelve el nombre del mapa
     * @return de tipo String
     */
    public String getNombre() {
        return this.nombre;
    }
    /**
     * Devuelve el nombre del mapa
     * @param nombre nombre del mapa
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * Devuelve el path del mapa
     * @return de tipo String
     */
    public String getPath() {
        return this.path;
    }
    /**
     * Devuelve el path del mapa
     * @param path path del mapa
     */
    public void setPath(String path) {
        this.path = path;
    }
    /**
     * Crea el path del mapa
     * @param nombre nombre del mapa
     * @return de tipo String
     */
    private String createPath(String nombre) {
        return "Mazmorras/src/main/resources/com/achos/data/" + nombre + ".csv";

    }
    /**
     * Devuelve el mapa en formato String
     * @return de tipo String
     */
    @Override
    public String toString() {
        String mapaToString = "\nNombre: " + nombre
                + "\nPath: " + path;
        for (int i = 0; i < celdas.size(); i++) {
            mapaToString += "\n";
            for (int j = 0; j < celdas.get(i).size(); j++) {
                mapaToString += tipoToString(celdas.get(i).get(j));
            }
        }
        return mapaToString;
    }

    
    /**
     * Devuelve en String el tipo de Celda en formato tabulado y en caso de ser un
     * suelo que contenga un
     * personaje, devuelve el tipo de personaje en mayusculas
     * @param celda
     * @return de tipo String
     */
    public String tipoToString(Celda celda) {
        String tipoToString = "";
        if (celda.getTipoCelda() == TipoCelda.PARED) {
            tipoToString = "\tx";
        } else if (celda.getOcupadoPor() == null) {
            tipoToString = "\t-";
        } else {
            switch (celda.getOcupadoPor().getTipoPersonaje()) {
                case PABLO:
                    tipoToString = "\tPABLO";
                    break;
                case MANU:
                    tipoToString = "\tMANU";
                    break;
                case GLORIA:
                    tipoToString = "\tGLORIA";
                    break;
                case GABINO:
                    tipoToString = "\tGABINO";
                    break;
                default:
                    tipoToString = "\tERROR";
            }
        }
        return tipoToString;
    }

}
