package org.example;
import java.time.Instant;
class Retraso extends Asitencia {
    private Instant hora;
    public Retraso(Empleado empleado, Instant hora){
        super(empleado);
        this.hora = hora;
    }
    public Instant getHora(){
        return hora;
    }
}
