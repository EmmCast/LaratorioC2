package com.universidadUnir.tarea.ServicesImpl;

import java.util.ArrayList;
import java.util.List;

import com.universidadUnir.tarea.Model.Producto;
import com.universidadUnir.tarea.Service.IInventarioServices;

/**
 * Implementación del servicio de gestión de inventario.
 *
 * Permite registrar productos en memoria, consultarlos,
 * buscarlos por identificador y actualizar su cantidad disponible.
 *
 * @author Isai Emmanuel Castro 
 * @version 1.0
 */
public class InventarioServicesImpl implements IInventarioServices {

    /** Lista interna donde se almacenan los productos registrados. */
    private final List<Producto> productos = new ArrayList<>();

    /**
     * {@inheritDoc}
     */
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

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Producto> obtenerTodos() {
        return productos;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Producto buscarPorId(int id) {
        for (Producto producto : productos) {
            if (producto.getId() == id) {
                return producto;
            }
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
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

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean estaVacio() {
        return productos.isEmpty();
    }
}