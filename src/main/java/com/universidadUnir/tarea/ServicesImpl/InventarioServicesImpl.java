package com.universidadUnir.tarea.ServicesImpl;


import java.util.ArrayList;
import java.util.List;

import com.universidadUnir.tarea.Model.Producto;
import com.universidadUnir.tarea.Service.IInventarioServices;

public class InventarioServicesImpl implements IInventarioServices{


    private final List<Producto> productos = new ArrayList<>();

    @Override
    public String agregarProducto(Producto agregar) {

        if (agregar == null) {
            return "El producto no puede ser nulo.";
        }

        if (agregar.getId() <= 0) {
            return "El ID debe ser mayor que 0.";
        }

        if (agregar.getNombre() == null || agregar.getNombre().trim().isEmpty()) {
            return "El nombre del producto es obligatorio.";
        }

        if (agregar.getCantidad() < 0) {
            return "La cantidad no puede ser negativa.";
        }

        if (agregar.getPrecio() < 0) {
            return "El precio no puede ser negativo.";
        }

        if (buscarPorId(agregar.getId()) != null) {
            return "Ya existe un producto con ese ID.";
        }

        productos.add(agregar);
        return "Producto agregado exitosamente.";
    }

    @Override
    public List<Producto> obtenerTodos() {
        return productos;
    }

    @Override
    public Producto buscarPorId(int id) {
        for (Producto producto : productos) {
            if (producto.getId() == id) {
                return producto;
            }
        }
        return null;
    }

    @Override
    public String actualizarCantidad(int id, int nuevaCantidad) {

        Producto producto = buscarPorId(id);

        if (producto == null) {
            return "No se encontro un producto con ese ID.";
        }

        if (nuevaCantidad < 0) {
            return "La nueva cantidad no puede ser negativa.";
        }

        producto.setCantidad(nuevaCantidad);
        return "Cantidad actualizada correctamente.";
    }

    @Override
    public boolean estaVacio() {
        return productos.isEmpty();
    }
}