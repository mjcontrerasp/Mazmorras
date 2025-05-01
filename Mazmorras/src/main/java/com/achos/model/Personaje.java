package com.achos.model;

import java.util.Objects;
import java.util.Random;

import javax.crypto.AEADBadTagException;

import com.achos.enums.TipoPersonaje;

public class Personaje implements Comparable<Personaje> {
    private String nombre;
    private int vida;
    private int velocidad;
    private int fuerza;
    private int posX;
    private int posY;
    private TipoPersonaje tipoPersonaje;
    private Random random = new Random();

    public Personaje() {
    }

    public Personaje(String nombre, int vida, int velocidad, int fuerza) {
        this.nombre = nombre;
        this.setVelocidad(velocidad);
        this.setVida(vida);
        this.setFuerza(fuerza);
        this.posX = 0;
        this.posY = 0;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVida() {
        return this.vida;
    }

    public void setVida(int vida) {
        if (vida < 0) {
            this.vida = 0;
            this.velocidad = 0;
        } else if (vida > 10) {
            this.vida = 10;
        } else {
            this.vida = vida;
        }

    }

    public int getVelocidad() {
        return this.velocidad;
    }

    public void setVelocidad(int velocidad) {
        if (velocidad < 0) {
            this.velocidad = 0;
        }else if (velocidad > 10) {
            this.velocidad = 10;
        }else{
            this.velocidad = velocidad;
        }
    }

    public int getFuerza() {
        return this.fuerza;
    }

    public void setFuerza(int fuerza) {
        if (fuerza < 0) {
            this.fuerza = 0;
        }else if (fuerza > 10) {
            this.fuerza = 10;
        }else{
            this.fuerza = fuerza;
        }
    }

    public int getPosX() {
        return this.posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return this.posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public int getNumPersonaje() {
        return this.numPersonaje;
    }

    public void setNumPersonaje(int numPersonaje) {
        this.numPersonaje = numPersonaje;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Personaje)) {
            return false;
        }
        Personaje personaje = (Personaje) o;
        return Objects.equals(nombre, personaje.nombre) && vida == personaje.vida && velocidad == personaje.velocidad
                && fuerza == personaje.fuerza && posX == personaje.posX && posY == personaje.posY
                && numPersonaje == personaje.numPersonaje;
    }

    @Override
    public String toString() {
        return "{" +
                " nombre='" + getNombre() + "'" +
                ", vida='" + getVida() + "'" +
                ", velocidad='" + getVelocidad() + "'" +
                ", fuerza='" + getFuerza() + "'" +
                ", posX='" + getPosX() + "'" +
                ", posY='" + getPosY() + "'" +
                ", numPersonaje='" + getNumPersonaje() + "'" +
                "}";
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, vida, velocidad, fuerza, posX, posY);
    }

    @Override
    public int compareTo(Personaje personaje) {
        if (personaje == null) {
            throw new NullPointerException("El personaje a comparar es nulo");
        } else {
            return Integer.compare(velocidad, personaje.getVelocidad());
        }
    }

    public void mover(int x, int y) {
        posX += x;
        posY += y;
    }

    public void perderVida(int ataque) {
        setVida(vida - ataque);
    }

    public int atacar() {
        int ataqueMin = fuerza - 5;
        if (ataqueMin < 0) {
            ataqueMin = 0;
        }
        return random.nextInt(ataqueMin, fuerza);
    }

}
