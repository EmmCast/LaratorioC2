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


public class App 
{
    public static void main( String[] args )
    {

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
