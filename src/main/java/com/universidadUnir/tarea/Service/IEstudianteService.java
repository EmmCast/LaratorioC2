package com.universidadUnir.tarea.Service;

import java.util.List;

import com.universidadUnir.tarea.Model.Estudiante;


/**
 * Define las operaciones de negocio para la gestión de estudiantes.
 *
 * Permite registrar estudiantes, obtener el listado completo,
 * buscar un estudiante por nombre y verificar si el registro está vacío.
 *
 * @author Isai Emmanuel Castro 
 * @version 1.0
 */
public interface IEstudianteService {

    /**
     * Agrega un nuevo estudiante al sistema.
     *
     * @param agregar estudiante a registrar
     * @return mensaje indicando el resultado de la operación
     */
    String agregarEstudiante(Estudiante agregar);

    /**
     * Obtiene todos los estudiantes registrados.
     *
     * @return lista de estudiantes almacenados
     */
    List<Estudiante> obtenerTodos();

    /**
     * Busca un estudiante por su nombre.
     *
     * @param nombre nombre del estudiante a buscar
     * @return estudiante encontrado, o {@code null} si no existe coincidencia
     */
    Estudiante buscarPorNombre(String nombre);

    /**
     * Verifica si no existen estudiantes registrados.
     *
     * @return {@code true} si no hay estudiantes; en caso contrario {@code false}
     */
    boolean estaVacio();
}