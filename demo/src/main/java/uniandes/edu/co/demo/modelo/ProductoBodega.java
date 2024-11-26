package uniandes.edu.co.demo.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "producto_bodega")
public class ProductoBodega {
    
    @EmbeddedId
    private ProductoBodegaPK pk;

    private int cantidad_existente;
    private Double costo_promedio;

    private int capacidad_bodega;


    public ProductoBodega( Producto id_Producto, Bodega id_Bodega, int cantidad_existente, Double costo_promedio, int capacidad_bodega) {
        this.pk = new ProductoBodegaPK( id_Producto, id_Bodega);
        this.cantidad_existente = cantidad_existente;
        this.costo_promedio = costo_promedio;
        this.capacidad_bodega = capacidad_bodega;
    }
    public ProductoBodega()
    {;}
    public int getCapacidadBodega() {
        return capacidad_bodega;
    }
    public void setCapacidadBodega(int capacidad_bodega) {
        this.capacidad_bodega = capacidad_bodega;
    }
    public ProductoBodegaPK getPk() {
        return pk;
    }
    public void setPk(ProductoBodegaPK pk) {
        this.pk = pk;
    }
    public int getCantidadExistente() {
        return cantidad_existente;
    }
    public void setCantidadExistente(int cantidad_existente) {
        this.cantidad_existente = cantidad_existente;
    }
    public Double getCostoPromedio() {
        return costo_promedio;
    }
    public void setCostoPromedio(Double costo_promedio) {
        this.costo_promedio = costo_promedio;
    }

    
}