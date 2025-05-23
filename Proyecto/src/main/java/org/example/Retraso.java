package org.example;
import java.time.Instant;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
/**
 * Clase que representa un registro de asistencia con retraso a una reunión.
 * Extiende la clase {@link Asistencia}, agregando la hora exacta de llegada tarde.
 *
 * @author ignacio578
 */
class Retraso extends Asistencia {
    /** Hora exacta en que el invitado llegó a la reunión. */

    private  Instant hora;

    /**
     * Crea un nuevo objeto de tipo Retraso.
     *
     * @param invitado El invitado que llegó tarde.
     * @param hora Hora exacta de llegada.
     */
    public Retraso(Object invitado, Instant hora){
        super(invitado);
        this.hora = hora;
    }
    /**
     * Obtiene la hora de llegada con retraso del invitado.
     *
     * @return Hora de llegada.
     */
    public Instant getHora(){
        return hora;
    }
    /**
     * Establece un nuevo invitado que llegó con retraso.
     *
     * @param invitado Invitado a modificar.
     */
    @Override
    public void setInvitado(Object invitado) {
        super.setInvitado(invitado);
    }
    /**
     * Devuelve una representación textual del retraso.
     *
     * @return Cadena indicando quién llegó tarde y a qué hora.
     */
    @Override
    public String toString(){
        return super.getInvitado().toString()+" llego tarde a la reunion a las" + hora ;
    }
}
