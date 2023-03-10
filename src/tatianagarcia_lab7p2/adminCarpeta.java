
package tatianagarcia_lab7p2;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class adminCarpeta {
    private ArrayList<Carpeta> listaCarpetas = new ArrayList();
    private File archivo = null;

    public adminCarpeta(String path) {
        archivo = new File(path);
    }

    public ArrayList<Carpeta> getListaCarpetas() {
        return listaCarpetas;
    }

    public void setListaCarpetas(ArrayList<Carpeta> listaCarpetas) {
        this.listaCarpetas = listaCarpetas;
    }

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }

    @Override
    public String toString() {
        return "adminCarpeta{" + "listaCarpetas=" + listaCarpetas + ", archivo=" + archivo + '}';
    }
    public void setCarpeta(Carpeta a){
        listaCarpetas.add(a);
    }
    
    
    public void cargarArchivo() {
        try {            
            listaCarpetas = new ArrayList();
            Carpeta temp;
            if (archivo.exists()) {
                FileInputStream entrada
                    = new FileInputStream(archivo);
                ObjectInputStream objeto
                    = new ObjectInputStream(entrada);
                try {
                    while ((temp = (Carpeta) objeto.readObject()) != null) {
                        listaCarpetas.add(temp);
                    }
                } catch (EOFException e) {
                    //encontro el final del archivo
                }
                objeto.close();
                entrada.close();
            }            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void escribirArchivo() {
        FileOutputStream fw = null;
        ObjectOutputStream bw = null;
        try {
            fw = new FileOutputStream(archivo);
            bw = new ObjectOutputStream(fw);
            for (Carpeta t : listaCarpetas) {
                bw.writeObject(t);
            }
            bw.flush();
        } catch (Exception ex) {
        } finally {
            try {
                bw.close();
                fw.close();
            } catch (Exception ex) {
            }
        }
    }
}
