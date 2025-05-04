package com.achos.model;

import java.util.ArrayList;

import com.achos.utilities.LectorMapa;

public class Mapa {
    private ArrayList<ArrayList<Celda>> celdas;
    private String nombre;
    private String path;

    public Mapa() {
    }

    public Mapa(String nombre) {
        this.nombre = nombre;
        this.celdas = LectorMapa.leerMapa(path);
        this.path = createPath(nombre);
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
        return "/data/" + nombre + ".txt";
    }

}
