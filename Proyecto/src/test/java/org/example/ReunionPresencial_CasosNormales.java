package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.Instant;
import java.time.Duration;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Clase de pruebas unitarias para verificar el comportamiento de {@link ReunionPresencial}
 * en casos normales.
 */
class ReunionPresencial_CasosNormales {
    private ReunionPresencial reunionPresencial;
    private Departamento marketing;
    private Empleado organizador;
    private Empleado empleado1;
    private Empleado empleado2;
    private Empleado empleado3;
    private Empleado empleado4;
    private Empleado empleado5;
    private Empleado empleado6;
    private Empleado empleado7;
    private Empleado empleado8;
    private Empleado empleado9;
    private Empleado empleado10;
    private InvitadoExterno invitado;

    /**
     * Configuración inicial para cada prueba.
     * Se inicializan los objetos de {@link Departamento}, {@link Empleado},
     * {@link ReunionPresencial} e {@link InvitadoExterno}.
     * Se crea un departamento de Marketing y 10 empleados asociados a él,
     * además de un organizador para la reunión y un invitado externo.
     */
    @BeforeEach
    void setUp() {
        marketing = new Departamento("Marketing");
        organizador = new Empleado("000", "Saavedra", "Tomas", "tomas.saavedra@example.com", marketing);
        reunionPresencial = new ReunionPresencial(new Date(), Instant.now(), Duration.ofMinutes(60), organizador, TipoReunion.MARKETING, "Sala de Juntas 1");
        empleado1 = new Empleado("001", "Gómez", "Ana", "ana.gomez@example.com", marketing);
        empleado2 = new Empleado("002", "Pérez", "Juan", "juan.perez@example.com", marketing);
        empleado3 = new Empleado("003", "Rodríguez", "Sofía", "sofia.rodriguez@example.com", marketing);
        empleado4 = new Empleado("004", "Martínez", "Pedro", "pedro.martinez@example.com", marketing);
        empleado5 = new Empleado("005", "Díaz", "Laura", "laura.diaz@example.com", marketing);
        empleado6 = new Empleado("006", "Fernández", "Carlos", "carlos.fernandez@example.com", marketing);
        empleado7 = new Empleado("007", "Ruiz", "Elena", "elena.ruiz@example.com", marketing);
        empleado8 = new Empleado("008", "Torres", "Miguel", "miguel.torres@example.com", marketing);
        empleado9 = new Empleado("009", "Vargas", "Isabel", "isabel.vargas@example.com", marketing);
        empleado10 = new Empleado("010", "Sánchez", "David", "david.sanchez@example.com", marketing);
        marketing.agregarEmpleado(empleado1);
        marketing.agregarEmpleado(empleado2);
        marketing.agregarEmpleado(empleado3);
        marketing.agregarEmpleado(empleado4);
        marketing.agregarEmpleado(empleado5);
        marketing.agregarEmpleado(empleado6);
        marketing.agregarEmpleado(empleado7);
        marketing.agregarEmpleado(empleado8);
        marketing.agregarEmpleado(empleado9);
        marketing.agregarEmpleado(empleado10);
        invitado = new InvitadoExterno("Diosdado","Damaso", "ddiosdado@example.com");
    }

    /**
     * Verifica que los empleados de un departamento invitado a una reunión presencial,
     * se encuentren en el registro de invitaciones
     * Para ello se verifica que el metodo toString de cada uno de los invitados coincida en retorno con el de los
     * integrantes del departamento invitado.
     */
    @Test
    void agregarInvitacionDepartamento_ReunionPresencial(){
        Invitacion departamento = new Invitacion(reunionPresencial.getHoraPrevista(), marketing);
        reunionPresencial.agregarInvitacion(departamento);
        for(int i=0; i<marketing.getEmpleados().size(); i++) {
            assertEquals(reunionPresencial.invitaciones.get(i).getInvitado().toString(),marketing.getEmpleados().get(i).toString());
        }
    }

    /**
     * Verifica que un empleado particular invitado a una reunion presencial se encuentre en el registro de invitaciones.
     * Para ello se verifica que el metodo toString del unico individo del registro de invitaciones
     * coincida en retorno con el del empleado particular invitado.
     */
    @Test
    void agregarInvitacionEmpleadoUnico_ReunionPresencial() {
        Invitacion empleado = new Invitacion(reunionPresencial.getHoraPrevista(), empleado1);
        reunionPresencial.agregarInvitacion(empleado);
        assertEquals(reunionPresencial.invitaciones.get(0).getInvitado().toString(),empleado1.toString());
    }

