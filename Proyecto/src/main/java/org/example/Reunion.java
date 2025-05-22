package org.example;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;

import java.time.*;
import java.util.*;
import java.util.Date;
import java.util.List;

/**
 *
 */
abstract class Reunion {

    private  Date fecha;
    private  Instant horaPrevista;
    private  Duration duracionPrevista;
    private Instant horaInicio;
    private Instant horaFin;
    private  TipoReunion tipo;
    private  Empleado organizador;
    protected List<Invitacion> invitaciones = new ArrayList<>();
    protected List<Nota> notas = new ArrayList<>();
    protected List<Asistencia> asistencias = new ArrayList<>();

    String nombreArchivo = "Notas_de_reunion.txt";

    /**
     *
     * @param fecha
     * @param horaPrevista
     * @param duracionPrevista
     * @param organizador
     * @param tipo
     */
    public Reunion (Date fecha, Instant horaPrevista, Duration duracionPrevista, Empleado organizador, TipoReunion tipo){
        this.fecha= fecha;
        this.horaPrevista = horaPrevista;
        this.duracionPrevista = duracionPrevista;
        this.organizador = organizador;
        this.tipo = tipo;
    }

    /**
     *
     * @param nota
     */
    public void agregarNota(Nota nota) {
        notas.add(nota);
    }

    public void agregarInvitacion(Invitacion invitacion) {
        invitaciones.add(invitacion);
    }

    /**
     *Aquí hay un problema me dijo el francisco, sobre que registra la asistencia de tambien de los departamentos
     * @param asistencia
     */
    public void registrarAsistencia(Asistencia asistencia) {
        if (asistencia!=Empleado){
            System.out.println(("hoal"));
        }
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

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Instant getHoraPrevista() { return horaPrevista; }

    public void setHoraPrevista(Instant horaPrevista) {
        this.horaPrevista = horaPrevista;
    }

    public Duration getDuracionPrevista() { return duracionPrevista; }
    public void setDuracionPrevista(){
        this.duracionPrevista = duracionPrevista;
    }

    public Instant getHoraInicio() { return horaInicio; }

    public void setHoraInicio(Instant horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Instant getHoraFin() { return horaFin; }

    public void setHoraFin(Instant horaFin) {
        this.horaFin = horaFin;
    }

    public Empleado getOrganizador() { return organizador; }

    public void setOrganizador(Empleado organizador) {
        this.organizador = organizador;
    }

    public TipoReunion getTipoReunion() { return tipo; }

    public void setTipoReunion(TipoReunion tipo){
        this.tipo=tipo;
    }

    public List<Asistencia> getAsistencias() { return asistencias; }

    public List<Nota> getNotas() { return notas; }

    public void setNotas(List<Nota> notas) {
        this.notas = notas;
    }

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