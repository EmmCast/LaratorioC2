package com.universidadUnir.tarea.Controller;


import java.util.Scanner;

import com.universidadUnir.tarea.Model.Estudiante;
import com.universidadUnir.tarea.Model.Producto;
import com.universidadUnir.tarea.Service.ICadenaServices;
import com.universidadUnir.tarea.Service.IEstudianteService;
import com.universidadUnir.tarea.Service.IInventarioServices;
import com.universidadUnir.tarea.Service.IMatrizService;
import com.universidadUnir.tarea.Util.ConsolaUtil;

public class MenuController {

    private final Scanner scanner;
    private final IEstudianteService estudianteService;
    private final IMatrizService matrizService;
    private final ICadenaServices cadenaService;
    private final IInventarioServices inventarioService;

    public MenuController(
            Scanner scanner,
            IEstudianteService estudianteService,
            IMatrizService matrizService,
            ICadenaServices cadenaService,
            IInventarioServices inventarioService
    ) {
        this.scanner = scanner;
        this.estudianteService = estudianteService;
        this.matrizService = matrizService;
        this.cadenaService = cadenaService;
        this.inventarioService = inventarioService;
    }

    public void iniciar() {
        int opcion;

        do {
            System.out.println("\n====================================================");
            System.out.println("              MENU PRINCIPAL GENERAL");
            System.out.println("====================================================");
            System.out.println("1. Gestion de estudiantes");
            System.out.println("2. Matriz de numeros");
            System.out.println("3. Manipulacion de cadenas");
            System.out.println("4. Sistema de inventario");
            System.out.println("5. Salir");

            opcion = ConsolaUtil.leerEntero(scanner, "Seleccione una opcion: ");

            switch (opcion) {
                case 1:
                    menuEstudiantes();
                    break;
                case 2:
                    menuMatriz();
                    break;
                case 3:
                    menuCadenas();
                    break;
                case 4:
                    menuInventario();
                    break;
                case 5:
                    System.out.println("\nPrograma finalizado.");
                    break;
                default:
                    System.out.println("Opcion no valida.");
                    break;
            }

        } while (opcion != 5);
    }

    private void menuEstudiantes() {
        int opcion;

        do {
            System.out.println("\n============== GESTION DE ESTUDIANTES ==============");
            System.out.println("1. Agregar estudiante");
            System.out.println("2. Mostrar estudiantes");
            System.out.println("3. Buscar estudiante por nombre");
            System.out.println("4. Regresar");

            opcion = ConsolaUtil.leerEntero(scanner, "Seleccione una opcion: ");

            switch (opcion) {
                case 1:
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();

                    int edad = ConsolaUtil.leerEntero(scanner, "Edad: ");
                    double calificacion = ConsolaUtil.leerDouble(scanner, "Calificacion: ");

                    Estudiante estudiante = new Estudiante();

                    System.out.println(estudianteService.agregarEstudiante(estudiante));
                    ConsolaUtil.pausar(scanner);
                    break;

                case 2:
                    if (estudianteService.estaVacio()) {
                        System.out.println("No hay estudiantes registrados.");
                    } else {
                        for (Estudiante estudianteItem : estudianteService.obtenerTodos()) {
                            System.out.println(estudianteItem);
                        }
                    }
                    ConsolaUtil.pausar(scanner);
                    break;

                case 3:
                    System.out.print("Ingrese el nombre a buscar: ");
                    String nombreBuscar = scanner.nextLine();

                    Estudiante estudianteEncontrado = estudianteService.buscarPorNombre(nombreBuscar);

                    if (estudianteEncontrado == null) {
                        System.out.println("No se encontro un estudiante con ese nombre.");
                    } else {
                        System.out.println("Estudiante encontrado:");
                        System.out.println(estudianteEncontrado);
                    }
                    ConsolaUtil.pausar(scanner);
                    break;

                case 4:
                    break;

                default:
                    System.out.println("Opcion no valida.");
                    ConsolaUtil.pausar(scanner);
                    break;
            }

        } while (opcion != 4);
    }

