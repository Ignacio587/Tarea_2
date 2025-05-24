package org.example;
import java.time.Instant;

class Invitacion {
    private final Instant hora;
    private final Object invitado;

    public Invitacion(Instant hora, Object invitado) {
        this.hora = hora;
        this.invitado = invitado;
    }

    public Instant getHora() {
        return hora;
    }
    public Object getInvitado(){return invitado;}

    @Override
    public String toString() {
        return String.valueOf(getHora());
    }
}
