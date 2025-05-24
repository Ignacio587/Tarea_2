package org.example;
/**
 * Clase que representa a un empleado de una organización.
 * Los empleados pueden ser invitados a reuniones.
 *
 * @author ignacio578
 */
class Empleado implements Invitable {
 /**
  * Identificador único del empleado.
  */
 private  String id;
 /**
  * Apellidos del empleado.
  */
 private  String apellidos;
 /**
  * Nombre del empleado.
  */
 private  String nombre;
 /**
  * Correo electrónico del empleado.
  */
 private  String correo;
 /**
  * Departamento al que pertenece el empleado.
  */
 private  Departamento departamento;
 /**
  * Constructor que inicializa un nuevo empleado con los datos proporcionados.
  *
  * @param id Identificador del empleado.
  * @param apellidos Apellidos del empleado.
  * @param nombre Nombre del empleado.
  * @param correo Correo electrónico del empleado.
  * @param departamento Departamento al que pertenece el empleado.
  */
 public Empleado(String id, String apellidos, String nombre, String correo, Departamento departamento) {
  this.id = id;
  this.apellidos = apellidos;
  this.nombre = nombre;
  this.correo = correo;
  this.departamento = departamento;

 }
 /**
  * Invita al empleado a una reunión.
  *
  * @param invitacion Invitación que se desea enviar.
  */
 @Override
 public void invitar(Invitacion invitacion) {
  System.out.println("Invitacion para: "+ nombre+" "+apellidos+"a la reunion de las "+ invitacion.getHora());

 }
 /**
  * Obtiene el ID del empleado.
  *
  * @return Identificador del empleado.
  */
 public String getId() {return id;}
 /**
  * Apellidos del empleado.
  */
 public String getApellidos() {return apellidos;}
 /**
  * Nombre del empleado.
  */
 public String getNombre() {return nombre;}
 /**
  * Obtiene el correo electrónico del empleado.
  *
  * @return Correo electrónico del empleado.
  */
 public String getCorreo() {return correo;}
 /**
  * Establece el nombre del empleado.
  *
  * @param nombre Nuevo nombre del empleado.
  */
 public void setnombre(String nombre){
  this.nombre = nombre;
 }
 /**
  * Establece los apellidos del empleado.
  *
  * @param apellidos Nuevos apellidos del empleado.
  */
 public void setApellidos(String apellidos) {
  this.apellidos = apellidos;
 }
 /**
  * Establece el nombre del empleado. (método duplicado: considerar eliminar el anterior)
  *
  * @param nombre Nuevo nombre del empleado.
  */
 public void setNombre(String nombre) {
  this.nombre = nombre;
 }
 /**
  * Establece el correo electrónico del empleado.
  *
  * @param correo Nuevo correo electrónico del empleado.
  */
 public void setCorreo(String correo) {
  this.correo = correo;
 }
 /**
  * Establece el departamento al que pertenece el empleado.
  *
  * @param departamento Nuevo departamento del empleado.
  */
 public void setDepartamento(Departamento departamento) {
  this.departamento = departamento;
 }
 /**
  * Devuelve una representación en texto de la información del empleado.
  *
  * @return Cadena con la información del empleado.
  */
 @Override
 public String toString() {
  return "Informacion del Empleado: " +
          " ID: " + id +
          " Nombre: " + nombre +
          " Apellidos: " + apellidos +
          " Correo: " + correo;
 }
}

