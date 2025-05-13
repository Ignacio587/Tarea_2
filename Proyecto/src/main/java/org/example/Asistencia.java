package org.example;

abstract class Asistencia {
    private Empleado empleado;
    public Asistencia(Empleado empleado){
        this.empleado = empleado;
    }
    public Empleado getEmpleado(){
        return empleado;
    }
}
