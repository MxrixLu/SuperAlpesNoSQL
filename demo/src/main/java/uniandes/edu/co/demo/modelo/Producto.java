package uniandes.edu.co.demo.modelo;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.ToString;


@Document(collection="productos")
@ToString
public class Producto {

    @Id
    private int id;

    private String codigo_barras;
    private String nombre; 
    private Double costo_bodega; 
    private Double precio_venta; 
    private String presentacion; 
    private Double cantidad_presentacion; 
    private int unidad_medida;
    private Especificaciones especificaciones;
    private String fecha_expiracion; 
    private String categoria;

    public Producto(int id, String codigo_barras, String nombre, Double costo_bodega, Double precio_venta, String presentacion,
            Double cantidad_presentacion, int unidad_medida, Especificaciones especificaciones,
            String fecha_expiracion, String categoria) {
        this.id = id;
        this.codigo_barras = codigo_barras;
        this.nombre = nombre;
        this.costo_bodega = costo_bodega;
        this.precio_venta = precio_venta;
        this.presentacion = presentacion;
        this.especificaciones = especificaciones;
        this.cantidad_presentacion = cantidad_presentacion;
        this.unidad_medida = unidad_medida;
        this.fecha_expiracion = fecha_expiracion;
        this.categoria = categoria;
    }

    public Producto() 
    {;}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigoBarras() {
        return codigo_barras;
    }

    public void setCodigoBarras(String codigo_barras) {
        this.codigo_barras = codigo_barras;
    }
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getCostoBodega() {
        return costo_bodega;
    }

    public void setCostoBodega(Double costo_bodega) {
        this.costo_bodega = costo_bodega;
    }

    public Double getPrecioVenta() {
        return precio_venta;
    }

    public void setPrecioVenta(Double precio_venta) {
        this.precio_venta = precio_venta;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    public Especificaciones getEspecificaciones() {
        return especificaciones;
    }

    public void setEspecificaciones(Especificaciones especificaciones) {
        this.especificaciones = especificaciones;
    }

    public Double getCantidadPresentacion() {
        return cantidad_presentacion;
    }

    public void setCantidadPresentacion(Double cantidad_presentacion) {
        this.cantidad_presentacion = cantidad_presentacion;
    }

    public int getUnidadMedida() {
        return unidad_medida;
    }

    public void setUnidadMedida(int unidad_medida) {
        this.unidad_medida = unidad_medida;
    }

    
    public String getFechaExpiracion() {
        return fecha_expiracion;
    }

    public void setFechaExpiracion(String fecha_expiracion) {
        this.fecha_expiracion = fecha_expiracion;
    }

    public String getString() {
        return categoria;
    }

    public void setString(String categoria) {
        this.categoria = categoria;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }


}
