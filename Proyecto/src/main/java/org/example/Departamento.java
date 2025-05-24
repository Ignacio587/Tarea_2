package org.example;

import java.util.ArrayList;
import java.util.List;
/**
 * Clase que representa un departamento, el cual puede ser invitado a reuniones.
 * Contiene una lista de empleados que forman parte del departamento.
 *
 * @author ignacio578
 */
class Departamento implements Invitable {
    /**
     * Nombre del departamento.
     */
  private  String nombre;
    /**
     * Lista de empleados que pertenecen al departamento.
     */
  private final List<Empleado> empleados;
    /**
     * Constructor que inicializa un nuevo departamento con un nombre dado.
     *
     * @param nombre Nombre del departamento.
     */

  public Departamento(String nombre){
   this.nombre = nombre;
   this.empleados = new ArrayList<>();
  }

    /**
     * Devuelve la lista de empleados del departamento.
     *
     * @return Lista de empleados que pertenecen al departamento.
     */
  public void invitar(Invitacion invitacion){
       for (Empleado e : empleados){
           e.invitar(invitacion);
       }
  }

    /**
     * Obtiene el nombre del departamento.
     *
     * @return El nombre del departamento.
     */

  public String getNombre(){
      return nombre;
  }

    /**
     * Establece el nombre del departamento.
     *
     * @param nombre El nuevo nombre del departamento.
     */
  public void setNombre( String nombre){
    this.nombre = nombre;
  }
    /**
     * Devuelve la lista de empleados del departamento.
     *
     * @return Lista de empleados que pertenecen al departamento.
     */
  public List<Empleado> getEmpleados(){
      return empleados;
  }
    /**
     * Agrega un empleado a la lista del departamento.
     *
     * @param e El empleado que se desea agregar.
     */
  public void agregarEmpleado(Empleado e){
   empleados.add(e);
  }

    /**
     * Devuelve la cantidad de empleados que tiene el departamento.
     *
     * @return Número de empleados en el departamento.
     */
  public int obtenerCantidadDeEmpleados(){
      return empleados.size();
    }
    /**
     * Devuelve una representación textual del departamento.
     *
     * @return Una cadena con el nombre del departamento.
     */
  @Override
  public String toString(){
      return "Departamento de "+getNombre();
  }
}

