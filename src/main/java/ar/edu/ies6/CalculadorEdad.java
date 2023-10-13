package ar.edu.ies6;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class CalculadorEdad {

    public static int calcularEdad(String fechaNacimiento) {
        // Formato de fecha
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // Obtén la fecha actual
        LocalDate fechaActual = LocalDate.now();

        // Convierte la fecha de nacimiento a LocalDate
        LocalDate fechaNacimientoLocal = LocalDate.parse(fechaNacimiento, formatter);

        // Calcula la diferencia entre la fecha actual y la fecha de nacimiento
        Period periodo = Period.between(fechaNacimientoLocal, fechaActual);

        // Obtiene la edad
        return periodo.getYears();
    }

    public static void main(String[] args) {
        String fechaNacimiento = "1999-03-03"; // Cambia esta fecha por la fecha de nacimiento del alumno

        int edad = calcularEdad(fechaNacimiento);
        System.out.println("La edad es: " + edad);
    }
}
