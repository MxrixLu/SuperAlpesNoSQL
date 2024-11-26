package uniandes.edu.co.demo.modelo;

import java.io.Serializable;
import jakarta.persistence.Embeddable;
 
import jakarta.persistence.ManyToOne;

@Embeddable
public class ProductoOrdenPK implements Serializable {
    
    @ManyToOne
    private Producto producto;

    @ManyToOne
    private OrdenCompra orden_compra;

    public ProductoOrdenPK(Producto producto, OrdenCompra orden_compra) {
        this.producto = producto;
        this.orden_compra = orden_compra;
    }

    public ProductoOrdenPK() {
    }

    public Producto getId_producto() {
        return producto;
    }

    public void setId_producto(Producto producto) {
        this.producto = producto;
    }

    public OrdenCompra getId_ordenCompra() {
        return orden_compra;
    }

    public void setId_ordenCompra(OrdenCompra orden_compra) {
        this.orden_compra = orden_compra;
    }

    

}