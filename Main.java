import TDA.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            ManejoMenu.mostrarMenuInicio();
            int opcionInicio = scanner.nextInt();
            scanner.nextLine();

            switch (opcionInicio) {
                case 1:
                    ManejoMenu.menuCargarInformacion(scanner);
                    break;
                case 2:
                    ManejoMenu.menuVisualizarEstado();
                    break;
                case 3:
                    ManejoMenu.menuInteractuar();
                    break;
                case 4:
                    salir = true;
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, ingresa una opción válida.");
                    break;
            }
        }
        scanner.close();
    }

}

