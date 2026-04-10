package com.universidadUnir.tarea.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Representa a un estudiante dentro del sistema.
 *
 * Un estudiante cuenta con un nombre, una edad y una calificación,
 * los cuales son utilizados para su registro, consulta y validación
 * en el módulo de gestión de estudiantes.
 *
 * La generación de constructores, métodos de acceso y representación
 * en cadena se delega a Lombok.
 *
 * @author Isai Emmauel Castro Hernandez
 * @version 1.0
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Estudiante {

    /** Nombre completo o identificador nominal del estudiante. */
    private String nombre;

    /** Edad del estudiante expresada en años. */
    private int edad;

    /** Calificación obtenida por el estudiante en una escala de 0 a 10. */
    private double calificacion;
}