    /**
     * Verifica que un externo invitado a una reunion presencial se encuentre en el registro de invitaciones.
     * Para ello se verifica que el metodo toString del unico individo del registro de invitaciones
     * coincida en retorno con el del externo invitado.
     */
    @Test
    void agregarInvitacionInvitadoExterno_ReunionPresencial() {
        Invitacion invitadoExterno = new Invitacion(reunionPresencial.getHoraPrevista(), invitado);
        reunionPresencial.agregarInvitacion(invitadoExterno);
        assertEquals(reunionPresencial.invitaciones.get(0).getInvitado().toString(),invitado.toString());
    }

    /**
     * Verifica el registro de asistencia de un departamento completo en una reunión presencial,
     * sin retraso.
     * Para ello se verifica que el metodo toString de cada uno de los asistentes coincida en retorno con el de los
     * integrantes del departamento invitado.
     */
    @Test
    void registrarAsistenciaDepartamento1_ReunionPresencial() {
        Asistencia departamento = new Asistencia(marketing);
        reunionPresencial.registrarAsistencia(departamento);
        for(int i=0; i<marketing.getEmpleados().size(); i++) {
            assertEquals(reunionPresencial.asistencias.get(i).getInvitado().toString(),marketing.getEmpleados().get(i).toString());
        }
    }

    /**
     * Verifica el registro de asistencia de un departamento completo en una reunión presencial,
     * con un retraso de 15 min.
     * Para ello se verifica que el metodo toString de cada uno de los asistentes coincida en retorno con el de los
     * integrantes del departamento invitado.
     */
    @Test
    void registrarAsistenciaDepartamento2_ReunionPresencial() {
        Duration tiempoDeRetraso = Duration.ofMinutes(15);
        Instant horaPrevistaConRetraso = reunionPresencial.getHoraPrevista().plus(tiempoDeRetraso);
        Retraso departamento = new Retraso(marketing, horaPrevistaConRetraso);
        reunionPresencial.registrarAsistencia(departamento);
        for(int i=0; i<marketing.getEmpleados().size(); i++) {
            assertEquals(reunionPresencial.asistencias.get(i).getInvitado().toString(),marketing.getEmpleados().get(i).toString());
        }
    }

    /**
     * Verifica el registro de ausencia de un departamento completo en una reunión presencial.
     * Para ello se verifica que el metodo toString de cada uno de los ausentes coincida en retorno con el de los
     * integrantes del departamento invitado.
     */
    @Test
    void registrarAusenciaDepartamento_ReunionPresencial() {
        Ausencia departamento = new Ausencia(marketing);
        reunionPresencial.registrarAusencia(departamento);
        for(int i=0; i<marketing.getEmpleados().size(); i++) {
            assertEquals(reunionPresencial.ausencias.get(i).getInvitado().toString(),marketing.getEmpleados().get(i).toString());
        }
    }

    /**
     * Verifica el registro de asistencia de un empleado particular en una reunión presencial,
     * sin retraso.
     * Para ello se verifica que el metodo toString del unico asistente coincida en retorno con el del empleado invitado.
     */
    @Test
    void registrarAsistenciaEmpleadoUnico1_ReunionPresencial() {
        Asistencia empleado = new Asistencia(empleado1);
        reunionPresencial.registrarAsistencia(empleado);
        assertEquals(reunionPresencial.asistencias.get(0).getInvitado().toString(),empleado1.toString());
    }

    /**
     * Verifica el registro de asistencia de un empleado particular en una reunión presencial,
     * con retraso.
     * Para ello se verifica que el metodo toString del unico asistente coincida en retorno con el del empleado invitado.
     */
    @Test
    void registrarAsistenciaEmpleadoUnico2_ReunionPresencial() {
        Duration tiempoDeRetraso = Duration.ofMinutes(15);
        Instant horaPrevistaConRetraso = reunionPresencial.getHoraPrevista().plus(tiempoDeRetraso);
        Retraso empleado = new Retraso(empleado1,horaPrevistaConRetraso);
        reunionPresencial.registrarAsistencia(empleado);
        assertEquals(reunionPresencial.asistencias.get(0).getInvitado().toString(),empleado1.toString());
    }

