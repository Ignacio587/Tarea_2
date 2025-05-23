package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir; /** Para JUnit 5 permite manejar archivos temporales de forma automatica*/

import java.time.Duration;
import java.time.Instant;
import java.util.Date;

import java.nio.file.Path;
import java.nio.file.Files;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase de prueba para ejemplificar la generacion de informes para las reuniones en un caso normal
 */
class Informe_CasoNormal {
    private ReunionPresencial reunionPresencial;
    private ReunionVirtual reunionVirtual;
    private Informe informe;
    private Departamento marketing;
    private Empleado organizador;
    private Empleado empleado;
    private Path rutaArchivo;
    private String contenidoEsperado;

    /**proporciona un directorio temporal y unico para cada test*/
    @TempDir
    Path tempDir;

    /**
     * Configuración inicial para cada prueba.
     * Se inicializan los objetos {@link Departamento}, {@link Empleado} y
     * se define la ruta del archivo temporal para el informe.
     */
    @BeforeEach
    void setUp() {
        marketing = new Departamento("Marketing");
        organizador = new Empleado("000", "Saavedra", "Tomas", "tomas.saavedra@example.com", marketing);
        empleado = new Empleado("001", "Gómez", "Ana", "ana.gomez@example.com", marketing);
        rutaArchivo = tempDir.resolve("Informe de la Reunion.txt");
    }

    /**
     * Prueba para verificar que un informe de una {@link ReunionPresencial} se escribe correctamente en un archivo.
     * Para este test se crea una reunión presencial, luego se registra una asistencia, se genera el informe
     * y finalmente se verifica que el archivo del informe existe y su contenido es el esperado.
     */
    @Test
    void escribir_ReunionPresencial() {
        reunionPresencial = new ReunionPresencial(new Date(), Instant.now(), Duration.ofMinutes(60), organizador, TipoReunion.MARKETING, "Sala de Juntas 1");
        Asistencia a = new Asistencia(empleado);
        reunionPresencial.registrarAsistencia(a);
        contenidoEsperado = reunionPresencial.toString();
        try {
            informe = new Informe(reunionPresencial, rutaArchivo);
        } catch (ReunionNullExepcion e) {
            throw new RuntimeException(e);
        }
        try {
            informe.escribir();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        assertTrue(Files.exists(rutaArchivo));
        String contenido = null;
        try {
            contenido = Files.readString(rutaArchivo);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        assertEquals(contenido, contenidoEsperado);
    }

    /**
     * Prueba para verificar que un informe de una {@link ReunionPresencial} se escribe correctamente en un archivo.
     * Para este test se crea una reunión presencial, luego se registra una asistencia, se genera el informe
     * y finalmente se verifica que el archivo del informe existe y su contenido es el esperado.
     */
    @Test
    void escribir_ReunionVirtual() {
        reunionVirtual = new ReunionVirtual(new Date(), Instant.now(), Duration.ofMinutes(60), organizador, TipoReunion.MARKETING, "https://teams.microsoft.com/l/meetup-join/19%3ameeting");
        Asistencia a = new Asistencia(empleado);
        reunionVirtual.registrarAsistencia(a);
        contenidoEsperado = reunionVirtual.toString();
        try {
            informe = new Informe(reunionVirtual, rutaArchivo);
        } catch (ReunionNullExepcion e) {
            throw new RuntimeException(e);
        }
        try {
            informe.escribir();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        assertTrue(Files.exists(rutaArchivo));
        String contenido = null;
        try {
            contenido = Files.readString(rutaArchivo);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        assertEquals(contenido, contenidoEsperado);
    }
}