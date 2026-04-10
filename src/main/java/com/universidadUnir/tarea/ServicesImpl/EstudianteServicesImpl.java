package com.universidadUnir.tarea.ServicesImpl;

import java.util.ArrayList;
import java.util.List;

import com.universidadUnir.tarea.Model.Estudiante;
import com.universidadUnir.tarea.Service.IEstudianteService;

/**
 * Implementación del servicio de gestión de estudiantes.
 *
 * Administra el registro en memoria de estudiantes, incluyendo
 * validaciones de datos, búsqueda por nombre y consulta general.
 *
 * @author Isai Emmanuel Castro 
 * @version 1.0
 */
public class EstudianteServicesImpl implements IEstudianteService {

    /** Lista interna utilizada para almacenar los estudiantes registrados. */
    private final List<Estudiante> estudiantes = new ArrayList<>();

    /** Cantidad máxima de estudiantes permitidos en el sistema. */
    private static final int MAX_ESTUDIANTES = 10;

    /**
     * {@inheritDoc}
     */
    @Override
    public String agregarEstudiante(Estudiante agregar) {
        if (agregar == null) {
            return "El estudiante no puede ser nulo.";
        }

        if (agregar.getNombre() == null || agregar.getNombre().trim().isEmpty()) {
            return "El nombre del estudiante es obligatorio.";
        }

        if (agregar.getEdad() <= 0) {
            return "La edad debe ser mayor que 0.";
        }

        if (agregar.getCalificacion() < 0 || agregar.getCalificacion() > 10) {
            return "La calificacion debe estar entre 0 y 10.";
        }

        if (estudiantes.size() >= MAX_ESTUDIANTES) {
            return "No se pueden agregar nuevos estudiantes.";
        }

        estudiantes.add(agregar);
        return "Estudiante agregado exitosamente.";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Estudiante> obtenerTodos() {
        return estudiantes;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Estudiante buscarPorNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            return null;
        }

        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getNombre().equalsIgnoreCase(nombre.trim())) {
                return estudiante;
            }
        }

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean estaVacio() {
        return estudiantes.isEmpty();
    }
}