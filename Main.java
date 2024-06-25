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
            mostrarMenuInicio();
            int opcionInicio = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea después del nextInt()

            switch (opcionInicio) {
                case 1:
                    menuCargarInformacion(scanner);
                    break;
                case 2:
                    menuVisualizarEstado();
                    break;
                case 3:
                    menuInteractuar();
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

    public static void mostrarMenuInicio() {
        System.out.println("\n### Sistema Metro - Inicio ###");
        System.out.println("Opciones de creación de la red de metro y simulación de ejecución\n");
        System.out.println("1. Cargar información del sistema de metro");
        System.out.println("2. Visualizar estado actual del sistema de metro");
        System.out.println("3. Interactuar con el sistema de metro");
        System.out.println("4. Salir del programa\n");
        System.out.print("Ingrese la opción deseada: ");
    }

    public static void menuCargarInformacion(Scanner scanner) {
        boolean volverMenuInicio = false;

        while (!volverMenuInicio) {
            System.out.println("\n### Sistema Metro - Cargar información del sistema de metro ###");
            System.out.println("Definiciones estructurales de su sistema subido desde archivos\n");
            System.out.println("1. Creación de una línea de metro básica");
            System.out.println("2. Combinaciones entre estaciones entre Líneas (cargar archivo combinaciones.txt)");
            System.out.println("3. Definición de trenes con distintos número de carros (cargar archivo trenes.txt)");
            System.out.println("4. Conductores asignados a una Línea (cargar archivo conductores.txt)");
            System.out.println("5. Retorno al menú de Inicio\n");
            System.out.print("Ingrese la opción deseada: ");

            int opcionCargar = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea después del nextInt()

            switch (opcionCargar) {
                case 1:
                    crearlineas();
                    break;
                case 2:
                    cargarArchivo("combinaciones.txt");
                    break;
                case 3:
                    cargarArchivo("trenes.txt");
                    break;
                case 4:
                    cargarArchivo("conductores.txt");
                    break;
                case 5:
                    volverMenuInicio = true;
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, ingresa una opción válida.");
                    break;
            }
        }
    }

    private static void crearlineas() {
        ArrayList<Station> stations = new ArrayList<>();

        try {
            File file = new File("recursos/estaciones.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");

                if (parts.length == 3) {
                    String nombre = parts[0].trim();
                    String stationtime = parts[1].trim();
                    int stoptime = Integer.parseInt(parts[2].trim());

                    Station station = new Station(nombre, stationtime, stoptime);
                    stations.add(station);
                }
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("El archivo no se encontró: " + e.getMessage());
        }

        // Ahora puedes trabajar con el ArrayList de stations
        for (Station station : stations) {
            System.out.println(station.getName()); // Opcional: para imprimir las estaciones leídas
        }
        //Seguir leyendo info de secciones y luego crear lineas
    }

    public static void menuVisualizarEstado() {
        System.out.println("\n### Sistema Metro - Visualización del estado actual del sistema de metros ###");
        System.out.println("Definiciones estructurales de su sistema subido desde archivos\n");
        System.out.println("1. Desplegar en pantalla el estado actual de la red de metros");
        System.out.println("2. Retorno al menú de Inicio\n");
        System.out.print("Ingrese la opción deseada: ");
        // Aquí se implementaría la lógica para mostrar el estado actual del sistema de metros
    }

    public static void menuInteractuar() {
        Scanner scanner = new Scanner(System.in);
        boolean volverMenuInicio = false;

        while (!volverMenuInicio) {
            System.out.println("\n### Sistema Metro - Interactuar con el sistema de metros ###");
            System.out.println("A través de las siguientes opciones usted puede interactuar con la red de metros cargada previamente por archivos de texto.\n");
            System.out.println("1. lineLength: obtener el largo total de una línea.");
            System.out.println("2. lineSectionLength: determinar el tracto entre una estación origen y final.");
            System.out.println("3. lineCost: determinar el costo total de recorrer una línea.");
            System.out.println("4. lineSectionCost: determinar el costo de un trayecto entre estación origen y final.");
            System.out.println("5. isLine: verificar si una línea cumple con las restricciones especificadas.");
            System.out.println("6. Train - addCar: añade un carro de pasajeros a un tren en la posición establecida.");
            System.out.println("7. Train - removeCar: remueve un carro de pasajeros de un tren en la posición establecida.");
            System.out.println("8. Train - isTrain: verifica si un tren cumple con las especificaciones de los carros de pasajeros.");
            System.out.println("9. Train - fetchCapacity: entrega la capacidad máxima de pasajeros de un tren.");
            System.out.println("10. Subway - whereIsTrain: determina la ubicación de un tren a partir de una hora indicada del día.");
            System.out.println("11. Subway - trainPath: armar el recorrido del tren a partir de una hora especificada y que retorna la lista de estaciones futuras por recorrer.");
            System.out.println("12. Retorno al menú de Inicio\n");
            System.out.print("Ingrese la opción deseada: ");

            int opcionInteractuar = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea después del nextInt()

            switch (opcionInteractuar) {
                case 1:
                    System.out.println("Opción 1 seleccionada: lineLength");
                    break;
                case 2:
                    System.out.println("Opción 2 seleccionada: lineSectionLength");
                    break;
                case 3:
                    System.out.println("Opción 3 seleccionada: lineCost");
                    break;
                case 4:
                    System.out.println("Opción 4 seleccionada: lineSectionCost");
                    break;
                case 5:
                    System.out.println("Opción 5 seleccionada: isLine");
                    break;
                case 6:
                    System.out.println("Opción 6 seleccionada: Train - addCar");
                    break;
                case 7:
                    System.out.println("Opción 7 seleccionada: Train - removeCar");
                    break;
                case 8:
                    System.out.println("Opción 8 seleccionada: Train - isTrain");
                    break;
                case 9:
                    System.out.println("Opción 9 seleccionada: Train - fetchCapacity");
                    break;
                case 10:
                    System.out.println("Opción 10 seleccionada: Subway - whereIsTrain");
                    break;
                case 11:
                    System.out.println("Opción 11 seleccionada: Subway - trainPath");
                    break;
                case 12:
                    volverMenuInicio = true;
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, ingresa una opción válida.");
                    break;
            }
        }

        scanner.close();
    }

    public static void cargarArchivo(String nombreArchivo) {
        // Aquí iría la lógica para cargar el archivo especificado
        System.out.println("Cargando archivo: " + nombreArchivo);
    }
}

