package org.example;

/**
 *clase para guardar las asistencia de los empleados, y ver si llegaron a tiempo
 *
 *@author ignacio578
 */
class Asistencia {
    /**
     * Invitado a la reunión. Puede ser una instancia de {@link Empleado} o {@link Departamento}.
     */
    private  Object invitado;
    /**
     * Crea una nueva instancia de asistencia para el invitado especificado.
     *
     * @param invitado El invitado que asistió a la reunión.
     */

    public Asistencia(Object invitado){
        this.invitado = invitado;
    }

    /**
     *
     * @return invitado retorna invitado
     */
    public Object getInvitado() {
        return invitado;
    }

    /**
     * Establece o modifica el invitado de la asistencia.
     *
     * @param invitado El nuevo invitado a asignar.
     */


    public void setInvitado(Object invitado){
        this.invitado = invitado;
    }
    /**
     * Devuelve una representación en texto de la asistencia.
     * Indica que el invitado llegó a tiempo a la reunión.
     *
     * @return Cadena que representa al invitado y su asistencia puntual.
     */

    @Override
    public String toString(){
        return invitado.toString()+" llego a tiempo a la reunion";
    }
}
