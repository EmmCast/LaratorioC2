package com.universidadUnir.tarea.ServicesImpl;

import java.util.Scanner;

import com.universidadUnir.tarea.Service.IMatrizService;

public class MatrizServicesImpl implements IMatrizService{

    @Override
    public int[][] crearMatriz(int filas, int columnas) {
        return new int[filas][columnas];
    }

    @Override
    public void ingresarDatos(Scanner scanner, int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print("Elemento [" + i + "][" + j + "]: ");
                matriz[i][j] = Integer.parseInt(scanner.nextLine());
            }
        }
    }

    @Override
    public void mostrarMatriz(int[][] matriz) {
        System.out.println("\nMatriz ingresada:");
        for (int[] fila : matriz) {
            for (int valor : fila) {
                System.out.print(valor + "\t");
            }
            System.out.println();
        }
    }

    @Override
    public int[] sumarFilas(int[][] matriz) {
        int[] sumas = new int[matriz.length];

        for (int i = 0; i < matriz.length; i++) {
            int suma = 0;
            for (int j = 0; j < matriz[i].length; j++) {
                suma += matriz[i][j];
            }
            sumas[i] = suma;
        }

        return sumas;
    }

    @Override
    public int sumarTotal(int[][] matriz) {
        int suma = 0;

        for (int[] fila : matriz) {
            for (int valor : fila) {
                suma += valor;
            }
        }

        return suma;
    }
}