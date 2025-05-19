package org.example;

import java.time.*;
import java.util.Date;

public class ReunionVirtual extends Reunion {
    private String enlace;

    public ReunionVirtual(Date fecha, Instant horaPrevista, Duration duracionPrevista, Empleado organizador, TipoReunion tipo, String enlace) {
        super(fecha, horaPrevista, duracionPrevista, organizador, tipo);
        this.enlace = enlace;
    }

    public String getEnlace() {
        return "Enlace: " + enlace;
    }

    @Override
    public String toString() {
        return "ReunionVirtual{" +
                "enlace='" + enlace + '\'' +
                "} " + super.toString();
    }
}
