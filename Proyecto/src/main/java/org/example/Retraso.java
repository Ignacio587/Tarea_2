package org.example;
import java.time.Instant;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

class Retraso extends Asistencia {
    private final Instant hora;

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
