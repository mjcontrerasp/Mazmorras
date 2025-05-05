package com.achos.model;

import java.util.ArrayList;

import com.achos.enums.TipoCelda;
import com.achos.utilities.cabron;

public class Mapa {
    private ArrayList<ArrayList<Celda>> celdas;
    private String nombre;
    private String path;

    public Mapa() {
    }

    public Mapa(String nombre) {
        this.nombre = nombre;
        this.path = createPath(nombre);
        this.celdas = cabron.leerMapa(path);
    }

    public ArrayList<ArrayList<Celda>> getCeldas() {
        return this.celdas;
    }

    public void setCeldas(ArrayList<ArrayList<Celda>> celdas) {
        this.celdas = celdas;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPath() {
        return this.path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    private String createPath(String nombre) {
        return "Mazmorras/src/main/resources/com/achos/data/" + nombre + ".csv";

    }

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

    /*
     * Devuelve en String el tipo de Celda en formato tabulado y en caso de ser un
     * suelo que contenga un
     * personaje, devuelve el tipo de personaje en mayusculas
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
