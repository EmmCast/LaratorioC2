package com.universidadUnir.tarea.ServicesImpl;

import java.util.ArrayList;
import java.util.List;

import com.universidadUnir.tarea.Model.Estudiante;
import com.universidadUnir.tarea.Service.IEstudianteService;

public class EstudianteServicesImpl implements IEstudianteService{

    private final List<Estudiante> estudiantes = new ArrayList<>();
    private static final int MAX_ESTUDIANTES = 10;

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

    @Override
    public List<Estudiante> obtenerTodos() {
        return estudiantes;
    }

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

    @Override
    public boolean estaVacio() {
        return estudiantes.isEmpty();
    }
}