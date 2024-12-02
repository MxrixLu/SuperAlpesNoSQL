package uniandes.edu.co.demo.modelo;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import org.bson.types.ObjectId;

import lombok.ToString;

@Document(collection="ordenes_compra")
@ToString
public class OrdenCompra {

    
    @Id
    private ObjectId id;
    private Date fecha_creacion;
    private Date fecha_entrega; 
    private Double precio_acordado;
    private String estado; 
    private int sucursal_id;
    private int proveedor_id;
    private List<DetalleOrdenCompra> detallesOrdenCompra;

    public OrdenCompra(ObjectId id, Date fechaEsperadaEntrega, Double precio_acordado, String estado, Date fecha_creacion,
    int sucursal, int proveedor) {
        this.id = id;
        this.fecha_entrega = fechaEsperadaEntrega;
        this.precio_acordado = precio_acordado;
        this.estado = estado;
        this.fecha_creacion = fecha_creacion;
        this.sucursal_id = sucursal;
        this.proveedor_id = proveedor;
    }

    public OrdenCompra() 
    {;}

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public Date getFechaEsperadaEntrega() {
        return fecha_entrega;
    }

    public void setFechaEsperadaEntrega(Date fechaEsperadaEntrega) {
        this.fecha_entrega = fechaEsperadaEntrega;
    }

    public Double getPrecioAcordado() {
        return precio_acordado;
    }

    public void setPrecioAcordado(Double precio_acordado) {
        this.precio_acordado = precio_acordado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaCreacion() {
        return fecha_creacion;
    }

    public void setFechaCreacion(Date fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public int getSucursal() {
        return sucursal_id;
    }

    public void setSucursal(int sucursal) {
        this.sucursal_id = sucursal;
    }

    public int getProveedor() {
        return proveedor_id;
    }

    public void setProveedor(int proveedor) {
        this.proveedor_id = proveedor;
    }

    public List<DetalleOrdenCompra> getDetallesOrdenCompra() {
        return detallesOrdenCompra;
    }

    public void setDetallesOrdenCompra(List<DetalleOrdenCompra> detallesOrdenCompra) {
        this.detallesOrdenCompra = detallesOrdenCompra;
    }
}
