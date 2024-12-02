package uniandes.edu.co.demo.modelo;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import lombok.ToString;

@ToString
public class Bodega {

    @Id
    private ObjectId bodega_id;
    private String nombre;
    private Double tamaño;
    private List<ProductoBodega> productos;

    public Bodega(ObjectId bodega_id, String nombre, Double tamaño, List<ProductoBodega> productos) {
        this.bodega_id = bodega_id;
        this.nombre = nombre;
        this.tamaño = tamaño;
        this.productos = productos;
    }

    
    public Bodega() 
    {;}
    
    public ObjectId getBodega_id() {
        return bodega_id;
    }

    public void setBodega_id(ObjectId bodega_id) {
        this.bodega_id = bodega_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getTamaño() {
        return tamaño;
    }

    public void setTamaño(Double tamaño) {
        this.tamaño = tamaño;
    }

    public List<ProductoBodega> getProductos() {
        return productos;
    }

    public void setProductos(List<ProductoBodega> productos) {
        this.productos = productos;
    }
}