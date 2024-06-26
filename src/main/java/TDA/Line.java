package TDA;

import java.util.ArrayList;
import java.util.List;

public class Line {
    public static int ID =0;
    int ID_line;
    String name;
    String rail_type;
    List<Section> secciones;
    List<Train> trenes;

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
        this.trenes = new ArrayList<>();
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
    public List<Train> getTrenes() {
        return trenes;
    }
    public void setTrenes(List<Train> trenes) {
        this.trenes = trenes;
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

    /**
     * Metodo que añade una seccion a una linea
     * @param seccion seccion especifica como entrada
     */
    public void line_add_section(Section seccion){
        this.secciones.add(seccion);
    }

    /**
     * Metodo que Determina si un elemento que corresponde a una linea
     * @param linea
     * @return Retorna siempre true, ya que las verificaciones relacionadas a los tramos y secciones, se hacen de manera interna en sus implementaciones.
     * Además no se podria crear una línea sin los requerimientos de esta, puesto que su constructor no lo permite, en esta implementacion.
     */
    public boolean isline(Line linea){
        return true;
        
    }

    @Override
    public String toString() {
        return "Line{" +
                "ID_line=" + ID_line +
                ", name='" + name + '\'' +
                ", rail_type='" + rail_type + '\'' +
                ", secciones=" + secciones +
                '}';
    }

}
