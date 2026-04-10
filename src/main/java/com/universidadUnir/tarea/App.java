package com.universidadUnir.tarea;

import java.util.Scanner;

import com.universidadUnir.tarea.Controller.MenuController;
import com.universidadUnir.tarea.Service.ICadenaServices;
import com.universidadUnir.tarea.Service.IEstudianteService;
import com.universidadUnir.tarea.Service.IInventarioServices;
import com.universidadUnir.tarea.Service.IMatrizService;
import com.universidadUnir.tarea.ServicesImpl.CadenaServicesImpl;
import com.universidadUnir.tarea.ServicesImpl.EstudianteServicesImpl;
import com.universidadUnir.tarea.ServicesImpl.InventarioServicesImpl;
import com.universidadUnir.tarea.ServicesImpl.MatrizServicesImpl;

/**
 * Clase principal del sistema.
 *
 * Se encarga de inicializar las dependencias necesarias,
 * crear el controlador del menú principal y arrancar la ejecución
 * de la aplicación en consola.
 *
 * @author Isai Emmanuel Castro 
 * @version 1.0
 */
public class App {

    /**
     * Método principal que inicia la ejecución de la aplicación.
     *
     * @param args argumentos de línea de comandos
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        IEstudianteService estudianteService = new EstudianteServicesImpl();
        IMatrizService matrizService = new MatrizServicesImpl();
        ICadenaServices cadenaService = new CadenaServicesImpl();
        IInventarioServices inventarioService = new InventarioServicesImpl();

        MenuController menuController = new MenuController(
                scanner,
                estudianteService,
                matrizService,
                cadenaService,
                inventarioService
        );

        menuController.iniciar();
    }
}
