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
        List <PassengerCar> carros;
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

    }


}