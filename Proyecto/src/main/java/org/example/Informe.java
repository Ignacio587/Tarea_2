package org.example;
import java.io.FileWriter;
import java.nio.file.Path;
import java.io.IOException;
/**
 * Clase que genera un informe de una {@link Reunion} y lo guarda en un archivo.
 * @Farentsen999
 */

public class Informe {
    /**
     * Clase que genera un informe de una {@link Reunion} y lo guarda en un archivo.
     */
    Reunion reunion;
    /**
     * Ruta del archivo donde se guardará el informe.
     */
    private Path rutaInforme;
    /**
     * Constructor de la clase Informe.
     *
     * @param reunion      Reunión de la que se generará el informe.
     * @param rutaInforme  Ruta del archivo donde se escribirá el informe.
     * @throws ReunionNullExepcion si la reunión es nula.
     */
    public Informe(Reunion reunion, Path rutaInforme)throws ReunionNullExepcion{
        if (reunion == null) {
            throw new ReunionNullExepcion("Reunion Nula");
        }
        this.reunion=reunion;
        this.rutaInforme=rutaInforme;
    }
    /**
     * Escribe el contenido de la reunión (usando su método {@code toString()})
     * en el archivo especificado por {@code rutaInforme}.
     *
     * @throws IOException si ocurre un error al escribir en el archivo.
     */
    public  void escribir() throws IOException {
        FileWriter escritor = new FileWriter(rutaInforme.toFile());
        escritor.write(reunion.toString());
        escritor.close();
    }
}
