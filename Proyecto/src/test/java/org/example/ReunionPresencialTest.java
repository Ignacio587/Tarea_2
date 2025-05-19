package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.Instant;
import java.time.Duration;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ReunionPresencialTest {
    private ReunionPresencial reunionPresencial;
    private Empleado organizador;
    private Departamento departamento;

    @BeforeEach
    void setUp() {
        departamento = new Departamento("Marketing");
        organizador = new Empleado("001", "Saavedra", "Tomas", "tomas.saavedra@example.com", departamento);
        reunionPresencial = new ReunionPresencial(new Date(), Instant.now(), Duration.ofMinutes(60), organizador, TipoReunion.MARKETING, "Sala de Juntas 1");
        prueba a = new prueba(reunionPresencial);
        a.escribir();
    }

    @Test
    void testToString_ReunionPresencial() {
        String esperado = "ReunionPresencial{sala='Sala de Juntas 1'} " +
                "Reunion{fecha="+reunionPresencial.getFecha()+", horaPrevista="+reunionPresencial.getHoraPrevista()+", duracionPrevista=PT1H, horaInicio=null, horaFin=null, organizador=Informacion del Empleado:  ID: 001 Nombre: Tomas Apellidos: Saavedra Correo: tomas.saavedra@example.com, tipoReunion=MARKETING, asistencias=[], notas=[]}";
        assertEquals(esperado, reunionPresencial.toString());
    }

    @Test
    void iniciar_ReunionPresencial() {
        assertNull(reunionPresencial.getHoraInicio());
        reunionPresencial.iniciar();
        assertNotNull(reunionPresencial.getHoraInicio());
    }

    @Test
    void finalizar_ReunionPresencial() {
        reunionPresencial.iniciar();
        assertNull(reunionPresencial.getHoraFin());
        reunionPresencial.finalizar();
        assertNotNull(reunionPresencial.getHoraFin());
        assertTrue(reunionPresencial.calcularTiempoReal() >= 0);
    }

    @Test
    void calcularTiempoReal_ReunionPresencial(){
        reunionPresencial.iniciar();
        Instant inicio = Instant.now();
        reunionPresencial.finalizar();
        Instant fin = Instant.now();

        long tiempoReal = Duration.between(inicio, fin).toMinutes();
        assertEquals(tiempoReal, reunionPresencial.calcularTiempoReal(), 1.0, "Tiempo real debe ser calculado correctamente");
    }

    @Test
    void registrarAsistencia_ReunionPresencial() {
        Asistencia A = new Asistencia(organizador);
        reunionPresencial.registrarAsistencia(A);
        assertEquals("Informacion del Empleado:  ID: 001 Nombre: Tomas Apellidos: Saavedra Correo: tomas.saavedra@example.com llego a tiempo a la reunion", A.toString());
    }

    @Test
    void agregarInvitacion_ReunionPresencial() {
        Invitacion I = new Invitacion(Instant.now().plus(Duration.ofMinutes(5)));
        reunionPresencial.agregarInvitacion(I);
        assertTrue(reunionPresencial.invitaciones.contains(I), "La invitación debe estar en la lista.");
    }
    @Test
    void agregarNota_ReunionPresencial() {
        Nota nota1 = new Nota("Planificacion 2025");
        reunionPresencial.agregarNota(nota1);
        assertEquals(1, reunionPresencial.getNotas().size());
        assertTrue(reunionPresencial.getNotas().contains(nota1));
    }
}