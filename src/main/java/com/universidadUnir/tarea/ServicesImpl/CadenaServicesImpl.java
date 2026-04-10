package com.universidadUnir.tarea.ServicesImpl;

import com.universidadUnir.tarea.Service.ICadenaServices;

public class CadenaServicesImpl implements ICadenaServices{

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

    @Override
    public String invertirCadena(String texto) {
        if (texto == null) {
            return "";
        }
        return new StringBuilder(texto).reverse().toString();
    }

    @Override
    public String convertirMayusculas(String texto) {
        if (texto == null) {
            return "";
        }
        return texto.toUpperCase();
    }
}