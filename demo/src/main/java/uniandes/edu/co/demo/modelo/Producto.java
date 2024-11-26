package uniandes.edu.co.demo.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "productos")
public class Producto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String codigo_barras;

    private String nombre; 
    private Double costo_bodega; 
    private Double precio_venta; 
    private String presentacion; 
    private Double cantidad_presentacion; 
    private int unidad_medida;
    private Double volumen_empaque; 
    private Double peso_empaque; 
    private String fecha_expiracion; 

    @ManyToOne
    private Categoria categoria;

    public Producto(int id, String codigo_barras, String nombre, Double costo_bodega, Double precio_venta, String presentacion,
            Double cantidad_presentacion, int unidad_medida, Double volumen_empaque, Double peso_empaque,
            String fecha_expiracion, Categoria categoria) {
        this.id = id;
        this.codigo_barras = codigo_barras;
        this.nombre = nombre;
        this.costo_bodega = costo_bodega;
        this.precio_venta = precio_venta;
        this.presentacion = presentacion;
        this.cantidad_presentacion = cantidad_presentacion;
        this.unidad_medida = unidad_medida;
        this.volumen_empaque = volumen_empaque;
        this.peso_empaque = peso_empaque;
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

    public Double getVolumenEmpaque() {
        return volumen_empaque;
    }

    public void setVolumenEmpaque(Double volumen_empaque) {
        this.volumen_empaque = volumen_empaque;
    }

    public Double getPesoEmpaque() {
        return peso_empaque;
    }

    public void setPesoEmpaque(Double peso_empaque) {
        this.peso_empaque = peso_empaque;
    }

    public String getFechaExpiracion() {
        return fecha_expiracion;
    }

    public void setFechaExpiracion(String fecha_expiracion) {
        this.fecha_expiracion = fecha_expiracion;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    
}