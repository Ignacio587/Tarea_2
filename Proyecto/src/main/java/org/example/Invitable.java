package org.example;
/**
 * permite invitar de manera más sencilla a cualquiera tipo de invitado
 *
 * Por ejemplo: empleados, departamentos o invitados externos.
 *
 * @author Farentsen999
 */
 interface Invitable {
    /**
     * Envía una invitación a la entidad.
     *
     * @param invitacion Detalles de la invitación, como la hora de la reunión.
     */
    void invitar(Invitacion invitacion);
}
