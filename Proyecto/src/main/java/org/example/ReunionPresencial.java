package org.example;

import java.time.*;
import java.util.Date;

public class ReunionPresencial extends Reunion {
 private final String sala;

 public ReunionPresencial(Date fecha, Instant horaPrevista, Duration duracionPrevista, Empleado organizador, TipoReunion tipo, String sala) {
  super(fecha, horaPrevista, duracionPrevista, organizador, tipo);
  this.sala = sala;
 }

 public String getLugar() {
  return "Sala: " + sala;
 }

 @Override
 public String toString() {
  return "ReunionPresencial{" +
          "sala='" + sala + '\'' +
          "} " + super.toString();
 }
}