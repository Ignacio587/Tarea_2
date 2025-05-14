package org.example;
import java.time.*;
import java.util.*;
import java.time.LocalDate;
abstract class Reunion {
    //variables basicas para el proyecto
    private LocalDate fecha;
    private Instant horaPrevista;
    private Duration duracionPrevista;
    private Instant horaInicio;
    private Instant horaFin;
    private TipoReunion tipo;
    private Empleado organizador;
    protected List<Invitacion> invitaciones = new ArrayList<>();
    protected List<Nota> notas = new ArrayList<>();
    protected List<Asistencia> asistencias = new ArrayList<>();
    //utilizamos el array para calcular despues la asentencia de cada emplenado
    public Reunion (LocalDate fecha, Instant horaPrevista, Duration duracionPrevista, Empleado organizador, TipoReunion tipo){
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
        if (horaInicio == null || horaFin == null) return 0;
        return Duration.between(horaInicio, horaFin).toMinutes();
    }

    public void iniciar() {
        this.horaInicio = Instant.now();
    }

    public void finalizar() {
        this.horaFin = Instant.now();
    }
}
