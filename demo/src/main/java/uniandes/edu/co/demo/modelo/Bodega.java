package uniandes.edu.co.demo.modelo;

import org.springframework.data.annotation.Id;

import lombok.ToString;

@ToString
public class Bodega {

    @Id
    private int id;
    private String nombre;
    private Double tamano;

    public Bodega(int id, String nombre, Double tamano) {
        this.id = id;
        this.nombre = nombre;
        this.tamano = tamano;
    }

    
    public Bodega() 
    {;}
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getTamano() {
        return tamano;
    }

    public void setTamano(Double tamano) {
        this.tamano = tamano;
    }


}