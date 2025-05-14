package org.example;
import java.util.ArrayList;
import java.util.List;

class Departamento implements Invitable {
  private String nombre;
  //Crear una lista array para poder contar la cantidad de empleados, y util
  private List<Empleado> empleados;
  public Departamento(String nombre){
   this.nombre = nombre;
   this.empleados = new ArrayList<>();
  }
  public void agregarEmpleado(Empleado e){
   empleados.add(e);
  }
 public int obtenerCantidadEmpleados() {
  return empleados.size();
 }
 public void invitar(){
   for (Empleado e : empleados){
    e.invitar();
   }
 }
public List<Empleado> getEmpleados(){
   return empleados;
}
 }

