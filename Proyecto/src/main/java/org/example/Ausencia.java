package org.example;

public class Ausencia {
    private final Object invitado;

    public Ausencia(Object invitado){
        this.invitado = invitado;
    }

    public Object getInvitado(){
        return invitado;
    }

    @Override
    public String toString(){
        return invitado.toString()+" no llego a la reunion";
    }
}
