package org.example;
/**
 * Clase base para todas las excepciones personalizadas de la aplicación.
 * Permite la creación de excepciones con un mensaje descriptivo.
 */

public class Exepciones extends Exception {
    /**
     * Construye una nueva instancia de {@code Exepciones} con el mensaje especificado.
     * @param message El mensaje detallado de la excepción.
     */
    public Exepciones(String message) {super(message);}
}

class NotaNullExepcion extends Exepciones{
    NotaNullExepcion(String message){super(message);}
}

class DepartamentoVacioExepcion extends Exepciones{
    DepartamentoVacioExepcion(String message){super(message);}
}

class InvitadoRepetidoExepcion extends Exepciones{
    InvitadoRepetidoExepcion(String message){super(message);}
}

class ReunionRepetidaExepcion extends Exepciones{
    ReunionRepetidaExepcion(String message){super(message);}
}

class ReunionIncompatibleExepcion extends Exepciones{
    ReunionIncompatibleExepcion(String message){super(message);}
}

class ReunionNullExepcion extends Exepciones{
    ReunionNullExepcion(String message){super(message);}
}

class ErrorHoraExepcion extends Exepciones{
    ErrorHoraExepcion(String message){super(message);}
}





