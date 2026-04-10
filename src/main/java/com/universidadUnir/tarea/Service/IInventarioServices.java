package com.universidadUnir.tarea.Service;

import java.util.List;

import com.universidadUnir.tarea.Model.Producto;


/**
 * Define las operaciones de negocio para la gestión del inventario.
 *
 * Permite registrar productos, listar el inventario,
 * buscar productos por identificador y actualizar sus existencias.
 *
 * @author Isai Emmanuel Castro 
 * @version 1.0
 */
public interface IInventarioServices {

    /**
     * Agrega un nuevo producto al inventario.
     *
     * @param agregar producto a registrar
     * @return mensaje indicando el resultado de la operación
     */
    String agregarProducto(Producto agregar);

    /**
     * Obtiene todos los productos registrados en el inventario.
     *
     * @return lista de productos almacenados
     */
    List<Producto> obtenerTodos();

    /**
     * Busca un producto por su identificador.
     *
     * @param id identificador del producto
     * @return producto encontrado, o {@code null} si no existe
     */
    Producto buscarPorId(int id);

    /**
     * Actualiza la cantidad disponible de un producto.
     *
     * @param id identificador del producto a actualizar
     * @param nuevaCantidad nueva cantidad a asignar
     * @return mensaje indicando el resultado de la actualización
     */
    String actualizarCantidad(int id, int nuevaCantidad);

    /**
     * Verifica si el inventario está vacío.
     *
     * @return {@code true} si no hay productos registrados; en caso contrario {@code false}
     */
    boolean estaVacio();
}