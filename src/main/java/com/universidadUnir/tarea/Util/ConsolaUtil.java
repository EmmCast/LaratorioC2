package com.universidadUnir.tarea.Util;

import java.util.Scanner;

/**
 * Clase utilitaria para centralizar operaciones comunes de lectura
 * y control de flujo en consola.
 *
 * Incluye métodos para leer números enteros, valores decimales
 * y pausar la ejecución hasta que el usuario presione Enter.
 *
 * @author Isai Emmanuel Castro 
 * @version 1.0
 */
public class ConsolaUtil {

    /**
     * Lee un número entero desde consola y valida que la entrada sea correcta.
     *
     * @param scanner objeto Scanner utilizado para leer la entrada del usuario
     * @param mensaje mensaje mostrado antes de solicitar el valor
     * @return número entero ingresado por el usuario
     */
    public static int leerEntero(Scanner scanner, String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Entrada invalida. Debe ingresar un numero entero.");
            }
        }
    }

    /**
     * Lee un número decimal desde consola y valida que la entrada sea correcta.
     *
     * @param scanner objeto Scanner utilizado para leer la entrada del usuario
     * @param mensaje mensaje mostrado antes de solicitar el valor
     * @return número decimal ingresado por el usuario
     */
    public static double leerDouble(Scanner scanner, String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Entrada invalida. Debe ingresar un numero valido.");
            }
        }
    }

    /**
     * Pausa la ejecución del programa hasta que el usuario presione Enter.
     *
     * @param scanner objeto Scanner utilizado para capturar la confirmación del usuario
     */
    public static void pausar(Scanner scanner) {
        System.out.println("\nPresione Enter para continuar...");
        scanner.nextLine();
    }
}