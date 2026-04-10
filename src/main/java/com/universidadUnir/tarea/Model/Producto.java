package com.universidadUnir.tarea.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Representa un producto dentro del sistema de inventario.
 *
 * Cada producto posee un identificador único, un nombre,
 * una cantidad disponible y un precio unitario.
 *
 * Esta clase es utilizada para registrar, consultar y actualizar
 * la información del inventario.
 *
 * @author Isai Emmaneuel Castro Hernandez
 * @version 1.0
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Producto {

    /** Identificador único del producto. */
    private Integer id;

    /** Nombre descriptivo del producto. */
    private String nombre;

    /** Cantidad disponible en inventario. */
    private Integer cantidad;

    /** Precio unitario del producto. */
    private Double precio;
}