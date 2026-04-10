package com.universidadUnir.tarea.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Producto {

	private Integer id;
	private String nombre;
	private Integer cantidad;
	private Double precio;
	
}
