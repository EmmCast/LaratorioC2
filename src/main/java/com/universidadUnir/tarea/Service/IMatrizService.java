package com.universidadUnir.tarea.Service;

import java.util.Scanner;

/**
 * Define las operaciones relacionadas con la creación,
 * captura, visualización y procesamiento de matrices numéricas.
 *
 * @author Isai Emmanuel Castro 
 * @version 1.0
 */
public interface IMatrizService {

    /**
     * Crea una matriz con las dimensiones especificadas.
     *
     * @param filas número de filas
     * @param columnas número de columnas
     * @return matriz inicializada con los tamaños indicados
     */
    int[][] crearMatriz(int filas, int columnas);

    /**
     * Permite ingresar valores manualmente en una matriz.
     *
     * @param scanner objeto Scanner utilizado para la lectura de datos
     * @param matriz matriz en la que se almacenarán los valores capturados
     */
    void ingresarDatos(Scanner scanner, int[][] matriz);

    /**
     * Muestra en consola el contenido de una matriz.
     *
     * @param matriz matriz a mostrar
     */
    void mostrarMatriz(int[][] matriz);

    /**
     * Calcula la suma de cada fila de la matriz.
     *
     * @param matriz matriz a procesar
     * @return arreglo con la suma correspondiente a cada fila
     */
    int[] sumarFilas(int[][] matriz);

    /**
     * Calcula la suma total de todos los elementos de la matriz.
     *
     * @param matriz matriz a procesar
     * @return suma total de los elementos
     */
    int sumarTotal(int[][] matriz);
}