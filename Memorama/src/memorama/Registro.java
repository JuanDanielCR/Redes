package memorama;

import java.util.Date;

/**
 *
 * @author JuanDanielCR
 */
public class Registro implements Comparable{
    private Date inicio;
    private Date fin;
    private long minutos;
    private String nombre;
            
    public Registro(){
    }
    public void obtenerMinutos(){
        long diff = inicio.getTime() - fin.getTime();
        minutos = diff / (60 * 1000) % 60;
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
}
