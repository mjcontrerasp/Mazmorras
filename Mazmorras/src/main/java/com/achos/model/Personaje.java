package com.achos.model;

import java.util.Objects;
import java.util.Random;

import com.achos.enums.TipoPersonaje;

public class Personaje implements Comparable<Personaje> {
    protected String nombre;
    protected int vida;
    protected int velocidad;
    protected int fuerza;
    protected int[] posicion;
    protected TipoPersonaje tipoPersonaje;
    protected Random random = new Random();

    protected Personaje() {
    }

    protected Personaje(String nombre, int velocidad, int fuerza, TipoPersonaje tipoPersonaje) {
        this.nombre = nombre;
        this.vida = 10;
        this.velocidad = velocidad;
        this.fuerza = fuerza;
        this.posicion = new int[2];
        this.tipoPersonaje = tipoPersonaje;
    }

    protected Personaje(String nombre, int vida, int velocidad, int fuerza) {
        this.nombre = nombre;
        this.setVelocidad(velocidad);
        this.setVida(vida);
        this.setFuerza(fuerza);
        this.posicion = new int[2];
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
        } else if (velocidad > 10) {
            this.velocidad = 10;
        } else {
            this.velocidad = velocidad;
        }
    }

    public int getFuerza() {
        return this.fuerza;
    }

    public void setFuerza(int fuerza) {
        if (fuerza < 0) {
            this.fuerza = 0;
        } else if (fuerza > 10) {
            this.fuerza = 10;
        } else {
            this.fuerza = fuerza;
        }
    }

    public int[] getPosicion() {
        return this.posicion;
    }

    public void setPosicion(int[] posicion) {
        this.posicion = posicion;
    }

    public TipoPersonaje getTipoPersonaje() {
        return this.tipoPersonaje;
    }

    public void setTipoPersonaje(TipoPersonaje tipoPersonaje) {
        this.tipoPersonaje = tipoPersonaje;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, vida, velocidad, fuerza, posicion);
    }

    @Override
    public int compareTo(Personaje personaje) {
        if (personaje == null) {
            throw new NullPointerException("El personaje a comparar es nulo");
        } else {
            return Integer.compare(personaje.getVelocidad(),velocidad);
        }
    }

    public void perderVida(int ataque) {
        setVida(vida - ataque);
    }

    public int atacar() {
        int ataqueMin = fuerza - 5;
        if (ataqueMin < 0) {
            ataqueMin = 0;
        }
        return random.nextInt(fuerza-ataqueMin)+ataqueMin;
    }

    @Override
    public String toString() {
        return "\n{" +
                " nombre='" + getNombre() + "'" +
                ", vida='" + getVida() + "'" +
                ", velocidad='" + getVelocidad() + "'" +
                ", fuerza='" + getFuerza() + "'" +
                ", posicion='[ " + getPosicion()[0] + " , " +getPosicion()[1] +" ]'"+
                ", tipoPersonaje='" + getTipoPersonaje() + "'" +
                "}";
    }

    public static void main(String[] args) {
        System.out.println(TipoPersonaje.GABINO);
    }

}
