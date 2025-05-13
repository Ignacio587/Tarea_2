package org.example;

abstract class Asitencia {
    private Empleado empleado;
    public Asitencia(Empleado empleado){
        this.empleado = empleado;
    }
    public Empleado getEmpleado(){
        return empleado;
    }
}
