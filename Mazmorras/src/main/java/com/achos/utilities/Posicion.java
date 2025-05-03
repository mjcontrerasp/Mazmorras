package com.achos.utilities;

import java.util.ArrayList;

import com.achos.enums.TipoCelda;
import com.achos.model.*;

public class Posicion {
    /*
     * A partir de una posicion crea un array de 5 posiciones (original, izquierda,
     * derecha, arriba y abajo)
     */
    public static ArrayList<int[]> crearCruceta(int[] posicion) {
        int x = posicion[0];
        int y = posicion[1];
        ArrayList<int[]> cruceta = new ArrayList<>();
        cruceta.add(new int[] { x, y }); // original
        cruceta.add(new int[] { x - 1, y }); // izquierda
        cruceta.add(new int[] { x + 1, y }); // derecha
        cruceta.add(new int[] { x, y + 1 }); // arriba
        cruceta.add(new int[] { x, y - 1 }); // abajo
        return cruceta;
    }

    /* Elimina posiciones de la cruceta que sean fuera del mapa */
    public static void limpiarFueraLimites(ArrayList<int[]> cruceta, Mapa mapa) {
        for (int i = 0; i < cruceta.size(); i++) {
            if (!dentroLimites(cruceta.get(i), mapa)) {
                cruceta.remove(i);
            }
        }
    }

    /* Posicion dentro de los límities */
    public static boolean dentroLimites(int[] posicion, Mapa mapa) {
        int xMax = mapa.getCeldas().get(0).size();
        int yMax = mapa.getCeldas().size();
        return posicion[0] < xMax || posicion[1] < yMax;
    }

    /*
     * Elimina posiciones de la cruceta de posiciones que colisionen con un
     * muro
     */
    public static void limpiarMuro(ArrayList<int[]> cruceta, Mapa mapa) {
        for (int i = 0; i < cruceta.size(); i++) {
            if (!noPared(cruceta.get(i), mapa)) {
                cruceta.remove(i);
            }
        }
    }

    /* Posicion sin colision con pared */
    public static boolean noPared(int[] posicion, Mapa mapa) {
        return mapa.getCeldas().get(posicion[1]).get(posicion[0]).getTipoCelda() != TipoCelda.PARED;
    }

    /* Devuelve en double la distancia entre dos posiciones */
    public static double distancia(int[] posicion1, int[] posicion2) {
        int xPosicion1 = posicion1[0];
        int yPosicion1 = posicion1[1];
        int xPosicion2 = posicion2[0];
        int yPosicion2 = posicion2[1];
        int xAbsoluta = Math.abs(xPosicion1 - xPosicion2);
        int yAbsoluta = Math.abs(yPosicion1 - yPosicion2);
        return Math.sqrt(Math.pow(xAbsoluta, 2) + Math.pow(yAbsoluta, 2));
    }

    /* Devuelve la posicion más cercana de una cruceta a una posicion dada */
    public static int[] posicionMasCerca(int[] posicion, ArrayList<int[]> cruceta) {
        int[] posicionFinal = cruceta.get(0);
        for (int i = 1; i < cruceta.size(); i++) {
            if (distancia(posicion, cruceta.get(i)) < distancia(posicion, posicionFinal)) {
                posicionFinal = cruceta.get(i);
            }
        }
        return posicionFinal;
    }

    /* Comprueba si es una posicion */
}
