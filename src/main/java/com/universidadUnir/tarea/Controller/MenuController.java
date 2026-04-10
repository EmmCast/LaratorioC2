package com.universidadUnir.tarea.Controller;

import java.util.Scanner;

import com.universidadUnir.tarea.Model.Estudiante;
import com.universidadUnir.tarea.Model.Producto;
import com.universidadUnir.tarea.Service.ICadenaServices;
import com.universidadUnir.tarea.Service.IEstudianteService;
import com.universidadUnir.tarea.Service.IInventarioServices;
import com.universidadUnir.tarea.Service.IMatrizService;
import com.universidadUnir.tarea.Util.ConsolaUtil;


/**
 * Controlador principal encargado de gestionar la interacción con el usuario
 * mediante un menú en consola.
 *
 * Esta clase permite acceder a los distintos módulos del sistema:
 * gestión de estudiantes, operaciones con matrices, manipulación de cadenas
 * y sistema de inventario.
 *
 * Utiliza los servicios correspondientes para delegar la lógica de negocio
 * y mantiene la responsabilidad de capturar y mostrar información al usuario.
 *
 * @author Isai Emmanuel Castro 
 * @version 1.0
 */
public class MenuController {

    private final Scanner scanner;
    private final IEstudianteService estudianteService;
    private final IMatrizService matrizService;
    private final ICadenaServices cadenaService;
    private final IInventarioServices inventarioService;

    /**
     * Constructor que inicializa el controlador del menú principal con
     * las dependencias necesarias para operar cada módulo del sistema.
     *
     * @param scanner objeto Scanner utilizado para leer la entrada del usuario
     * @param estudianteService servicio encargado de la gestión de estudiantes
     * @param matrizService servicio encargado de las operaciones con matrices
     * @param cadenaService servicio encargado de la manipulación de cadenas
     * @param inventarioService servicio encargado de la gestión del inventario
     */
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

    /**
     * Inicia la ejecución del menú principal del sistema.
     *
     * Este método muestra de forma repetitiva las opciones disponibles
     * y redirige al usuario al módulo correspondiente según la opción elegida.
     * Finaliza únicamente cuando el usuario selecciona la opción de salida.
     */
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

    /**
     * Muestra y gestiona el submenú correspondiente al módulo de estudiantes.
     *
     * Permite agregar estudiantes, listar los estudiantes registrados
     * y buscar un estudiante por su nombre.
     */
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

                    Estudiante estudiante = new Estudiante(nombre, edad, calificacion);

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

    /**
     * Ejecuta el módulo de operaciones con matrices.
     *
     * Solicita al usuario las dimensiones de la matriz, permite ingresar
     * sus datos, muestra la matriz capturada y calcula la suma por filas
     * y la suma total de sus elementos.
     */
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

    /**
     * Ejecuta el módulo de manipulación de cadenas.
     *
     * Permite contar las vocales de una cadena, invertir su contenido
     * y convertirlo a mayúsculas.
     */
    private void menuCadenas() {
        System.out.println("\n=============== MANIPULACION DE CADENAS ============");
        System.out.print("Ingrese una cadena de texto: ");
        String texto = scanner.nextLine();

        System.out.println("Cantidad de vocales: " + cadenaService.contarVocales(texto));
        System.out.println("Cadena invertida: " + cadenaService.invertirCadena(texto));
        System.out.println("Cadena en mayusculas: " + cadenaService.convertirMayusculas(texto));

        ConsolaUtil.pausar(scanner);
    }

    /**
     * Muestra y gestiona el submenú del sistema de inventario.
     *
     * Permite registrar productos, listar el inventario, buscar productos
     * por identificador y actualizar la cantidad disponible de un producto.
     */
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