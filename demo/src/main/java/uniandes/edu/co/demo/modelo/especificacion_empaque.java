package uniandes.edu.co.demo.modelo;

public class especificacion_empaque {

    
    private Double volumen; 
    private Double peso; 

    public especificacion_empaque(Double volumen, Double peso) {
        this.volumen = volumen;
        this.peso = peso;
    }

    public Double getVolumenEmpaque() {
        return volumen;
    }

    public void setVolumenEmpaque(Double volumen) {
        this.volumen = volumen;
    }

    public Double getPesoEmpaque() {
        return peso;
    }

    public void setPesoEmpaque(Double peso) {
        this.peso = peso;
    }

}
