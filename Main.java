import TDA.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static ArrayList<Station> estaciones = new ArrayList<>();
    public static ArrayList<Section> secciones = new ArrayList<>();
    public static ArrayList<PassengerCar> carros = new ArrayList<>();
    public static ArrayList<Train> trenes = new ArrayList<>();
    public static ArrayList<Line> lineas = new ArrayList<>();

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
            System.out.println("1. Creación de estaciones (mediante carga de archivo estaciones.txt)");
            System.out.println("2. Creación de secciones de estaciones (mediante carga de archivo secciones.txt)");
            System.out.println("3. Creación de Trenes (mediante carga archivo trenes.txt)");
            System.out.println("4. Creación de lineas de metro (mediante carga archivo lineas.txt)");
            System.out.println("5. Retorno al menú de Inicio\n");
            System.out.print("Ingrese la opción deseada: ");

            int opcionCargar = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea después del nextInt()

            switch (opcionCargar) {
                case 1:
                    crearestaciones();
                    break;
                case 2:
                    crearsecciones();
                    break;
                case 3:
                    creartrenes();
                    break;
                case 4:
                    crearlineas();
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

    private static void crearestaciones() {

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
                    estaciones.add(station);
                }
            }

            scanner.close();
            System.out.println("-----Se cargaron con exitos las estaciones desde el archivo estaciones.txt-------");
        } catch (FileNotFoundException e) {
            System.out.println("El archivo no se encontró: " + e.getMessage());
        }

        // Ahora puedes trabajar con el ArrayList de stations

        //Seguir leyendo info de secciones y luego crear lineas
    }

    private static void crearsecciones() {
        crearestaciones();

        try {
            File file = new File("recursos/secciones.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");

                if (parts.length == 2) {
                    int distance = Integer.parseInt(parts[0].trim());
                    int cost = Integer.parseInt(parts[1].trim());

                    Section section = new Section(estaciones.get(0),estaciones.get(1),distance,cost);
                    secciones.add(section);
                }
            }

            scanner.close();
            System.out.println("-----Se cargaron con exitos las secciones desde el archivo secciones.txt-------");
        } catch (FileNotFoundException e) {
            System.out.println("El archivo no se encontró: " + e.getMessage());
        }

        // Ahora puedes trabajar con el ArrayList de stations

        //Seguir leyendo info de secciones y luego crear lineas
    }

    private static void creartrenes() {
        crearcarros();

        try {
            File file = new File("recursos/trenes.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");

                if (parts.length == 3) {
                    String trainMaker = parts[0].trim();
                    int Speed = Integer.parseInt(parts[1].trim());
                    int stationStayTime = Integer.parseInt(parts[2].trim());

                    Train train = new Train(trainMaker,Speed,stationStayTime,carros);
                    trenes.add(train);
                }
            }

            scanner.close();
            System.out.println("-----Se cargaron con exito los trenes desde el archivo trenes.txt-------");
        } catch (FileNotFoundException e) {
            System.out.println("El archivo no se encontró: " + e.getMessage());
        }

        // Ahora puedes trabajar con el ArrayList de stations

        //Seguir leyendo info de secciones y luego crear lineas
    }


    private static void crearcarros() {

        try {
            File file = new File("recursos/carros.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");

                if (parts.length == 4) {
                    int capacidad = Integer.parseInt(parts[0].trim());
                    String modelo = parts[1].trim();
                    String trainMaker = parts[2].trim();
                    String carType = parts[3].trim();

                    PassengerCar carro = new PassengerCar(capacidad,modelo,trainMaker,carType);
                    carros.add(carro);
                }
            }

            scanner.close();
            System.out.println("-----Se cargaron con exitos los carros desde el archivo carros.txt-------");
        } catch (FileNotFoundException e) {
            System.out.println("El archivo no se encontró: " + e.getMessage());
        }

    }

    private static void crearlineas() {
        crearsecciones();

        try {
            File file = new File("recursos/lineas.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");

                if (parts.length == 2) {
                    String nombre = parts[0].trim();
                    String rail_type = parts[1].trim();

                    Line linea = new Line(nombre,rail_type,secciones);
                    lineas.add(linea);
                }
            }

            scanner.close();
            System.out.println("-----Se cargaron con exito las lineas desde el archivo lineas.txt-------");
            System.out.println(lineas.toString());
        } catch (FileNotFoundException e) {
            System.out.println("El archivo no se encontró: " + e.getMessage());
        }

    }






    public static void menuVisualizarEstado() {
        Scanner scanner = new Scanner(System.in);
        boolean volverMenuInicio= false;
        while (!volverMenuInicio) {
            System.out.println("\n### Sistema Metro - Visualización del estado actual del sistema de metros ###");
            System.out.println("Definiciones estructurales de su sistema subido desde archivos\n");
            System.out.println("1. Desplegar en pantalla el estado actual de la red de metros");
            System.out.println("2. Retorno al menú de Inicio\n");
            System.out.print("Ingrese la opción deseada: ");
            int opcion=scanner.nextInt();
            scanner.nextLine();
            switch (opcion) {
                case 1:
                    System.out.println(" A CONTINUACION SE MUESTRA LA INFROMACION DE LA RED DE METRO ACTUAL");
                    crearlineas();
                    break;

                case 2:
                    volverMenuInicio = true;
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, ingresa una opción válida.");
                    break;
            }
        }
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
            System.out.println("10. Retorno al menú de Inicio\n");
            System.out.print("Ingrese la opción deseada: ");

            int opcionInteractuar = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea después del nextInt()

            switch (opcionInteractuar) {
                case 1:
                    System.out.println("Opción 1 seleccionada: lineLength");
                    for (Line l: lineas){
                        System.out.printf("El largo de %s es %d%n", l.getName(), l.line_length());
                    }
                    break;
                case 2:
                    System.out.println("Opción 2 seleccionada: lineSectionLength");
                    String nameStation1;
                    String nameStation2;
                    for (int i = 0; i < lineas.size(); i++) {
                        nameStation1=lineas.get(i).getSecciones().get(i).getStation1().getName();
                        nameStation2=lineas.get(i).getSecciones().get(i).getStation2().getName();
                        System.out.printf("El largo de la seccion %s--- %s es: %d%n ", nameStation1,nameStation2, lineas.get(i).line_section_length(nameStation1,nameStation2));
                    }
                    break;
                case 3:
                    System.out.println("Opción 3 seleccionada: lineCost");
                    for (Line l: lineas){
                        System.out.printf("El costo de %s es %d%n", l.getName(), l.line_cost());
                    }
                    break;
                case 4:
                    System.out.println("Opción 4 seleccionada: lineSectionCost");

                    for (int i = 0; i < lineas.size(); i++) {
                        nameStation1=lineas.get(i).getSecciones().get(i).getStation1().getName();
                        nameStation2=lineas.get(i).getSecciones().get(i).getStation2().getName();
                        System.out.printf("El costo de la seccion %s--- %s es: %d%n ", nameStation1,nameStation2, lineas.get(i).line_section_cost(nameStation1,nameStation2));
                    }
                    break;
                case 5:
                    System.out.println("Opción 5 seleccionada: isLine");
                    for (Line l: lineas){
                        if (l.isline(l)) {
                            System.out.printf("%s Si cumple los requisitos para ser una linea\n", l.getName());
                        }
                        else {
                            System.out.printf("%s No cumple los requisitos para ser una linea", l.getName());
                        }

                    }
                    break;
                case 6:
                    System.out.println("Opción 6 seleccionada: Train - addCar");
                    creartrenes();
                    System.out.println("Estado de los trenes antes de ser añadido un carro");
                    for (Train t: trenes){
                        System.out.println(t.toString());
                    }
                    System.out.println("Estado de los trenes despues de ser añadido un carro en la primera posicion");
                    for (Train t: trenes){
                        t.addCar(carros.get(0),0);
                        System.out.println(t.toString());
                    }
                    break;
                case 7:
                    System.out.println("Opción 7 seleccionada: Train - removeCar");
                    creartrenes();
                    System.out.println("Estado de los trenes antes de ser eliminado un carro");
                    for (Train t: trenes){
                        System.out.println(t.toString());
                    }
                    System.out.println("Estado de los trenes despues de ser eliminado un carro en la primera posicion");
                    for (Train t: trenes){
                        t.removeCar(0);
                        System.out.println(t.toString());
                    }
                    break;
                case 8:
                    System.out.println("Opción 8 seleccionada: Train - isTrain");
                    creartrenes();
                    for (Train t: trenes){
                        if (t.isTrain()) {
                            System.out.printf("El tren de id %s Si cumple los requisitos para ser un tren\n", t.getTrainID());
                        }
                        else {
                            System.out.printf("El tren de id %s No cumple los requisitos para ser un tren\n", t.getTrainID());
                        }

                    }
                    break;
                case 9:
                    System.out.println("Opción 9 seleccionada: Train - fetchCapacity");
                    creartrenes();
                    for (Train t: trenes){
                        System.out.printf("La capacidad del tren de id %s es %s\n", t.getTrainID(),t.fetchCapacity());
                    }
                    break;
                case 10:
                    volverMenuInicio = true;
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, ingresa una opción válida.");
                    break;
            }
        }

    }


}

