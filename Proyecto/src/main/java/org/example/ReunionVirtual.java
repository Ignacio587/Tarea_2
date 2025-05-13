package org.example;

import java.util.Date;
import java.time.Duration;
import java.time.Instant;
public class ReunionVirtual extends Reunion {
    private String enlace;
    public ReunionVirtual(Date fecha, Instant horaPrevista, Duration duracionPrevista, Empleado organizador, TipoReunion tipo, String enlace){
       super(fecha, horaPrevista,duracionPrevista,organizador,tipo);

    }
}
