package uniandes.edu.co.demo.modelo;

import java.util.List;

public class InventarioSucursal {
    private String nombreBodega;
    private List<ProductoBodega> productos;

    public InventarioSucursal(String nombreBodega, List<ProductoBodega> productos) {
        this.nombreBodega = nombreBodega;
        this.productos = productos;
    }

    public InventarioSucursal() {
    }

    public String getNombreBodega() {
        return nombreBodega;
    }

    public void setNombreBodega(String nombreBodega) {
        this.nombreBodega = nombreBodega;
    }

    public List<ProductoBodega> getProductos() {
        return productos;
    }

    public void setProductos(List<ProductoBodega> productos) {
        this.productos = productos;
    }

    
}
