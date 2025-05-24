package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream; /**Se usa para capturar la salida de System.out*/
import java.io.PrintStream; /**Se usa para redirigir la salida del sistema*/
import java.time.Duration;
import java.time.Instant;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Clase de prueba para verificar el correcto funcionameinto del metodo invitar de la clase Empleado
 */
class Empleado_CasoNormal {
    private ReunionPresencial reunionPresencial;
    private ReunionVirtual reunionVirtual;
    private Invitacion invitacion;
    private Empleado empleado;
    private Departamento marketing;
    private Empleado organizador;

    /**
     * {@link ByteArrayOutputStream} utilizado para capturar la salida estándar del sistema (System.out).
     * Esto permite verificar los mensajes impresos en la consola.
     */
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    /**
     * Guarda la referencia al {@link PrintStream} original de {@link System#out}
     * para poder restaurarla después de cada prueba.
     */
    private final PrintStream originalOut = System.out;

    /**
     * Configuración inicial para cada prueba.
     * Se inicializan los objetos de {@link Departamento} y {@link Empleado}.
     * También se redirige la salida estándar de la consola para poder ser capturada por {@code outContent}.
     */
    @BeforeEach
    void setUp() {
        /**Se redirige la salida antes que se imprima algo*/
        System.setOut(new PrintStream(outContent));

        marketing = new Departamento("Marketing");
        organizador = new Empleado("000", "Saavedra", "Tomas", "tomas.saavedra@example.com", marketing);
        empleado = new Empleado("001", "Gómez", "Ana", "ana.gomez@example.com", marketing);
    }

    /**
     * Método que se ejecuta después de cada prueba.
     * Restaura la salida estándar del sistema a su estado original (la consola).
     * Esto es para evitar que las pruebas interfieran con la salida de otras pruebas.
     */
    @AfterEach
    void restoreStreams() {
        System.setOut(originalOut);
    }

    /**
     * Prueba la funcionalidad de invitar a una {@link ReunionPresencial} a un empleado particular.
     * Para ello se verifica que la salida impresa en la consola por el método {@code invitar} del Empleado
     * coincida con un String esperado.
     */
    @Test
    void invitar_ReunionPresencial() {
        reunionPresencial = new ReunionPresencial(new Date(), Instant.now(), Duration.ofMinutes(60), organizador, TipoReunion.MARKETING, "Sala de Juntas 1");
        invitacion = new Invitacion(reunionPresencial.getHoraPrevista(), empleado);
        empleado.invitar(invitacion);

        /**Construccion del String esperado que debería imprimirse en la consola.*/
        StringBuilder expectedOutputBuilder = new StringBuilder();
        String horaReunion = invitacion.getHora().toString();
        expectedOutputBuilder.append("Invitacion para: Ana Gómez a la reunion de las ").append(horaReunion).append("\r\n");

        /**Normaliza la salida real capturada reemplazando CRLF (\r\n) por LF (\n).*/
        String expectedOutput = expectedOutputBuilder.toString();
        String actualOutputNormalized = outContent.toString().replace("\r\n", "\n");

        assertEquals(expectedOutput, outContent.toString());
    }

    /**
     * Prueba la funcionalidad de invitar a una {@link ReunionVirtual} a un empleado particular.
     * Para ello se verifica que la salida impresa en la consola por el método {@code invitar} del Empleado
     * coincida con un String esperado.
     */
    @Test
    void invitar_Virtual() {
        reunionVirtual = new ReunionVirtual(new Date(), Instant.now(), Duration.ofMinutes(60), organizador, TipoReunion.MARKETING, "Sala de Juntas 1");
        invitacion = new Invitacion(reunionVirtual.getHoraPrevista(), empleado);
        empleado.invitar(invitacion);

        /**Construccion del String esperado que debería imprimirse en la consola.*/
        StringBuilder expectedOutputBuilder = new StringBuilder();
        String horaReunion = invitacion.getHora().toString();
        expectedOutputBuilder.append("Invitacion para: Ana Gómez a la reunion de las ").append(horaReunion).append("\r\n");

        /**Normaliza la salida real capturada reemplazando CRLF (\r\n) por LF (\n).*/
        String expectedOutput = expectedOutputBuilder.toString();
        String actualOutputNormalized = outContent.toString().replace("\r\n", "\n");

        assertEquals(expectedOutput, outContent.toString());
    }
}