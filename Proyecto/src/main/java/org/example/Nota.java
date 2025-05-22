package org.example;
import static org.junit.jupiter.api.Assertions.*;
 class Nota {
    private final String contenido;

    public Nota(String contenido) {
        this.contenido = contenido;
    }
    public String getContenido() {
        return contenido;
    }

    @Override
    public String toString() {
        return "Nota{" + contenido + '\''+'}';
    }
 }