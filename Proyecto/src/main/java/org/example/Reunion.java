package org.example;

import java.time.*;
import java.util.*;
import java.util.Date;
/**
 * Clase abstracta que representa una reunión con fecha, hora prevista,
 * duración prevista, organizador, tipo de reunión e invitaciones.
 * Gestiona notas, asistencias, ausencias y retrasos de los invitados.
 */
abstract class Reunion {
    private  Date fecha;
    private  Instant horaPrevista;
    private  Duration duracionPrevista;
    private Instant horaInicio;
    private Instant horaFin;
    private  TipoReunion tipo;
    private  Empleado organizador;
    protected Invitacion invitacion;
    protected List<Nota> notas = new ArrayList<>();
    protected List<Asistencia> asistencias = new ArrayList<>();
    protected List<Asistencia> ausencias = new ArrayList<>();
    protected List<Retraso> retrasos = new ArrayList<>();

    String nombreArchivo = "Notas_de_reunion.txt";

    /**
     * Constructor de la reunión.
     *
     * @param fecha            Fecha de la reunión.
     * @param horaPrevista     Hora prevista de inicio.
     * @param duracionPrevista Duración estimada.
     * @param organizador      Empleado organizador de la reunión.
     * @param tipo             Tipo de la reunión.
     */
    public Reunion (Date fecha, Instant horaPrevista, Duration duracionPrevista, Empleado organizador, TipoReunion tipo){
        this.fecha= fecha;
        this.horaPrevista = horaPrevista;
        this.duracionPrevista = duracionPrevista;
        this.organizador = organizador;
        this.tipo = tipo;
        this.invitacion = new Invitacion(horaPrevista);
    }

    /**
     * Agrega una nota a la reunión.
     *
     * @param nota Nota a agregar.
     */
    public void agregarNota(Nota nota) {
        notas.add(nota);
    }

    /**
     * Registra una asistencia de un invitado.
     *
     * @param asistencia Objeto Asistencia cuyo invitado puede ser un Empleado o un Departamento.
     */

    public void registrarAsistencia(Asistencia asistencia) {
        if(asistencia.getInvitado() instanceof Departamento){
            for (Empleado e : ((Departamento) asistencia.getInvitado()).getEmpleados()){
                Asistencia a = new Asistencia(e);
                asistencias.add(a);
            }
        }
        else {asistencias.add(asistencia);}
    }
    /**
     * Registra un retraso de un invitado.
     * También se contabiliza como asistencia.
     *
     * @param retraso Objeto Retraso cuyo invitado puede ser un Empleado o un Departamento.
     */
    public void registrarRetrasos(Retraso retraso) {
        if (retraso.getInvitado() instanceof Departamento) {
            for (Empleado e : ((Departamento) retraso.getInvitado()).getEmpleados()) {
                Retraso r = new Retraso(e, retraso.getHora());
                retrasos.add(r);
                asistencias.add(r); // también se registra como asistencia
            }
        } else {
            retrasos.add(retraso);
            asistencias.add(retraso); // también se registra como asistencia
        }
    }
    /**
     * Registra la ausencia de un invitado en la reunión.
     * <p>
     * Si el invitado es un Departamento, marca como ausentes todos sus empleados
     * que no hayan asistido y que aún no estén marcados como ausentes.
     * Si el invitado es un único empleado, marca su ausencia si no ha asistido
     * y no está ya ausente.
     * </p>
     *
     * @param ausencia Objeto Asistencia que representa la ausencia a registrar.
     */
    public void registrarAusencia(Asistencia ausencia) {
        Set<Object> presentes = new HashSet<>(); //Utilizamos contenedores para utilizar sus propiedades para poder utilizar sus propiedes, y la necesidad de recorrer contantemente la lista
        for (Asistencia a : asistencias) {
            presentes.add(a.getInvitado());
        }

        Set<Object> yaAusentes = new HashSet<>();
        for (Asistencia a : ausencias) {
            yaAusentes.add(a.getInvitado());
        }

        Object invitado = ausencia.getInvitado();
        if (invitado instanceof Departamento) {
            Departamento dpto = (Departamento) invitado;
            for (Empleado e : dpto.getEmpleados()) {
                if (!presentes.contains(e) && !yaAusentes.contains(e)) {
                    ausencias.add(new Asistencia(e));
                }
            }
        } else {
            if (!presentes.contains(invitado) && !yaAusentes.contains(invitado)) {
                ausencias.add(ausencia);
            }
        }
    }

    public List<Asistencia> obtenerAsistencias(){
        return asistencias;
    }
    /**
     * Obtiene el total de asistentes registrados.
     *
     * @return Número de asistentes.
     */
    public int ObtenerTotalAsistencia(){
        return asistencias.size();
    }


    /**
     * Obtiene la lista de ausencias.
     *
     * @return Lista de Asistencia de ausentes.
     */
    public List<Asistencia> getAusencias() {
        return ausencias;
    }
    /**
     * Calcula el porcentaje de asistencia sobre el total de invitados.
     *
     * @return Porcentaje de asistencia (0-100).
     */
    public float obtenerPorcentajeAsistencia() {
        int total = asistencias.size() + ausencias.size();
        if (total == 0) return 0f;
        return (asistencias.size() * 100f) / total;
    }

    /**
     * Obtiene la lista de retrasos registrados.
     * @return Lista de Retraso.
     */
    public List<Retraso> obtenerRetrasoso(){
        return retrasos;
    }
    /**
     * Calcula la duración real de la reunión en minutos.
     *
     * @return Duración real en minutos.
     */
    public float calcularTiempoReal() {
        return Duration.between(horaInicio, horaFin).toMinutes();
    }

    /**
     * Marca el inicio de la reunión registrando la hora actual.
     */
    public void iniciar() {
        this.horaInicio = Instant.now();
    }

    /**
     * Marca el fin de la reunión registrando la hora actual.
     */
    public void finalizar() {
        this.horaFin = Instant.now();
    }
    /**
     * @return Fecha de la reunión.
     */
    public Date getFecha() { return fecha; }

    /**
     * @return Hora prevista de inicio.
     */
    public Instant getHoraPrevista() { return horaPrevista; }
    /**
     * @return Duración prevista de la reunión.
     */
    public Duration getDuracionPrevista() { return duracionPrevista; }
    /**
     * @return Hora real de inicio.
     */
    public Instant getHoraInicio() { return horaInicio; }
    /**
     * @return Hora real de fin.
     */
    public Instant getHoraFin() { return horaFin; }

    /**
     * @return Empleado organizador de la reunión.
     */
    public Empleado getOrganizador() { return organizador; }
    /**
     * @return Tipo de la reunión.
     */
    public TipoReunion getTipoReunion() { return tipo; }
    /**
     * @return Lista de notas de la reunión.
     */
    public List<Nota> getNotas() { return notas; }
    /**
     * Representación String de la reunión.
     *
     * @return Detalle con fecha, hora, organizador, tipo, asistentes, retrasos y notas.
     */
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
                ",retrasos=" + retrasos +
                ", notas=" + notas +
                '}';
    }

}