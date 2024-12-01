package uniandes.edu.co.demo.modelo;

import java.util.List;

import org.springframework.data.annotation.Id;

import lombok.ToString;

@ToString
public class Bodega {

    @Id
    private int id;
    private String nombre;
    private Double tamano;
    private List<ProductoBodega> productos;

    public Bodega(int id, String nombre, Double tamano, List<ProductoBodega> productos) {
        this.id = id;
        this.nombre = nombre;
        this.tamano = tamano;
        this.productos = productos;
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

    public List<ProductoBodega> getProductos() {
        return productos;
    }

    public void setProductos(List<ProductoBodega> productos) {
        this.productos = productos;
    }
}