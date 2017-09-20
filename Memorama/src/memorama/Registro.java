package memorama;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author JuanDanielCR
 */
public class Registro implements Comparable, Serializable{
    private Date inicio;
    private Date fin;
    private long minutos;
    private String nombre;
            
    public Registro(){
        inicio = new Date();
    }
    public long obtenerMinutos(){
        long diff = fin.getTime() - inicio.getTime();
        minutos = diff / 1000 % 60;
        return minutos;
    }
    
    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getFin() {
        return fin;
    }

    public void setFin(Date fin) {
        this.fin = fin;
    }

    public long getMinutos() {
        return minutos;
    }

    public void setMinutos(long minutos) {
        this.minutos = minutos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    @Override
    public int compareTo(Object o) {
        long aux = this.minutos - ((Registro)o).getMinutos();
        if(aux > 0){
            return -1;
        }else{
            return 1;
        }
    }

    @Override
    public String toString() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        return "Inicio: "+dateFormat.format(inicio)+" fin: "+dateFormat.format(fin)+" tiempo: "+minutos+" seg\n";
    }
    
}
