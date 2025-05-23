package org.example;

/**
 *clase para guardar las asistencia de los empleados, y ver si llegaron a tiempo
 *
 *@author ignacio578
 */
class Asistencia {
    private  Object invitado;

    public Asistencia(Object invitado){
        this.invitado = invitado;
    }

    public Object getInvitado(){
        return invitado;
    }
    public void setInvitado(Object invitado){
        this.invitado = invitado;
    }

    @Override
    public String toString(){
        return invitado.toString()+" llego a tiempo a la reunion";
    }
}
