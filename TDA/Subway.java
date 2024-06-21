package TDA;

import java.util.ArrayList;
import java.util.List;

public class Subway {
    public static int ID =0;
    private int id_Subway;
    private String nombre_Subway;
    List<Train> trenes;
    List<Line> lineas;
    List<Driver> drivers;

    public Subway(String nombre_Subway) {
        this.id_Subway = this.ID++;
        this.nombre_Subway = nombre_Subway;
        this.trenes = new ArrayList<Train>();
        this.lineas = new ArrayList<Line>();
        this.drivers = new ArrayList<Driver>();
    }

    public int getId_Subway() {
        return id_Subway;
    }

    public void setId_Subway(int id_Subway) {
        this.id_Subway = id_Subway;
    }

    public String getNombre_Subway() {
        return nombre_Subway;
    }

    public void setNombre_Subway(String nombre_Subway) {
        this.nombre_Subway = nombre_Subway;
    }
    public List<Train> getTrenes() {
        return trenes;
    }
    public List<Line> getLineas() {
        return lineas;
    }
    public List<Driver> getDrivers() {
        return drivers;
    }
    /**
     * Metodo que agrega uno o más trenes a una red de metro
     * @param train recibe como parametro una lista de trenes que puede estar vacia o no
     */
    public void addTrain(ArrayList <Train> train) {
        this.trenes.addAll(train);

    }

    /**
     * Metodo que agrega uno o más líneas a una red de metro
     * @param lines recibe como parametro una lista de líneas que puede estar vacia o no
     */
    public void addLine(ArrayList <Line> lines) {
        this.lineas.addAll(lines);
    }

    /**
     * Metodo que agrega uno o mas conductores a una red de metro
     * @param drivers recibe como parametro una lista de conductores que puede estar vacia o no
     */
    public void addDriver(ArrayList <Driver> drivers) {
        this.drivers.addAll(drivers);
    }


    @Override
    public String toString() {
        return "Representacion de Subway: " + "\n" +
                "nombre_Subway=" + nombre_Subway + "\n"+
                "ID de Subway=" + id_Subway+ "\n"+
                "Datos de trenes=" + trenes + "\n"+
                "Datos de lineas=" + lineas + "\n"+
                "Datos de Conductores=" + drivers + "\n";
    }
}
