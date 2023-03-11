
package tatianagarcia_lab7p2;

import javax.swing.JProgressBar;

public class admBarra extends Thread{
    private JProgressBar barra;
    private boolean avanzar;
    private boolean vive;
    private double ms;

    public admBarra(JProgressBar barra, double ms) {
        this.barra = barra;
        avanzar=true;
        vive=true;
        barra.setMaximum((int)ms/10);
    }

    public double getMs() {
        return ms;
    }

    public void setMs(double ms) {
        this.ms = ms;
    }
    
    public boolean isVive() {
        return vive;
    }

    public void setVive(boolean vive) {
        this.vive = vive;
    }


    public boolean isAvanzar() {
        return avanzar;
    }

    public void setAvanzar(boolean avanzar) {
        this.avanzar = avanzar;
    }


    public JProgressBar getBarra() {
        return barra;
    }

    public void setBarra(JProgressBar barra) {
        this.barra = barra;
    }
    
    @Override
    public void run(){
        while(barra.getValue()!=barra.getMaximum()){
            barra.setValue(barra.getValue()+1);
            
            try {
                Thread.sleep(1000);//Para que se detenga la barra cuando le diga que se detenga
                    
            } catch (InterruptedException ex) {
            }
            
        }
        barra.setValue(0);
    }
}
