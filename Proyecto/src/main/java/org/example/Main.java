package org.example;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        ReunionPresencial reunionPresencial;
        Empleado organizador;
        Departamento departamento;

        departamento = new Departamento("Marketing");
        organizador = new Empleado("001", "Saavedra", "Tomas", "tomas.saavedra@example.com", departamento);
        reunionPresencial = new ReunionPresencial(new Date(), Instant.now(), Duration.ofMinutes(60), organizador, TipoReunion.MARKETING, "Sala de Juntas 1");

        System.out.println(organizador.toString());
    }
}