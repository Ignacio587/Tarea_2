package org.example;
import java.time.Instant;

/**
 * Clase que representa una invitación a una reunión, incluyendo la hora en la que está prevista.
 *
 * @author ignacio578
 */
class Invitacion {
    /** Hora prevista de la reunión. */

    private Instant hora;
    /**
     * Crea una nueva invitación con la hora especificada.
     *
     * @param hora Hora prevista de inicio de la reunión.
     */

    public Invitacion(Instant hora) {
        this.hora = hora;
    }

    /**
     * Obtiene la hora prevista de la reunión.
     *
     * @return La hora de la invitación.
     */
    public Instant getHora() {
        return hora;
    }
    /**
     * Devuelve una representación textual de la hora de la invitación.
     *
     * @return La hora como cadena de texto.
     */
    @Override
    public String toString() {
        return String.valueOf(getHora());
    }
}
