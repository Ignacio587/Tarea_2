package org.example;

class Empleado implements Invitable {
 private final String id;
 private final String apellidos;
 private final String nombre;
 private final String correo;
 private final Departamento departamento;

 public Empleado(String id, String apellidos, String nombre, String correo, Departamento departamento) {
  this.id = id;
  this.apellidos = apellidos;
  this.nombre = nombre;
  this.correo = correo;
  this.departamento = departamento;
 }

 @Override
 public void invitar(Invitacion invitacion) {
  System.out.println("Invitacion para: "+ nombre+" "+apellidos+" a la reunion de las "+ invitacion.getHora());

 }

 public String getId() {return id;}

 public String getApellidos() {return apellidos;}

 public String getNombre() {return nombre;}

 public String getCorreo() {return correo;}

 @Override
 public String toString() {
  return "Informacion del Empleado: "+" ID: "+id+" Nombre: "+nombre+" Apellidos: "+apellidos+" Correo: "+correo;
 }
}
