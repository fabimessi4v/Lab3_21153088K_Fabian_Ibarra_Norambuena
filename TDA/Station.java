package TDA;

public class Station {
    private int id;
    private String name;
    private String stationtype;
    private int stoptime ;

    public Station(int id, String name, String stationtype, int stoptime) {
        this.id = id;
        this.name = name;
        if (stationtype.equals("m") ||
                stationtype.equals("c") ||
                stationtype.equals("t") ||
                stationtype.equals("r")){
            this.stationtype = stationtype;
        }
        this.stoptime = stoptime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}
