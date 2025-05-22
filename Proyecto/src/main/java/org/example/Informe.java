package org.example;
import java.io.FileWriter;
import java.nio.file.Path;
import java.io.IOException;

public class Informe {
    Reunion reunion;
    private Path rutaInforme;

    public Informe(Reunion reunion, Path rutaInforme)throws ReunionNullExepcion{
        if (reunion == null) {
            throw new ReunionNullExepcion("Reunion Nula");
        }
        this.reunion=reunion;
        this.rutaInforme=rutaInforme;
    }
    public  void escribir() throws IOException {
        FileWriter escritor = new FileWriter(rutaInforme.toFile());
        escritor.write(reunion.toString());
        escritor.close();
    }
}
