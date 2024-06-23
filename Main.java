import TDA.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            // Mostrar el menú
            System.out.println("Menú:");
            System.out.println("1. Cargar información del sistema de metro");
            System.out.println("2. Visualizar estado actual del sistema de metro");
            System.out.println("3. Interactuar con el sistema de metro");
            System.out.println("4. Salir del programa");
            System.out.print("Seleccione una opción: ");

            // Leer la opción del usuario
            opcion = scanner.nextInt();

            // Evaluar la opción seleccionada
            switch (opcion) {
                case 1:
                    System.out.println("Ha seleccionado la opción 1");
                    // Aquí va el código correspondiente a la opción 1
                    break;
                case 2:
                    System.out.println("Ha seleccionado la opción 2");
                    // Aquí va el código correspondiente a la opción 2
                    break;
                case 3:
                    System.out.println("Ha seleccionado la opción 3");
                    // Aquí va el código correspondiente a la opción 3
                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }

            System.out.println(); // Salto de línea para separar las iteraciones del menú
        } while (opcion != 4);

        // Cerrar el scanner al finalizar
        scanner.close();
    }


    }
