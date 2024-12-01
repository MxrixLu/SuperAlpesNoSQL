package uniandes.edu.co.demo.modelo;

public class Especificaciones {

    
    private Double volumen_empaque; 
    private Double peso_empaque; 

    public Especificaciones(Double volumen_empaque, Double peso_empaque) {
        this.volumen_empaque = volumen_empaque;
        this.peso_empaque = peso_empaque;
    }

    public Double getVolumenEmpaque() {
        return volumen_empaque;
    }

    public void setVolumenEmpaque(Double volumen_empaque) {
        this.volumen_empaque = volumen_empaque;
    }

    public Double getPesoEmpaque() {
        return peso_empaque;
    }

    public void setPesoEmpaque(Double peso_empaque) {
        this.peso_empaque = peso_empaque;
    }

}
