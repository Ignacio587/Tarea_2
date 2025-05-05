package org.example;

import java.util.ArrayList;

 class Asistencia<T> {
    private ArrayList<T> Generico;

    /**
     * Constructor que instancia el GDeposito con la creación de un arreglo de tipo T.
     */
    public Asistencia() {
        Generico = new ArrayList<>();
    }


    /**
     * Función que ingresa los objetos en el deposito.
     * @param generico corresponde al objeto que se desea ingresar.
     */
    public void add(T generico) {
        if (generico != null) {
            Generico.add(generico);
        }
    }

    /**
     * Función que saca los objetos del deposito.
     * @return T corresponde al objeto que se extrae del deposito
     */
    public T get() {
        if (Generico.isEmpty()) {
            return null;
        }
        else {
            T aux = Generico.get(Generico.size() - 1);
            Generico.remove(Generico.size() - 1);
            return aux;
        }
    }
}