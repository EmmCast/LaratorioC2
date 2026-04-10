package com.universidadUnir.tarea.ServicesImpl;

import com.universidadUnir.tarea.Service.ICadenaServices;
/**
 * Implementación de los servicios de manipulación de cadenas.
 *
 * Proporciona operaciones para contar vocales, invertir texto
 * y convertir cadenas a mayúsculas.
 *
 * @author Isai Emmanuel Castro 
 * @version 1.0
 */
public class CadenaServicesImpl implements ICadenaServices {

    /**
     * {@inheritDoc}
     */
    @Override
    public int contarVocales(String texto) {
        if (texto == null || texto.isEmpty()) {
            return 0;
        }

        int contador = 0;
        String vocales = "aeiouAEIOU";

        for (int i = 0; i < texto.length(); i++) {
            if (vocales.indexOf(texto.charAt(i)) != -1) {
                contador++;
            }
        }

        return contador;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String invertirCadena(String texto) {
        if (texto == null) {
            return "";
        }
        return new StringBuilder(texto).reverse().toString();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String convertirMayusculas(String texto) {
        if (texto == null) {
            return "";
        }
        return texto.toUpperCase();
    }
}