package org.example;
import static org.junit.jupiter.api.Assertions.*;
/**
 * Clase que representa una nota registrada durante una reunión.
 * Las notas pueden contener información importante, observaciones
 * o acuerdos alcanzados durante la sesión.
 *
 * @author ignacio578
 */
 class Nota {
    /** Contenido textual de la nota. */

    private  String contenido;

    /**
     * Crea una nueva nota con el contenido especificado.
     *
     * @param contenido Texto de la nota.
     */
    public Nota(String contenido) {
        this.contenido = contenido;
    }
    /**
     * Obtiene el contenido actual de la nota.
     *
     * @return Contenido de la nota.
     */
    public String getContenido() {
        return contenido;
    }

     public void setContenido(String contenido) {
         this.contenido = contenido;
     }
    /**
     * Devuelve una representación textual de la nota.
     *
     * @return Cadena que representa la nota.
     */
     @Override
    public String toString() {
        return "Nota{" + contenido + '\''+'}';
    }
 }