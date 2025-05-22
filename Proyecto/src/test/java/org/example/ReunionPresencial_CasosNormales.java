package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.Instant;
import java.time.Duration;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

    /**Casos Normales*/
    @Test
    void registrarAsistenciaDepartamento_ReunionPresencial() {
        Asistencia departamento = new Asistencia(marketing);
        reunionPresencial.registrarAsistencia(departamento);
        for(int i=0; i<10; i++) {
            assertEquals(reunionPresencial.asistencias.get(i).getInvitado().toString(),marketing.getEmpleados().get(i).toString());
        }
    }

    @Test
    void registrarAsistenciaEmpleadoUnico_ReunionPresencial() {
        Asistencia empleado = new Asistencia(empleado1);
        reunionPresencial.registrarAsistencia(empleado);
        assertEquals(reunionPresencial.asistencias.get(0).getInvitado().toString(),empleado1.toString());
    }

    @Test
    void registrarAsistenciaInvitadoExterno_ReunionPresencial() {
        Asistencia invitadoExterno = new Asistencia(invitado);
        reunionPresencial.registrarAsistencia(invitadoExterno);
        assertEquals(reunionPresencial.asistencias.get(0).getInvitado().toString(),invitado.toString());
    }

    @Test
    void agregarNota_ReunionPresencial(){
        Nota N = new Nota("Esta es una nota de prueba");
        reunionPresencial.agregarNota(N);
        assertEquals(reunionPresencial.getNotas().get(0).getContenido(),N.getContenido());
    }

    @Test
    void iniciar_ReunionPresencial(){
        reunionPresencial.iniciar();
        assertEquals(reunionPresencial.getHoraInicio(), Instant.now());
    }

    @Test
    void finalizar_ReunionPresencial(){
        reunionPresencial.iniciar();
        reunionPresencial.finalizar();
        assertEquals(reunionPresencial.getHoraFin(), Instant.now());
    }

    @Test
    void calcularTiempoReal_ReunionPresencial(){
        reunionPresencial.iniciar();
        reunionPresencial.finalizar();
        assertEquals(reunionPresencial.calcularTiempoReal(), 0.0);
    }
}