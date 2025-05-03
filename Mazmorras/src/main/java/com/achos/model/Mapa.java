package com.achos.model;

import java.util.ArrayList;
import java.util.Objects;

import com.achos.utilities.LectorMapa;

public class Mapa {
    private ArrayList<ArrayList<Celda>> celdas;
    private String nombre;
    private String path;

    public Mapa() {
    }

    public Mapa(String nombre, String path){
        this.celdas = LectorMapa.leerMapa(path);
        this.nombre = nombre;
        this.path = path;
    }
    public Mapa(ArrayList<ArrayList<Celda>> celdas, String nombre, String path) {
        this.celdas = celdas;
        this.nombre = nombre;
        this.path = path;
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
    
    
}
