package com.achos.model;

import java.util.Objects;
import java.util.Random;

import com.achos.enums.TipoPersonaje;
/**
 * Clase Personaje
 * Esta clase representa un personaje en el juego. Contiene atributos como nombre, vida, velocidad,
 * fuerza y posicion. También contiene métodos para atacar y perder vida.
 */
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
    /**
     * Constructor de la clase Personaje
     * @param nombre nombre del personaje
     * @param velocidad velocidad del personaje
     * @param fuerza fuerza del personaje
     * @param tipoPersonaje     tipo de personaje
     */
    protected Personaje(String nombre, int velocidad, int fuerza, TipoPersonaje tipoPersonaje) {
        this.nombre = nombre;
        this.vida = 10;
        this.velocidad = velocidad;
        this.fuerza = fuerza;
        this.posicion = new int[2];
        this.tipoPersonaje = tipoPersonaje;
    }
    /**
     * Constructor de la clase Personaje
     * @param nombre nombre del personaje
     * @param vida vida del personaje
     * @param velocidad velocidad del personaje
     * @param fuerza fuerza del personaje
     */
    protected Personaje(String nombre, int vida, int velocidad, int fuerza) {
        this.nombre = nombre;
        this.setVelocidad(velocidad);
        this.setVida(vida);
        this.setFuerza(fuerza);
        this.posicion = new int[2];
    }
    /**
     *  Devuelve el nombre del personaje
     * @return de tipo String
     */
    public String getNombre() {
        return this.nombre;
    }
    /**
     * Devuelve el nombre del personaje
     * @param nombre nombre del personaje
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * Devuelve la vida del personaje
     * @return de tipo int
     */
    public int getVida() {
        return this.vida;
    }
    /**
     * Devuelve la vida del personaje
     * @param vida vida del personaje
     */
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
    /**
     * Devuelve la velocidad del personaje
     * @return de tipo int
     */
    public int getVelocidad() {
        return this.velocidad;
    }
    /**
     * Devuelve la velocidad del personaje
     * @param velocidad velocidad del personaje
     */
    public void setVelocidad(int velocidad) {
        if (velocidad < 0) {
            this.velocidad = 0;
        } else if (velocidad > 10) {
            this.velocidad = 10;
        } else {
            this.velocidad = velocidad;
        }
    }
    /**
     * Devuelve la fuerza del personaje
     * @return de tipo int
     */
    public int getFuerza() {
        return this.fuerza;
    }
    /**
     * Devuelve la fuerza del personaje
     * @param fuerza fuerza del personaje
     */
    public void setFuerza(int fuerza) {
        if (fuerza < 0) {
            this.fuerza = 0;
        } else if (fuerza > 10) {
            this.fuerza = 10;
        } else {
            this.fuerza = fuerza;
        }
    }
    /**
     * Devuelve la posicion del personaje
     * @return de tipo int[]
     */
    public int[] getPosicion() {
        return this.posicion;
    }
    /**
     * Devuelve la posicion del personaje
     * @param posicion posicion del personaje
     */
    public void setPosicion(int[] posicion) {
        this.posicion = posicion;
    }
    /**
     * Devuelve el tipo de personaje
     * @return de tipo TipoPersonaje
     */
    public TipoPersonaje getTipoPersonaje() {
        return this.tipoPersonaje;
    }
    /**
     * Devuelve el tipo de personaje
     * @param tipoPersonaje tipo de personaje
     */
    public void setTipoPersonaje(TipoPersonaje tipoPersonaje) {
        this.tipoPersonaje = tipoPersonaje;
    }

    //quizas no es necesario. REVISAR
    @Override
    public int hashCode() {
        return Objects.hash(nombre, vida, velocidad, fuerza, posicion);
    }
    /**
     * Compara dos personajes
     * @param personaje el personaje a comparar
     * @return un entero que indica si el personaje es mayor, menor o igual al personaje a comparar
     */
    @Override
    public int compareTo(Personaje personaje) {
        if (personaje == null) {
            throw new NullPointerException("El personaje a comparar es nulo");
        } else {
            int comparation = Integer.compare(personaje.getVelocidad(),velocidad);
            if (comparation == 0) {
                comparation = Integer.compare(fuerza,personaje.getFuerza());
                if (comparation == 0) {
                    comparation = nombre.compareTo(personaje.getNombre());
                }
            }
            return comparation;
        }
    }
    /**
     *  Devuelve true si el objeto es igual al personaje
     * @param ataque el objeto a comparar
     */
    public void perderVida(int ataque) {
        setVida(vida - ataque);
    }
    /**
     *  Devuelve true si el objeto es igual al personaje
     * @param ataque el objeto a comparar
     */
    public int atacar() {
        int ataqueMin = fuerza - 5;
        if (ataqueMin < 0) {
            ataqueMin = 0;
        }
        return random.nextInt(fuerza-ataqueMin)+ataqueMin;
    }
    /**
     *  Devuelve true si el objeto es igual al personaje
     * @param obj el objeto a comparar
     */
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
    /**
     *  Devuelve true si el objeto es igual al personaje
     * @param obj el objeto a comparar
     */
    public static void main(String[] args) {
        System.out.println(TipoPersonaje.GABINO);
    }

}
