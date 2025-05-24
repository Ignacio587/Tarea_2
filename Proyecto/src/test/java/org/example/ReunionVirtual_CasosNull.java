package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase de para probar la clase {@code ReunionVirtual}, en los casos en los
 * que los metodos {@code agregarInvitacion}, {@code registrarAsistencia} Y {@code registrarAusencia},
 * reciben argumentos tipo null
 */
class ReunionVirtual_CasosNull {
    private ReunionVirtual reunionVirtual;
    private Departamento marketing;
    private Empleado organizador;

    /**
     * Método de configuración que se ejecuta antes de cada prueba.
     * */
    @BeforeEach
    void setUp() {
        marketing = new Departamento("Marketing");
        organizador = new Empleado("000", "Saavedra", "Tomas", "tomas.saavedra@example.com", marketing);
        reunionVirtual = new ReunionVirtual(new Date(), Instant.now(), Duration.ofMinutes(60), organizador, TipoReunion.MARKETING, "https://teams.microsoft.com/l/meetup-join/19%3ameeting");
    }

    /**
     * Prueba el método {@code agregarInvitacion} de {@link ReunionVirtual}.
     * Verifica que se lance una {@link NullPointerException} cuando se intenta agregar
     * una invitación con un objeto {@code null}.
     */
    @Test
    void agregarInvitacion_ReunionVirtual() {
        Invitacion invitacion=null;
        assertThrows(NullPointerException.class, () -> {
            reunionVirtual.agregarInvitacion(invitacion);});
    }

    /**
     * Prueba el método {@code registrarAsistencia} de {@link ReunionVirtual}.
     * Verifica que se lance una {@link NullPointerException} cuando se intenta registrar
     * una asistencia con un objeto {@code null}.
     */
    @Test
    void registrarAsistencia_ReunionVirtual() {
        Asistencia asistencia=null;
        assertThrows(NullPointerException.class, () -> {
            reunionVirtual.registrarAsistencia(asistencia);});
    }

    /**
     * Prueba el método {@code registrarAusencia} de {@link ReunionVirtual}.
     * Verifica que se lance una {@link NullPointerException} cuando se intenta registrar
     * una ausencia con un objeto {@code null}.
     */
    @Test
    void registrarAusencia_ReunionVirtual() {
        Ausencia ausencia=null;
        assertThrows(NullPointerException.class, () -> {
            reunionVirtual.registrarAusencia(ausencia);});
    }
}