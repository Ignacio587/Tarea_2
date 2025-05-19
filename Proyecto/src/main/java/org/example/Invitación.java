package org.example;
import java.time.Instant;

class Invitacion {
    private final Instant hora;

    public Invitacion(Instant hora) {
        this.hora = hora;
    }

    public Instant getHora() {
        return hora;
    }

    @Override
    public String toString() {
        return String.valueOf(getHora());
    }
}
