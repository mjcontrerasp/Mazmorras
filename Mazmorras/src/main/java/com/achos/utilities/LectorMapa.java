package com.achos.utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.achos.enums.TipoCelda;
import com.achos.model.Celda;
/**
 * Clase LectorMapa
 * 
 * Esta clase se encarga de leer un archivo CSV que representa un mapa y convertirlo en una lista de listas de celdas.
 * Cada celda puede ser un suelo o una pared, representados por los caracteres 'l' y 'o' respectivamente.
 */
public class LectorMapa {
    /**
     * Método que lee un archivo CSV y convierte su contenido en una lista de listas de celdas.
     * 
     * @param path Ruta del archivo CSV a leer.
     * @return ArrayList<ArrayList<Celda>> Lista de listas de celdas representando el mapa.
     */
    public static ArrayList<ArrayList<Celda>> leerMapa(String path) {
        File fichero = new File(path);
        ArrayList<ArrayList<Celda>> celdas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fichero))) {
            String linea;
            TipoCelda tipoCelda;
            int columna = 0;
            while ((linea = br.readLine()) != null) {
                String[] stringCeldas = linea.split(",");
                ArrayList<Celda> nuevaFilaCeldas = new ArrayList<>();

                for (int fila = 0; fila < stringCeldas.length; fila++) {
                    String celda = stringCeldas[fila].trim().toLowerCase();
                    if (celda.equals("l")) {
                        tipoCelda = TipoCelda.SUELO;
                    } else if (celda.equals("o")) {
                        tipoCelda = TipoCelda.PARED;
                    } else {
                        throw new IllegalArgumentException("Carácter inválido en el mapa: " + celda);
                    }
                    nuevaFilaCeldas.add(new Celda(tipoCelda, fila, columna));
                }
                celdas.add(nuevaFilaCeldas);
                columna++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return celdas;
    }

    public static void main(String[] args) {
        String path = "Mazmorras/src/main/resources/com/achos/data/mapa3.csv";

        ArrayList<ArrayList<Celda>> mapa = LectorMapa.leerMapa(path);

        for (int i = 0; i < mapa.size(); i++) {
            for (int j = 0; j < mapa.get(i).size(); j++) {
                Celda celda = mapa.get(i).get(j);
                System.out.print(celda.getTipoCelda() + " ");
            }
            System.out.println(); // salto de línea entre filas
        }
    }
}