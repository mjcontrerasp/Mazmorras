package com.achos.interfaces;
/**
 * Observer
 * Esta interfaz define el método onChange() que debe ser implementado por las clases que deseen
 * recibir notificaciones de cambios en el estado de un objeto observado.
 */
public interface Observer {
    public void onChange();
}
