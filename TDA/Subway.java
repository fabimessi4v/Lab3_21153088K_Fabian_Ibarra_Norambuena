package TDA;

import java.util.ArrayList;
import java.util.Date;
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

    /**
     * Metodo que transforma informacion de una red de metro a string
     * @return String con informacion, para luego ser mostrada por pantalla
     */
    @Override
    public String toString() {
        return "Representacion de Subway: " + "\n" +
                "nombre_Subway=" + nombre_Subway + "\n"+
                "ID de Subway=" + id_Subway+ "\n"+
                "Datos de trenes=" + trenes + "\n"+
                "Datos de lineas=" + lineas + "\n"+
                "Datos de Conductores=" + drivers + "\n";
    }

    /**
     * Metodo que recibe una línea y un tren, y asigna el tren a la línea respectiva
     * @param train tren como entrada
     * @param line linea a cual asignar el tren
     */
    public void assignTrainToLine(Train train, Line line){
        int indice_linea=lineas.indexOf(line);
        this.lineas.get(indice_linea).setTrenes((List<Train>) train);
    }

    /**
     * Metodo que recibe distintos atributos y los modifica dento de la clase Train
     * @param driver
     * @param train
     * @param departuretime
     * @param arrivalstation
     * @param departurestation
     */
    public void assignDriverToTrain(Driver driver, Train train, Date departuretime, Station arrivalstation, Station departurestation){
    int indice_trenes=trenes.indexOf(train);
    this.trenes.get(indice_trenes).setConductor(driver);
    this.trenes.get(indice_trenes).setDeparturetime(departuretime);
    this.trenes.get(indice_trenes).setArrivalStation(arrivalstation);
    this.trenes.get(indice_trenes).setDepartureStation(departurestation);
    }

    /**
     * Metodo que recibe un tren y una fecha y retorna la informacion del tren
     * @param train tren de una red de metro
     * @param date fecha propia del tren
     * @return String con la informacion del tren
     */
    public String whereisTrain(Train train,Date date){
        int indice_tren=trenes.indexOf(train);
        String resultado="";
        if(this.trenes.get(indice_tren).getDeparturetime().equals(date)){
            resultado = this.trenes.get(indice_tren).toString();
            return resultado;
        }
        return resultado;
    }

    /**
     * Metodo que retorna informacion del tren, dada una fecha anterior al recorrido
     * @param train Tren de la red
     * @param date fecha anterior al recorrido
     * @return String con informacion del tren (Recorrido restante, dada la fecha de entrada)
     */
    public String trainPath(Train train,Date date){
        int indice_tren=trenes.indexOf(train);
        String resultado= "";
        if(this.trenes.get(indice_tren).getDeparturetime().before(date))
        {
            resultado = this.trenes.get(indice_tren).toString();
            return resultado;
    }
        return resultado;
    }

}
