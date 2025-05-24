package org.example;

import java.time.*;
import java.util.Date;
/**
 * Clase que representa una reunión presencial.
 * Extiende la clase {@link Reunion} y agrega el atributo de sala donde se realiza la reunión.
 *
 * @author Farentsen999
 */
public class ReunionPresencial extends Reunion {
 /**
  * Sala donde se realizará la reunión presencial.
  */
 private final String sala;
 /**
  * Constructor para crear una reunión presencial con sus detalles.
  *
  * @param fecha Fecha de la reunión.
  * @param horaPrevista Hora prevista de inicio de la reunión.
  * @param duracionPrevista Duración prevista de la reunión.
  * @param organizador Empleado que organiza la reunión.
  * @param tipo Tipo de la reunión.
  * @param sala Sala donde se realizará la reunión.
  */
 public ReunionPresencial(Date fecha, Instant horaPrevista, Duration duracionPrevista, Empleado organizador, TipoReunion tipo, String sala) {
  super(fecha, horaPrevista, duracionPrevista, organizador, tipo);
  this.sala = sala;
 }
 /**
  * Obtiene el lugar donde se realizará la reunión presencial.
  *
  * @return Una cadena que describe la sala asignada.
  */
 public String getLugar() {
  return "Sala: " + sala;
 }

 /**
  * Devuelve una representación en texto de la reunión presencial,
  * incluyendo la información de la sala y los detalles heredados.
  *
  * @return Cadena con la información completa de la reunión presencial.
  */
 @Override
 public String toString() {
  return "ReunionPresencial{" +
          "sala='" + sala + '\'' +
          "} " + super.toString();
 }
}