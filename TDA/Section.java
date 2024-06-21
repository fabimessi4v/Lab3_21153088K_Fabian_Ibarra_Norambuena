package TDA;

public class Section {
    Station station1;
    Station station2;
    int distance;
    int cost;

    /**
     * Constructor de TDA Section
     * @param station1
     * @param station2
     * @param distance
     * @param cost
     */
    public Section(Station station1, Station station2, int distance, int cost) {
        this.station1 = station1;
        this.station2 = station2;
        this.distance = distance;
        this.cost = cost;
    }

    public Station getStation1() {
        return station1;
    }

    public Station getStation2() {
        return station2;
    }

    public int getDistance() {
        return distance;
    }

    public int getCost() {
        return cost;
    }

    public void setStation1(Station station1) {
        this.station1 = station1;
    }

    public void setStation2(Station station2) {
        this.station2 = station2;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Section{" +
                "station1=" + station1 +
                ", station2=" + station2 +
                ", distance=" + distance +
                ", cost=" + cost +
                '}';
    }
}
