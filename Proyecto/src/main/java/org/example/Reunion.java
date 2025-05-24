package org.example;

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
    protected List<Nota> notas = new ArrayList<>();
    protected List<Invitacion> invitaciones = new ArrayList<>();
    protected List<Asistencia> asistencias = new ArrayList<>();
    protected List<Ausencia> ausencias = new ArrayList<>();

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

    public void agregarInvitacion(Invitacion invitacion) throws NullPointerException {
        if(invitacion==null){throw new NullPointerException();}
        if(invitacion.getInvitado() instanceof Departamento){
            ((Departamento) invitacion.getInvitado()).invitar(invitacion);
            for (Empleado e : ((Departamento) invitacion.getInvitado()).getEmpleados()){
                Invitacion a = new Invitacion(horaPrevista, e);
                invitaciones.add(a);
            }
        }
        if(invitacion.getInvitado() instanceof Empleado){
            ((Empleado) invitacion.getInvitado()).invitar(invitacion);
            invitaciones.add(invitacion);
        }
        if(invitacion.getInvitado() instanceof InvitadoExterno){
            ((InvitadoExterno) invitacion.getInvitado()).invitar(invitacion);
            invitaciones.add(invitacion);
        }
    }

    public void registrarAsistencia(Asistencia asistencia) throws NullPointerException {
        if(asistencia==null){throw new NullPointerException();}
        if(asistencia.getInvitado() instanceof Departamento){
            for (Empleado e : ((Departamento) asistencia.getInvitado()).getEmpleados()){
                Asistencia a = new Asistencia(e);
                asistencias.add(a);
            }
        }
        else{asistencias.add(asistencia);}
    }

    public void registrarAusencia(Ausencia ausencia) throws NullPointerException{
        if(ausencia==null){throw new NullPointerException();}
        if(ausencia.getInvitado() instanceof Departamento){
            for (Empleado e : ((Departamento) ausencia.getInvitado()).getEmpleados()){
                Ausencia a = new Ausencia(e);
                ausencias.add(a);
            }
        }
        else{ausencias.add(ausencia);}
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

    public int getNumeroAsistentes(){return asistencias.size();}

    public int getNumeroAusencia(){return ausencias.size();}

    public float getPorcentajeAsistencia(){return (asistencias.size()/invitaciones.size())*100;}

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