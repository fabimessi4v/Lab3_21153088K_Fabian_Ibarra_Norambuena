package TDA;

import java.util.List;

public class Train {
    public static int ID =0;
    int TrainID;
    String TrainMaker;
    int speed;
    int stationStayTime;
    List<PassengerCar> carList;

    public Train(String trainMaker, int speed, int stationStayTime, List<PassengerCar> carList) {
        this.TrainID=ID++;
        TrainMaker = trainMaker;
        this.speed = speed;
        this.stationStayTime = stationStayTime;
        this.carList = carList;
    }

    public int getTrainID() {
        return TrainID;
    }

    public void setTrainID(int trainID) {
        TrainID = trainID;
    }

    public String getTrainMaker() {
        return TrainMaker;
    }

    public void setTrainMaker(String trainMaker) {
        TrainMaker = trainMaker;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getStationStayTime() {
        return stationStayTime;
    }

    public void setStationStayTime(int stationStayTime) {
        this.stationStayTime = stationStayTime;
    }

    public List<PassengerCar> getCarList() {
        return carList;
    }

    public void setCarList(List<PassengerCar> carList) {
        this.carList = carList;
    }
}
