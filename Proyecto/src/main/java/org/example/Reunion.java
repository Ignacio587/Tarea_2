package org.example;
import java.io.FileWriter;
import java.io.IOException;

import java.time.*;
import java.util.*;
import java.util.Date;

abstract class Reunion {
    private final Date fecha;
    private final Instant horaPrevista;
    private final Duration duracionPrevista;
    private Instant horaInicio;
    private Instant horaFin;
    private final TipoReunion tipo;
    private final Empleado organizador;
    protected List<Invitacion> invitaciones = new ArrayList<>();
    protected List<Nota> notas = new ArrayList<>();
    protected List<Asistencia> asistencias = new ArrayList<>();

    String nombreArchivo = "Notas_de_reunion.txt";

    public Reunion (Date fecha, Instant horaPrevista, Duration duracionPrevista, Empleado organizador, TipoReunion tipo){
        this.fecha= fecha;
        this.horaPrevista = horaPrevista;
        this.duracionPrevista = duracionPrevista;
        this.organizador = organizador;
        this.tipo = tipo;
    }


    public void agregarNota(Nota nota) {
        notas.add(nota);
    }

    public void agregarInvitacion(Invitacion invitacion) {
        invitaciones.add(invitacion);
    }

    public void registrarAsistencia(Asistencia asistencia) {
        asistencias.add(asistencia);
    }

    public float calcularTiempoReal() {
        return Duration.between(horaInicio, horaFin).toMinutes();
    }

    public void iniciar() {
        this.horaInicio = Instant.now();
    }

    public void finalizar() {
        this.horaFin = Instant.now();
    }

    public Date getFecha() { return fecha; }

    public Instant getHoraPrevista() { return horaPrevista; }

    public Duration getDuracionPrevista() { return duracionPrevista; }

    public Instant getHoraInicio() { return horaInicio; }

    public Instant getHoraFin() { return horaFin; }

    public Empleado getOrganizador() { return organizador; }

    public TipoReunion getTipoReunion() { return tipo; }

    public List<Asistencia> getAsistencias() { return asistencias; }

    public List<Nota> getNotas() { return notas; }

    @Override
    public String toString() {
        return "Reunion{" +
                "fecha=" + fecha +
                ", horaPrevista=" + horaPrevista +
                ", duracionPrevista=" + duracionPrevista +
                ", horaInicio=" + horaInicio +
                ", horaFin=" + horaFin +
                ", organizador=" + organizador +
                ", tipoReunion=" + tipo +
                ", asistencias=" + asistencias +
                ", notas=" + notas +
                '}';
    }

}