package com.universidadUnir.tarea.Service;

import java.util.Scanner;

public interface IMatrizService {

	 int[][] crearMatriz(int filas, int columnas);

	 void ingresarDatos(Scanner scanner, int[][] matriz);

	 void mostrarMatriz(int[][] matriz);

	 int[] sumarFilas(int[][] matriz);

	 int sumarTotal(int[][] matriz);
	    
}
