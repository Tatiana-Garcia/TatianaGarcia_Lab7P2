
package tatianagarcia_lab7p2;

import java.io.Serializable;
import java.util.ArrayList;

public class Carpeta implements Serializable{
    private String nombre; 
    private String link; 
    private ArrayList<Archivo>archivos = new ArrayList();
    private ArrayList<Carpeta>carpetas= new ArrayList();
    private static final long SerialVersionUID=777L;

    public Carpeta() {
    }

    public Carpeta(String nombre, String link) {
        this.nombre = nombre;
        this.link = link;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public ArrayList<Archivo> getArchivos() {
        return archivos;
    }

    public void setArchivos(ArrayList<Archivo> archivos) {
        this.archivos = archivos;
    }

    public ArrayList<Carpeta> getCarpetas() {
        return carpetas;
    }

    public void setCarpetas(ArrayList<Carpeta> carpetas) {
        this.carpetas = carpetas;
    }

    @Override
    public String toString() {
        return nombre ;
    }
    
    
}
