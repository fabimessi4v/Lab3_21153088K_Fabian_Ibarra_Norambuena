package TDA;

public class Station {
    public static int ID =0;
    private int id_station;
    private String name;
    private String stationtype;
    private int stoptime ;

    /**
     * Constructor de TDA Station con ID Autoincremental
     * @param name
     * @param stationtype
     * @param stoptime
     */
    public Station(String name, String stationtype, int stoptime) {
        this.id_station = this.ID++;
        this.name = name;
        if (stationtype.equals("m") ||
                stationtype.equals("c") ||
                stationtype.equals("t") ||
                stationtype.equals("r")){
            this.stationtype = stationtype;
        }
        this.stoptime = stoptime;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStationtype() {
        return stationtype;
    }

    public void setStationtype(String stationtype) {
        this.stationtype = stationtype;
    }

    public int getStoptime() {
        return stoptime;
    }

    public void setStoptime(int stoptime) {
        this.stoptime = stoptime;
    }

    public int getId_station() {
        return id_station;
    }

    public void setId_station(int id_station) {
        this.id_station = id_station;
    }
}
