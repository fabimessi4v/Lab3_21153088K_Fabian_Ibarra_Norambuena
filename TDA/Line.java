package TDA;

import java.util.ArrayList;
import java.util.List;

public class Line {
    public static int ID =0;
    int ID_line;
    String name;
    String rail_type;
    List<Section> secciones;

    /**
     * Constructor de TDA Line con ID autoincremental
     * @param name
     * @param rail_type
     * @param secciones
     */

    public Line(String name, String rail_type, List<Section> secciones) {
        this.ID_line = this.ID++;
        this.name = name;
        this.rail_type = rail_type;
        this.secciones = secciones;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRail_type() {
        return rail_type;
    }

    public void setRail_type(String rail_type) {
        this.rail_type = rail_type;
    }

    public List<Section> getSecciones() {
        return secciones;
    }

    public void setSecciones(List<Section> secciones) {
        this.secciones = secciones;
    }
    public int getID_line() {
        return ID_line;
    }

    public void setID_line(int ID_line) {
        this.ID_line = ID_line;
    }

    /**
     * Metodo que retorna el largo de una linea, sumando las distancias de sus secciones.
     * @return distancia linea
     */
    public int line_length(){
        List<Integer> distancias_temp= new ArrayList<>();
        for(Section seccion : this.secciones){
            distancias_temp.add(seccion.getDistance());
        }
       return distancias_temp.stream().mapToInt(Integer::intValue).sum();
    }

    /**
     * Metodo que recibe como entradas los nombres de dos estaciones que conforman una seccion y retorna el largo de la seccion
     * @param n1
     * @param n2
     * @return distancia seccion de linea
     */
    public int line_section_length(String n1, String n2){
        List<Integer> distancias_temp= new ArrayList<>();
        for(Section seccion : this.secciones){
            if (n1.equals(seccion.station1.getName()) && n2.equals(seccion.station2.getName()))
            {
                distancias_temp.add(seccion.getDistance());
            }
        }
        return distancias_temp.stream().mapToInt(Integer::intValue).sum();


    }

    /**
     * Metodo que Retorna el largo de una linea, sumando los costos de cada seccion de la linea
     * @return costo total de linea
     */

    public int line_cost(){
        List<Integer> costos_temp= new ArrayList<>();
        for(Section seccion : this.secciones){
            costos_temp.add(seccion.getCost());
        }
        return costos_temp.stream().mapToInt(Integer::intValue).sum();
    }

    /**
     * Metodo que retorna el costo de una seccion en especifico, recibiendo como entrada los nombres de la estaciones que componen la seccion
     * @param n1
     * @param n2
     * @return costo de una seccion
     */

    public int line_section_cost(String n1, String n2){
        List<Integer> costos_temp= new ArrayList<>();
        for(Section seccion : this.secciones){
            if (n1.equals(seccion.station1.getName()) && n2.equals(seccion.station2.getName()))
            {
                costos_temp.add(seccion.getCost());
            }
        }
        return costos_temp.stream().mapToInt(Integer::intValue).sum();
    }


}
