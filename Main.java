import TDA.*;

import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        Station st1;
        Station st2;
        Station st3;
        Station st4;
        Station st5;
        Station st6;
        Section s1;
        Section s2;
        Section s3;
        List<Section> listasecciones;
        Line l1;
        Line l2;
        Line l3;
        PassengerCar carro1;
        PassengerCar carro2;
        PassengerCar carro3;
        Train t1;
        Train t2;
        List <PassengerCar> carros;
        ArrayList<Train> trenes;
        Subway su1;
        ArrayList<Line> lines;
        Driver d1;
        Driver d2;
        Driver d3;
        ArrayList <Driver> drivers;
        st1=new Station("Los Heroes","ACSII",23);
        st2=new Station("Republica","ACSII",29);
        st3=new Station("Union Latinoamericana","ACSII",34);
        st4=new Station("Estacion Central","ACSII",35);
        st5 =new Station("Lo Espejo","ASCII",21);
        st6=new Station("Cerrillos","ASCII",22);

        s1=new Section(st1,st2,123,89);
        s2=new Section(st3,st4,189,59);
        s3=new Section(st5,st6,235,45);
        listasecciones= new ArrayList<Section>();
        listasecciones.add(s1);
        listasecciones.add(s2);
        l1=new Line("Linea 1","ACSII 24",listasecciones);
        l2=new Line("Linea 2","ACSII 24",null);
        l3=new Line("Linea 3","ACSII 24",null);
        carro1 =new PassengerCar(100,"XFG45","ASCII","t");
        carro2=new PassengerCar(200,"XFG45","ASCII","C");
        carro3= new PassengerCar(800,"XFG45","ASCII","t");
        carros=new ArrayList<>();
        carros.add(carro1);
        carros.add(carro2);
        t1=new Train("ACI233",563,23,carros);
        t2=new Train("ACI233",663,83,carros);
        trenes=new ArrayList<>();
        trenes.add(t1);
        trenes.add(t2);
        su1= new Subway("Metro de Santiago");
        lines = new ArrayList<>();
        drivers= new ArrayList<>();
        d1 = new Driver("Julian Alvarez","ASCII");
        d2 = new Driver("Rodrigo De Paul","ASCII");
        d3 = new Driver("Angel Di Maria","ASCII");
        lines.add(l1);
        lines.add(l2);
        lines.add(l3);
        drivers.add(d1);
        drivers.add(d2);
        drivers.add(d3);
        System.out.println(l1.line_length());
        System.out.println(l1.line_section_length("Union Latinoamericana","Estacion Central"));
        System.out.println(l1.line_cost());
        System.out.println(l1.line_section_cost("Union Latinoamericana","Estacion Central"));
        l1.line_add_section(s3);
        System.out.println(l1.getSecciones().get(2).getStation2().getName());
        System.out.println(carro1.getID_passengerCar());
        System.out.println(carro2.getID_passengerCar());
        System.out.println(t1.getTrainID());
        t1.addCar(carro3,2);
        System.out.println(t1.getCarList().get(2).getCarType());
        System.out.println(t1.isTrain());
        System.out.println(t1.fetchCapacity());
        su1.addTrain(trenes);
        System.out.println(su1.getTrenes().get(1).getStationStayTime());
        su1.addLine(lines);
        System.out.println(su1.getLineas().get(2).getName());
        su1.addDriver(drivers);
        System.out.println(su1.getDrivers().get(2).getNombre());
        System.out.println(su1.toString());



    }


}