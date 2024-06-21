package TDA;

public class Driver {
    public static int ID =0;
    int ID_Driver;
    String Nombre;
    String TrainMaker;

    public Driver(String nombre, String trainMaker) {
        this.ID_Driver = ID++;
        Nombre = nombre;
        TrainMaker = trainMaker;
    }

    public int getID_Driver() {
        return ID_Driver;
    }

    public void setID_Driver(int ID_Driver) {
        this.ID_Driver = ID_Driver;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getTrainMaker() {
        return TrainMaker;
    }

    public void setTrainMaker(String trainMaker) {
        TrainMaker = trainMaker;
    }
}
