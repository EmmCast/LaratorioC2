package com.universidadUnir.tarea.Service;

import java.util.List;

import com.universidadUnir.tarea.Model.Producto;

public interface IInventarioServices {

    String agregarProducto(Producto agregar);
    List<Producto> obtenerTodos();
    Producto buscarPorId(int id);
    String actualizarCantidad(int id, int nuevaCantidad);
    boolean estaVacio();

}
