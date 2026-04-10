package com.universidadUnir.tarea.Service;

import java.util.List;

import com.universidadUnir.tarea.Model.Estudiante;

public interface IEstudianteService {

    String agregarEstudiante(Estudiante agregar);
    List<Estudiante> obtenerTodos();
    Estudiante buscarPorNombre(String nombre);
    boolean estaVacio();

}
