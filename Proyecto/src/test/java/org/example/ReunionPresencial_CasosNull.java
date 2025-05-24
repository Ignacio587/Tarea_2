package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase de para probar la clase {@code ReunionPresencial}, en los casos en los
 * que los metodos {@code agregarInvitacion}, {@code registrarAsistencia} Y {@code registrarAusencia},
 * reciben argumentos tipo null
 */
class ReunionPresencial_CasosNull {
    private ReunionPresencial reunionPresencial;
    private Departamento marketing;
    private Empleado organizador;
    private Empleado empleado;
    private InvitadoExterno invitado;

    /**
     * Método de configuración que se ejecuta antes de cada prueba.
     * */
    @BeforeEach
    void setUp() {
        marketing = new Departamento("Marketing");
        organizador = new Empleado("000", "Saavedra", "Tomas", "tomas.saavedra@example.com", marketing);
        reunionPresencial = new ReunionPresencial(new Date(), Instant.now(), Duration.ofMinutes(60), organizador, TipoReunion.MARKETING, "Sala de Juntas 1");
        empleado = new Empleado("001", "Gómez", "Ana", "ana.gomez@example.com", marketing);
        invitado = new InvitadoExterno("Diosdado","Damaso", "ddiosdado@example.com");
    }

    /**
     * Prueba el método {@code agregarInvitacion} de {@link ReunionPresencial}.
     * Verifica que se lance una {@link NullPointerException} cuando se intenta agregar
     * una invitación con un objeto {@code null}.
     */
    @Test
    void agregarInvitacion_ReunionPresencial() {
        Invitacion invitacion=null;
        assertThrows(NullPointerException.class, () -> {
           reunionPresencial.agregarInvitacion(invitacion);});
    }

    /**
     * Prueba el método {@code registrarAsistencia} de {@link ReunionPresencial}.
     * Verifica que se lance una {@link NullPointerException} cuando se intenta registrar
     * una asistencia con un objeto {@code null}.
     */
    @Test
    void registrarAsistencia_ReunionPresencial() {
        Asistencia asistencia=null;
        assertThrows(NullPointerException.class, () -> {
            reunionPresencial.registrarAsistencia(asistencia);});
    }

    /**
     * Prueba el método {@code registrarAusencia} de {@link ReunionPresencial}.
     * Verifica que se lance una {@link NullPointerException} cuando se intenta registrar
     * una ausencia con un objeto {@code null}.
     */
    @Test
    void registrarAusencia_ReunionPresencial() {
        Ausencia ausencia=null;
        assertThrows(NullPointerException.class, () -> {
            reunionPresencial.registrarAusencia(ausencia);});
    }
}
