package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.Instant;
import java.time.Duration;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ReunionVirtualTest {
    private ReunionVirtual reunionVirtual;
    private Empleado organizador;
    private Departamento departamento;

    @BeforeEach
    void setUp() {
        departamento = new Departamento("Marketing");
        organizador = new Empleado("001", "Saavedra", "Tomas", "tomas.saavedra@example.com", departamento);
        reunionVirtual = new ReunionVirtual(new Date(), Instant.now(), Duration.ofMinutes(60), organizador, TipoReunion.MARKETING, "https://zoom.us/meeting123");
    }

    @Test
    void testToString_ReunionVirtual() {
        String esperado = "ReunionVirtual{enlace='https://zoom.us/meeting123'} Reunion{fecha="+reunionVirtual.getFecha()+", horaPrevista="+reunionVirtual.getHoraPrevista()+", duracionPrevista=PT1H, horaInicio=null, horaFin=null, organizador=Informacion del Empleado:  ID: 001 Nombre: Tomas Apellidos: Saavedra Correo: tomas.saavedra@example.com, tipoReunion=MARKETING, asistencias=[], notas=[]}";
        assertEquals(esperado, reunionVirtual.toString());
    }

    @Test
    void iniciar_ReunionVirtual() {
        assertNull(reunionVirtual.getHoraInicio());
        reunionVirtual.iniciar();
        assertNotNull(reunionVirtual.getHoraInicio());
    }

    @Test
    void finalizar_ReunionVirtual() {
        reunionVirtual.iniciar();
        assertNull(reunionVirtual.getHoraFin());
        reunionVirtual.finalizar();
        assertNotNull(reunionVirtual.getHoraFin());
        assertTrue(reunionVirtual.calcularTiempoReal() >= 0);
    }

    @Test
    void calcularTiempoReal_ReunionVirtual(){
        reunionVirtual.iniciar();
        Instant inicio = Instant.now();
        reunionVirtual.finalizar();
        Instant fin = Instant.now();

        long tiempoReal = Duration.between(inicio, fin).toMinutes();
        assertEquals(tiempoReal, reunionVirtual.calcularTiempoReal(), 1.0, "Tiempo real debe ser calculado correctamente");
    }

    @Test
    void registrarAsistencia_ReunionVirtual() {
        Asistencia A = new Asistencia(organizador);
        reunionVirtual.registrarAsistencia(A);
        assertEquals("Informacion del Empleado:  ID: 001 Nombre: Tomas Apellidos: Saavedra Correo: tomas.saavedra@example.com llego a tiempo a la reunion", A.toString());
    }

    @Test
    void agregarInvitacion_ReunionVirtual() {
        Invitacion I = new Invitacion(Instant.now().plus(Duration.ofMinutes(5)));
        reunionVirtual.agregarInvitacion(I);
        assertTrue(reunionVirtual.invitaciones.contains(I), "La invitación debe estar en la lista.");
    }
    @Test
    void agregarNota_ReunionVirtual() {
        Nota nota1 = new Nota("Planificacion 2025");
        reunionVirtual.agregarNota(nota1);
        assertEquals(1, reunionVirtual.getNotas().size());
        assertTrue(reunionVirtual.getNotas().contains(nota1));
    }
}