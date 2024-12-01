package uniandes.edu.co.demo.modelo;

public class DetalleOrdenCompra {
    public int productoId;
    public int cantidad;
    public int precioUnitario;

    public DetalleOrdenCompra(int productoId, int cantidad, int precioUnitario) {
        this.productoId = productoId;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }

    public DetalleOrdenCompra() {
    }
    public int getProductoId() {
        return productoId;
    }
    
    public void setProductoId(int productoId) {
        this.productoId = productoId;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(int precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

}
