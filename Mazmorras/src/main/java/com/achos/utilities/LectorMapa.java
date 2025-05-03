package com.achos.utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.achos.enums.TipoCelda;
import com.achos.model.Celda;

public class LectorMapa {
    public static ArrayList<ArrayList<Celda>> leerMapa(String path) {
        File fichero = new File(path);
        ArrayList<ArrayList<Celda>> celdas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fichero))) {
            String linea;
            TipoCelda tipoCelda;
            while ((linea = br.readLine()) != null) {
                String[] lineadeCeldas = linea.split(",");
                ArrayList<Celda> nuevaLineaCeldas = new ArrayList<>();

                for (int i = 0; i < lineadeCeldas.length; i++) {
                    if (lineadeCeldas[i].equals("l")) {
                        tipoCelda = TipoCelda.SUELO;
                    } else {
                        tipoCelda = TipoCelda.PARED;
                    }
                    nuevaLineaCeldas.add(new Celda(tipoCelda, i, i));
                }
                celdas.add(nuevaLineaCeldas);
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
