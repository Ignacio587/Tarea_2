package org.example;

/**
 * Clase base para todas las excepciones personalizadas de la aplicación.
 * Permite la creación de excepciones con un mensaje descriptivo.
 */
public class Exepciones extends Exception {
    public Exepciones(String message) {super(message);}
}

class ReunionNullExepcion extends Exepciones{
    ReunionNullExepcion(String message){super(message);}
}






