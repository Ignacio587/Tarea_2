package org.example;

public class ReunionPresencial extends Reunion {
 private String sala;

 public ReunionPresencial(Date fecha, Instant horaPrevista, Duration duracionPrevista, Empleado organizador, TipoReunion tipo, String sala) {
  super(fecha, horaPrevista, duracionPrevista, organizador, tipo);
  this.sala = sala;
 }
}