package uniandes.edu.co.demo.modelo;

import org.bson.types.ObjectId;

public class DetalleOrdenCompra {
    public ObjectId productoId;
    public int cantidad;
    public int precio_unitario;

    public DetalleOrdenCompra(ObjectId productoId, int cantidad, int precio_unitario) {
        this.productoId = productoId;
        this.cantidad = cantidad;
        this.precio_unitario = precio_unitario;
    }

    public DetalleOrdenCompra() {
    }
    public ObjectId getProductoId() {
        return productoId;
    }
    
    public void setProductoId(ObjectId productoId) {
        this.productoId = productoId;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getprecio_unitario() {
        return precio_unitario;
    }

    public void setprecio_unitario(int precio_unitario) {
        this.precio_unitario = precio_unitario;
    }

}
