package org.example;

public class InvitadoExterno implements Invitable {
    private String apellidos;
    private String nombre;
    private String correo;

    public InvitadoExterno(String apellidos, String nombre, String correo) {
        this.apellidos = apellidos;
        this.nombre = nombre;
        this.correo = correo;
    }

    @Override
    public void invitar(Invitacion invitacion) {
        System.out.println("Invitacion para: "+ nombre+" "+apellidos+"a la reunion de las "+String.valueOf(invitacion.getHora()));
    }

    public String getApellidos() {return apellidos;}

    public String getNombre() {return nombre;}

    public String getCorreo() {return correo;}

    @Override
    public String toString() {
        return "Informacion del Invitado: "+" ID: "+" Nombre: "+nombre+" Apellidos: "+apellidos+" Correo: "+correo;
    }
}
