package TDA;

import java.util.ArrayList;
import java.util.Arrays;
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

    /**
     * Metodo que añade un carro de pasajeros a un tren en una posicion específica
     * @param car carro de pasajeros
     * @param position posicion como índice donde se ingresara el carro
     */
    public void addCar(PassengerCar car, int position) {
        carList.add(position,car);

    }
    /**
     * Metodo que quita un carro de pasajeros a un tren en una posicion específica
     * @param position posicion como índice que indica cuál carro se eliminará
     */

    public void removeCar(int position) {
        carList.remove(position);
    }

    /**
     * Metodo que comprueba que la disposicion de los carros de un tren sea coherente y que los carros sean del mismo modelo
      * @return booleano
     */

    public boolean isTrain() {
        int sizeCarList = carList.size();
        if (!carList.get(0).carType.equals("t") || !carList.get(sizeCarList - 1).carType.equals("t")) {
            return false;
        }

        return todosIguales(carList);

    }

    /**
     * Metodo Auxiliar que determina si todos los carros de pasajeros son del mismo modelo
     * @param carList lista de carros de pasajeros
     * @return booleano
     */
    private boolean todosIguales(List<PassengerCar> carList) {
        String firstCarModel = carList.get(0).model;
        for (int i = 1; i < carList.size(); i++) {
            if (!carList.get(i).model.equals(firstCarModel)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Metodo que retorna la cantidad maxima de pasajeros de un tren
     * @return Sumatoria de las capacidades maximas de cada carro que conforma el tren
     */
    public int fetchCapacity(){
        List<Integer> capacidades_temp= new ArrayList<>();
        for(PassengerCar carro: this.carList){
            capacidades_temp.add(carro.passengerCapacity);
        }
        return capacidades_temp.stream().mapToInt(Integer::intValue).sum();
    }

    @Override
    public String toString() {
        return "Train{" +
                "TrainID=" + TrainID +
                ", TrainMaker='" + TrainMaker + '\'' +
                ", speed=" + speed +
                ", stationStayTime=" + stationStayTime +
                ", carList=" + carList +
                '}';
    }
}
