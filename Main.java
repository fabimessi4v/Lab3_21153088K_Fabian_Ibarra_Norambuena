import TDA.Line;
import TDA.Section;
import TDA.Station;

import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        Station st1;
        Station st2;
        Station st3;
        Station st4;
        Section s1;
        Section s2;
        List<Section> listasecciones;
        Line l1;
        Line l2;
        Line l3;
        st1=new Station("Los Heroes","ACSII",23);
        st2=new Station("Republica","ACSII",29);
        st3=new Station("Union Latinoamericana","ACSII",34);
        st4=new Station("Estacion Central","ACSII",35);
        s1=new Section(st1,st2,123,89);
        s2=new Section(st3,st4,189,59);
        listasecciones= new ArrayList<Section>();
        listasecciones.add(s1);
        listasecciones.add(s2);
        l1=new Line("Linea 1","ACSII 24",listasecciones);
        l2=new Line("Linea 2","ACSII 24",null);
        l3=new Line("Linea 3","ACSII 24",null);
        System.out.println(l1.line_length());


    }


}