package com.achos.utilities;

import com.achos.model.*;

public class Posicion {
    public static int distancia(Personaje personaje1, Personaje personaje2){
        int x = personaje1.getPosX() - personaje2.getPosX();
        int y = personaje1.getPosY() - personaje2.getPosY();
        return (int) Math.sqrt(x*x + y*y);
    }

    public static int distancia(Personaje personaje, Celda celda){
        int x = personaje.getPosX() - celda.getPosX();
        int y = personaje.getPosY() - celda.getPosY();
        return (int) Math.sqrt(x*x + y*y);
    }

    public static int distancia(Personaje personaje, int posX, int posY){
        int x = personaje.getPosX()-posX;
        int y = personaje.getPosY()-posY;
        return (int) Math.sqrt(x*x + y*y);
    }

    public static void acercar(Personaje personaje1, Personaje personaje2, Mapa mapa){
        int x = 0, y = 0;
        int distancia = Integer.MAX_VALUE;
        int xMenos = personaje2.getPosX()-1;
        int xMas = personaje2.getPosX()+1;
        int yMenos = personaje2.getPosY()-1;
        int yMas = personaje2.getPosY()+1;
        int xMax = mapa.getCeldas().size()-1;
        int yMax = mapa.getCeldas().get(0).size()-1;
        int xNew = 0;
        int yNew = 0;
        if (distancia(personaje1, xMenos, yMenos) < distancia) {
            xNew = xMenos;
            yNew = yMenos;
        }
        if (distancia(personaje1, xMenos, yMenos) < distancia) {
            xNew = xMenos;
            yNew = yMenos;
        }
        if (distancia(personaje1, xMenos, yMenos) < distancia) {
            xNew = xMenos;
            yNew = yMenos;
        }
        if (distancia(personaje1, xMenos, yMenos) < distancia) {
            xNew = xMenos;
            yNew = yMenos;
        }
    }

    public static boolean dentroLimites(int x, int y, Mapa mapa){
        if (x < mapa.getCeldas().size() && y < mapa.getCeldas().get(0).size()) {
            return true;
        }
        return false;
    }

    public static ArrayList<int []>
}
