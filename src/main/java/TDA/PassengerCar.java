package TDA;

public class PassengerCar {
    public static int ID =0;
    int ID_passengerCar;
    int passengerCapacity;
    String model;
    String trainMaker;
    String carType;

    public PassengerCar(int passengerCapacity, String model, String trainMaker, String carType) {
        this.ID_passengerCar = ID++;
        this.passengerCapacity = passengerCapacity;
        this.model = model;
        this.trainMaker = trainMaker;
        this.carType = carType;
    }

    public int getID_passengerCar() {
        return ID_passengerCar;
    }

    public void setID_passengerCar(int ID_passengerCar) {
        this.ID_passengerCar = ID_passengerCar;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getTrainMaker() {
        return trainMaker;
    }

    public void setTrainMaker(String trainMaker) {
        this.trainMaker = trainMaker;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    @Override
    public String toString() {
        return "PassengerCar{" +
                "ID_passengerCar=" + ID_passengerCar +
                ", passengerCapacity=" + passengerCapacity +
                ", model='" + model + '\'' +
                ", trainMaker='" + trainMaker + '\'' +
                ", carType='" + carType + '\'' +
                '}';
    }
}
