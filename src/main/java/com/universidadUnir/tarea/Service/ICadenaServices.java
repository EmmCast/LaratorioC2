package com.universidadUnir.tarea.Service;

/**
 * Define las operaciones disponibles para la manipulación de cadenas de texto.
 *
 * Incluye funcionalidades para contar vocales, invertir una cadena
 * y convertir su contenido a mayúsculas.
 *
 * @author Isai Emmanuel Castro 
 * @version 1.0
 */
public interface ICadenaServices {

    /**
     * Cuenta la cantidad de vocales presentes en una cadena de texto.
     *
     * @param texto cadena a evaluar
     * @return número de vocales encontradas en la cadena;
     *         retorna 0 si la cadena es nula o vacía
     */
    int contarVocales(String texto);

    /**
     * Invierte el contenido de una cadena de texto.
     *
     * @param texto cadena a invertir
     * @return cadena invertida; retorna una cadena vacía si el parámetro es nulo
     */
    String invertirCadena(String texto);

    /**
     * Convierte una cadena de texto a letras mayúsculas.
     *
     * @param texto cadena a convertir
     * @return cadena convertida a mayúsculas; retorna una cadena vacía si el parámetro es nulo
     */
    String convertirMayusculas(String texto);
}