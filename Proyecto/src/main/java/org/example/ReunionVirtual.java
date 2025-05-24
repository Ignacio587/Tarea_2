package org.example;

import java.time.*;
import java.util.Date;

/**
 * Clase que representa una reunión virtual.
 * Extiende la clase {@link Reunion} y agrega el atributo de enlace para la reunión online.
 *
 * @author Farentsen999
 */
public class ReunionVirtual extends Reunion {
    /**
     * Enlace URL para acceder a la reunión virtual.
     */
    private final String enlace;
    /**
     * Constructor para crear una reunión virtual con sus detalles.
     *
     * @param fecha Fecha de la reunión.
     * @param horaPrevista Hora prevista de inicio de la reunión.
     * @param duracionPrevista Duración prevista de la reunión.
     * @param organizador Empleado que organiza la reunión.
     * @param tipo Tipo de la reunión.
     * @param enlace Enlace URL para acceder a la reunión virtual.
     */
    public ReunionVirtual(Date fecha, Instant horaPrevista, Duration duracionPrevista, Empleado organizador, TipoReunion tipo, String enlace) {
        super(fecha, horaPrevista, duracionPrevista, organizador, tipo);
        this.enlace = enlace;
    }
    /**
     * Obtiene el enlace para acceder a la reunión virtual.
     *
     * @return Una cadena que contiene el enlace de la reunión.
     */
    public String getEnlace() {
        return "Enlace: " + enlace;
    }
    /**
     * Devuelve una representación en texto de la reunión virtual,
     * incluyendo la información del enlace y los detalles heredados.
     *
     * @return Cadena con la información completa de la reunión virtual.
     */
    @Override
    public String toString() {
        return "ReunionVirtual{" +
                "enlace='" + enlace + '\'' +
                "} " + super.toString();
    }
}
