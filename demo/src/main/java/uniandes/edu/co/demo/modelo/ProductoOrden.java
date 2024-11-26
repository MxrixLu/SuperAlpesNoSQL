package uniandes.edu.co.demo.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "producto_orden")
public class ProductoOrden {
    
    @EmbeddedId
    private ProductoOrdenPK pk;

    private Double precio_acordado; 

    private int cantidad_solicitada;

    public ProductoOrden(Producto producto, OrdenCompra id_orden, Double precio_acordado, int cantidad_solicitada) {
        this.pk = new ProductoOrdenPK(producto, id_orden);
        this.precio_acordado = precio_acordado;
        this.cantidad_solicitada = cantidad_solicitada;
    }
    
    public ProductoOrden()
    {;}

    public ProductoOrdenPK getPk() {
        return pk;
    }

    public void setPk(ProductoOrdenPK pk) {
        this.pk = pk;
    }

    public Double getPrecioAcordado() {
        return precio_acordado;
    }

    public void setPrecioAcordado(Double precio_acordado) {
        this.precio_acordado = precio_acordado;
    }

    public int getCantidadSolicitada() {
        return cantidad_solicitada;
    }

    public void setCantidadSolicitada(int cantidad_solicitada) {
        this.cantidad_solicitada = cantidad_solicitada;
    }

    
}