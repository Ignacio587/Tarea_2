package org.example;

import java.util.ArrayList;
import java.util.List;

class Departamento implements Invitable {
  private  String nombre;
  private final List<Empleado> empleados;
  public int TotalDeInvitados=0;


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

  public void setNombre( String nombre){
    this.nombre = nombre;
  }

  public List<Empleado> getEmpleados(){
      return empleados;
  }

  public void agregarEmpleado(Empleado e){
   empleados.add(e);
  }
  public int ObtenerCantidadDeEmpleados(){
      return empleados.size();
    }

  @Override
  public String toString(){
      return "Departamento de "+getNombre();
  }
}

