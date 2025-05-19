package org.example;
import java.time.Instant;

class Retraso extends Asistencia {
    private Instant hora;

    public Retraso(Object invitado, Instant hora){
        super(invitado);
        this.hora = hora;
    }

    public Instant getHora(){
        return hora;
    }

    @Override
    public String toString(){
        return super.getInvitado().toString()+" llego tarde a la reunion";
    }
}