    /**
     * Verifica el registro de la ausencia de un empleado invitado particular en una reunión presencial.
     * Para ello se verifica que el metodo toString del unico ausente coincida en retorno con el del empleado invitado.
     */
    @Test
    void registrarAusenciaEmpleadoUnico_ReunionPresencial() {
        Ausencia empleado = new Ausencia(empleado1);
        reunionPresencial.registrarAusencia(empleado);
        assertEquals(reunionPresencial.ausencias.get(0).getInvitado().toString(),empleado1.toString());
    }

    /**
     * Verifica el registro de asistencia de un invitado externo en una reunión presencial,
     * sin retraso.
     * Para ello se verifica que el metodo toString del unico asistente coincida en retorno con el del invitado externo.
     */
    @Test
    void registrarAsistenciaInvitadoExterno1_ReunionPresencial() {
        Asistencia invitadoExterno = new Asistencia(invitado);
        reunionPresencial.registrarAsistencia(invitadoExterno);
        assertEquals(reunionPresencial.asistencias.get(0).getInvitado().toString(),invitado.toString());
    }

    /**
     * Verifica el registro de asistencia de un invitado externo en una reunión presencial,
     * con retraso.
     * Para ello se verifica que el metodo toString del unico asistente coincida en retorno con el del invitado externo.
     */
    @Test
    void registrarAsistenciaInvitadoExterno2_ReunionPresencial() {
        Duration tiempoDeRetraso = Duration.ofMinutes(15);
        Instant horaPrevistaConRetraso = reunionPresencial.getHoraPrevista().plus(tiempoDeRetraso);
        Retraso invitadoExterno = new Retraso(invitado, horaPrevistaConRetraso);
        reunionPresencial.registrarAsistencia(invitadoExterno);
        assertEquals(reunionPresencial.asistencias.get(0).getInvitado().toString(),invitado.toString());
    }

    /**
     * Verifica el registro de la ausencia de un invitado externo en una reunión presencial.
     * Para ello se verifica que el metodo toString del unico ausente coincida en retorno con el del invitado externo.
     */
    @Test
    void registrarAusenciaInvitadoExterno_ReunionPresencial() {
        Ausencia invitadoExterno = new Ausencia(invitado);
        reunionPresencial.registrarAusencia(invitadoExterno);
        assertEquals(reunionPresencial.ausencias.get(0).getInvitado().toString(),invitado.toString());
    }

    /**
     * Verifica la capacidad de agregar una nota correctamente a una reunión presencial.
     * Para ello se verifica que el metodo toString del la nota en la lista de notas
     * coincida en retorno con el de la nota creada.
     */
    @Test
    void agregarNota_ReunionPresencial(){
        Nota N = new Nota("Esta es una nota de prueba");
        reunionPresencial.agregarNota(N);
        assertEquals(reunionPresencial.getNotas().get(0).getContenido(),N.getContenido());
    }

    /**
     * Verifica el inicio de una reunión presencial.
     * Se espera que la hora de inicio de la reunión sea establecida a la hora actual.
     */
    @Test
    void iniciar_ReunionPresencial(){
        reunionPresencial.iniciar();
        assertEquals(reunionPresencial.getHoraInicio(), Instant.now());
    }

    /**
     * Verifica la finalización de una reunión presencial.
     * Se espera que la hora de inicio de la reunión sea establecida a la hora actual.
     */
    @Test
    void finalizar_ReunionPresencial(){
        reunionPresencial.iniciar();
        reunionPresencial.finalizar();
        assertEquals(reunionPresencial.getHoraFin(), Instant.now());
    }

    /**
     * Verifica el cálculo del tiempo real de una reunión presencial.
     * En este caso, al iniciar y finalizar la reunión consecutivamente en el test,
     * el tiempo real calculado debería ser aproximadamente cero.
     */
    @Test
    void calcularTiempoReal_ReunionPresencial(){
        reunionPresencial.iniciar();
        reunionPresencial.finalizar();
        assertEquals(reunionPresencial.calcularTiempoReal(), 0.0);
    }
}