package org.example;

class Asistencia {
    private Object invitado;

    public Asistencia(Object invitado){
        this.invitado = invitado;
    }

    public Object getInvitado(){
        return invitado;
    }

    @Override
    public String toString(){
        return invitado.toString()+" llego a tiempo a la reunion";
    }
}
