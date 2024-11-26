package uniandes.edu.co.demo.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
 
import jakarta.persistence.ManyToOne; 

@Embeddable
public class InfoRecepcionPK implements Serializable {

    @ManyToOne
    private Recepcion recepcion; 

    @ManyToOne
    private Producto producto;

    public InfoRecepcionPK(Recepcion recepcion, Producto producto) {
        super();
        this.recepcion = recepcion;
        this.producto = producto;
    }

    public InfoRecepcionPK() {
        super();
    }

    public Recepcion getRecepcion() {
        return recepcion;
    }

    public void setRecepcion(Recepcion recepcion) {
        this.recepcion = recepcion;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    } 

    
    
}