    private void menuMatriz() {
        System.out.println("\n================= MATRIZ DE NUMEROS ================");

        int filas = ConsolaUtil.leerEntero(scanner, "Ingrese el numero de filas: ");
        int columnas = ConsolaUtil.leerEntero(scanner, "Ingrese el numero de columnas: ");

        if (filas <= 0 || columnas <= 0) {
            System.out.println("Las dimensiones deben ser mayores que 0.");
            ConsolaUtil.pausar(scanner);
            return;
        }

        int[][] matriz = matrizService.crearMatriz(filas, columnas);

        matrizService.ingresarDatos(scanner, matriz);
        matrizService.mostrarMatriz(matriz);

        int[] sumasFilas = matrizService.sumarFilas(matriz);
        for (int i = 0; i < sumasFilas.length; i++) {
            System.out.println("Suma fila " + (i + 1) + ": " + sumasFilas[i]);
        }

        System.out.println("Suma total de la matriz: " + matrizService.sumarTotal(matriz));
        ConsolaUtil.pausar(scanner);
    }

    private void menuCadenas() {
        System.out.println("\n=============== MANIPULACION DE CADENAS ============");
        System.out.print("Ingrese una cadena de texto: ");
        String texto = scanner.nextLine();

        System.out.println("Cantidad de vocales: " + cadenaService.contarVocales(texto));
        System.out.println("Cadena invertida: " + cadenaService.invertirCadena(texto));
        System.out.println("Cadena en mayusculas: " + cadenaService.convertirMayusculas(texto));

        ConsolaUtil.pausar(scanner);
    }

    private void menuInventario() {
        int opcion;

        do {
            System.out.println("\n================ SISTEMA DE INVENTARIO =============");
            System.out.println("1. Agregar producto");
            System.out.println("2. Mostrar inventario");
            System.out.println("3. Buscar producto por ID");
            System.out.println("4. Actualizar cantidad");
            System.out.println("5. Regresar");

            opcion = ConsolaUtil.leerEntero(scanner, "Seleccione una opcion: ");

            switch (opcion) {
                case 1:
                    int id = ConsolaUtil.leerEntero(scanner, "ID: ");

                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();

                    int cantidad = ConsolaUtil.leerEntero(scanner, "Cantidad: ");
                    double precio = ConsolaUtil.leerDouble(scanner, "Precio: ");

                    Producto producto = new Producto(id, nombre, cantidad, precio);

                    System.out.println(inventarioService.agregarProducto(producto));
                    ConsolaUtil.pausar(scanner);
                    break;

                case 2:
                    if (inventarioService.estaVacio()) {
                        System.out.println("No hay productos registrados.");
                    } else {
                        for (Producto productoItem : inventarioService.obtenerTodos()) {
                            System.out.println(productoItem);
                        }
                    }
                    ConsolaUtil.pausar(scanner);
                    break;

                case 3:
                    int idBuscar = ConsolaUtil.leerEntero(scanner, "Ingrese el ID a buscar: ");
                    Producto productoEncontrado = inventarioService.buscarPorId(idBuscar);

                    if (productoEncontrado == null) {
                        System.out.println("No se encontro un producto con ese ID.");
                    } else {
                        System.out.println("Producto encontrado:");
                        System.out.println(productoEncontrado);
                    }
                    ConsolaUtil.pausar(scanner);
                    break;

                case 4:
                    int idActualizar = ConsolaUtil.leerEntero(scanner, "Ingrese el ID del producto: ");
                    int nuevaCantidad = ConsolaUtil.leerEntero(scanner, "Ingrese la nueva cantidad: ");

                    System.out.println(inventarioService.actualizarCantidad(idActualizar, nuevaCantidad));
                    ConsolaUtil.pausar(scanner);
                    break;

                case 5:
                    break;

                default:
                    System.out.println("Opcion no valida.");
                    ConsolaUtil.pausar(scanner);
                    break;
            }

        } while (opcion != 5);
    }
}