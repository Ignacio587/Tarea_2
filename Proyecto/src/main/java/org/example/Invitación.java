package org.example;
import java.time.Instant;
 class Invitacion {
    private Instant hora;

    public Invitacion(Instant hora) {
        this.hora = hora;
    }

    public Instant getHora() {
        return hora;
    }
}
