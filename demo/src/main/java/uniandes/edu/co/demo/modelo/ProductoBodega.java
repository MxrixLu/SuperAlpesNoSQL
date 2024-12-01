package uniandes.edu.co.demo.modelo;

public class ProductoBodega {

    private String nombreProducto;
    private int cantidad;
    private int nivlReorden; 
    private Double costo_promedio;
    private int capacidad_bodega;

    public ProductoBodega(String nombreProducto, int cantidad, int nivlReorden, Double costo_promedio, int capacidad_bodega) {
        this.nombreProducto = nombreProducto;
        this.cantidad = cantidad;
        this.nivlReorden = nivlReorden;
        this.costo_promedio = costo_promedio;
        this.capacidad_bodega = capacidad_bodega;
    }

    public ProductoBodega() {
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getNivlReorden() {
        return nivlReorden;
    }

    public void setNivlReorden(int nivlReorden) {
        this.nivlReorden = nivlReorden;
    }

    public Double getCosto_promedio() {
        return costo_promedio;
    }

    public void setCosto_promedio(Double costo_promedio) {
        this.costo_promedio = costo_promedio;
    }

    public int getCapacidad_bodega() {
        return capacidad_bodega;
    }

    public void setCapacidad_bodega(int capacidad_bodega) {
        this.capacidad_bodega = capacidad_bodega;
    }
    
}
