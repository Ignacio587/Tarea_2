package org.example;
/**
 * Clase que representa a un invitado externo a la organización,
 * que puede ser invitado a una reunión.
 *
 * @author ignacio578
 */

public class InvitadoExterno implements Invitable {
    /** Apellidos del invitado externo. */
    private  String apellidos;
    /** Nombre del invitado externo. */

    private  String nombre;
    /** Correo electrónico del invitado externo. */
    private  String correo;
    /**
     * Constructor para crear un nuevo invitado externo.
     *
     * @param apellidos Apellidos del invitado.
     * @param nombre Nombre del invitado.
     * @param correo Correo electrónico del invitado.
     */
    public InvitadoExterno(String apellidos, String nombre, String correo) {
        this.apellidos = apellidos;
        this.nombre = nombre;
        this.correo = correo;
    }
    /**
     * Envía una invitación al invitado externo.
     *
     * @param invitacion La invitación a la reunión.
     */
    @Override
    public void invitar(Invitacion invitacion) {
        System.out.println("Invitacion para: "+ nombre+" "+apellidos+"a la reunion de las "+ invitacion.getHora());
    }

    /**
     * @return Los apellidos del invitado.
     */
    public String getApellidos() {return apellidos;}
    /**
     * Establece los apellidos del invitado.
     *
     * @param apellidos Nuevos apellidos.
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    /**
     * @return El nombre del invitado.
     */
    public String getNombre() {return nombre;}

    /**
     * Establece el nombre del invitado.
     *
     * @param nombre Nuevo nombre.
     */
    public  void setNombre(String nombre){
        this.nombre = nombre;
    }
    /**
     * @return El correo electrónico del invitado.
     */
    public String getCorreo() {return correo;}
    /**
     * Establece el correo electrónico del invitado.
     *
     * @param correo Nuevo correo electrónico.
     */
    public void setCorreo(String correo){
        this.correo = correo;
    }
    /**
     * Devuelve una representación textual del invitado externo.
     *
     * @return Información básica del invitado.
     */
    @Override
    public String toString() {
        return "Informacion del Invitado: "+" ID: "+" Nombre: "+nombre+" Apellidos: "+apellidos+" Correo: "+correo;
    }
}
