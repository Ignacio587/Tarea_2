package org.example;
import static org.junit.jupiter.api.Assertions.*;
 class Nota {
    private  String contenido;

    public Nota(String contenido) {
        this.contenido = contenido;
    }
    public String getContenido() {
        return contenido;
    }

     public void setContenido(String contenido) {
         this.contenido = contenido;
     }

     @Override
    public String toString() {
        return "Nota{" + contenido + '\''+'}';
    }
 }