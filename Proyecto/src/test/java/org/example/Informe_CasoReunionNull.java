package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir; /** Para JUnit 5 permite manejar archivos temporales de forma automatica*/

import java.nio.file.Path;


import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase de prueba para ejemplificar la generacion de informes para las reuniones cuando la reunion es nula
 */
class Informe_CasoReunionNull {
    private ReunionPresencial reunionPresencial;
    private ReunionVirtual reunionVirtual;
    private Informe informe;
    private Path rutaArchivo;

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
        rutaArchivo = tempDir.resolve("Informe de la Reunion.txt");
    }

    /**
     * Prueba para verificar que el metodo escribir lanza la exepcion {@link ReunionNullExepcion} cuando recibe como argumento una
     * {@link ReunionPresencial} null
     */
    @Test
    void escribir_ReunionPresencial() {
        reunionPresencial = null;
        assertThrows(ReunionNullExepcion.class, () -> {
            informe = new Informe(reunionPresencial, rutaArchivo);
        });
    }

    /**
     * Prueba para verificar que el metodo escribir lanza la exepcion {@link ReunionNullExepcion} cuando recibe como argumento una
     * {@link ReunionVirtual} null
     */
    @Test
    void escribir_ReunionVirtual() {
        reunionVirtual = null;
        assertThrows(ReunionNullExepcion.class, () -> {
            informe = new Informe(reunionVirtual, rutaArchivo);
        });
    }
}