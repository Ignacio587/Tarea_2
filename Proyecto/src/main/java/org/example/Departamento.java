package org.example;

import java.util.ArrayList;
import java.util.List;

class Departamento implements Invitable {
  private final String nombre;
  private final List<Empleado> empleados;


  public Departamento(String nombre){
   this.nombre = nombre;
   this.empleados = new ArrayList<>();
  }

  public void invitar(Invitacion invitacion){
       for (Empleado e : empleados){
           e.invitar(invitacion);
       }
  }

  public String getNombre(){
      return nombre;
  }

  public int obtenerCantidadEmpleados() {
      return empleados.size();
  }

  public List<Empleado> getEmpleados(){
      return empleados;
  }

  public void agregarEmpleado(Empleado e){
   empleados.add(e);
  }

  @Override
  public String toString(){
      return "Departamento de "+getNombre();
  }
}

