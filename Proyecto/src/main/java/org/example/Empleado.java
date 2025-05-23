package org.example;

class Empleado implements Invitable {
 private  String id;
 private  String apellidos;
 private  String nombre;
 private  String correo;
 private  Departamento departamento;

 public Empleado(String id, String apellidos, String nombre, String correo, Departamento departamento) {
  this.id = id;
  this.apellidos = apellidos;
  this.nombre = nombre;
  this.correo = correo;
  this.departamento = departamento;

 }

 @Override
 public void invitar(Invitacion invitacion) {
  System.out.println("Invitacion para: "+ nombre+" "+apellidos+"a la reunion de las "+ invitacion.getHora());

 }

 public String getId() {return id;}

 public String getApellidos() {return apellidos;}

 public String getNombre() {return nombre;}

 public String getCorreo() {return correo;}

 public void setnombre(String nombre){
  this.nombre = nombre;
 }
 public void setApellidos(String apellidos) {
  this.apellidos = apellidos;
 }

 public void setNombre(String nombre) {
  this.nombre = nombre;
 }

 public void setCorreo(String correo) {
  this.correo = correo;
 }
 public void setDepartamento(Departamento departamento) {
  this.departamento = departamento;
 }

 @Override
 public String toString() {
  return "Informacion del Empleado: " +
          " ID: " + id +
          " Nombre: " + nombre +
          " Apellidos: " + apellidos +
          " Correo: " + correo;
 }
}

