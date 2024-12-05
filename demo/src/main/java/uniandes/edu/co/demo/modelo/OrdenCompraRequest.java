package uniandes.edu.co.demo.modelo;

import java.sql.Date;
import java.util.List;

import org.bson.types.ObjectId;

public class OrdenCompraRequest {
    private ObjectId sucursalId;
    private ObjectId proveedorId;
    private Date fecha_entrega;
    private List<ObjectId> productos;
    private List<Integer> cantidades;
    private List<Integer> precios;
    public ObjectId getSucursalId() {
        return sucursalId;
    }
    public void setSucursalId(ObjectId sucursalId) {
        this.sucursalId = sucursalId;
    }
    public ObjectId getProveedorId() {
        return proveedorId;
    }
    public void setProveedorId(ObjectId proveedorId) {
        this.proveedorId = proveedorId;
    }
    public Date getFecha_entrega() {
        return fecha_entrega;
    }
    public void setFecha_entrega(Date fecha_entrega) {
        this.fecha_entrega = fecha_entrega;
    }
    public List<ObjectId> getProductos() {
        return productos;
    }
    public void setProductos(List<ObjectId> productos) {
        this.productos = productos;
    }
    public List<Integer> getCantidades() {
        return cantidades;
    }
    public void setCantidades(List<Integer> cantidades) {
        this.cantidades = cantidades;
    }
    public List<Integer> getPrecios() {
        return precios;
    }
    public void setPrecios(List<Integer> precios) {
        this.precios = precios;
    }
    
    // Getters y setters

    
}

