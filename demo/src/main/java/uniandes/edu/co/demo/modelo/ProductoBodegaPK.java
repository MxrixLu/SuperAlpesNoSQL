package uniandes.edu.co.demo.modelo;

import java.io.Serializable;
import jakarta.persistence.Embeddable;
 
import jakarta.persistence.ManyToOne;

@Embeddable
public class ProductoBodegaPK implements Serializable {
    
    @ManyToOne
    private Producto producto;

    @ManyToOne
    private Bodega bodega;

    public ProductoBodegaPK(Producto producto, Bodega bodega) {
        this.producto = producto;
        this.bodega = bodega;
    }

    public ProductoBodegaPK() {
    }

    public Producto getId_producto() {
        return producto;
    }

    public void setId_producto(Producto producto) {
        this.producto = producto;
    }

    public Bodega getId_bodega() {
        return bodega;
    }

    public void setId_bodega(Bodega bodega) {
        this.bodega = bodega;
    }

    
}