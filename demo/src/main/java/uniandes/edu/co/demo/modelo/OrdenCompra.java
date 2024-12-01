package uniandes.edu.co.demo.modelo;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.ToString;

@Document(collection="ordenes_compra")
@ToString
public class OrdenCompra {

    
    @Id
    private int id;
    private Date fecha_creacion;
    private Date fecha_entrega; 
    private Double precio_acordado;
    private String estado; 
    private String sucursal_id;
    private String proveedor_id;
    private List<DetalleOrdenCompra> detallesOrdenCompra;

    public OrdenCompra(int id, Date fechaEsperadaEntrega, Double precio_acordado, String estado, Date fecha_creacion,
    String sucursal, String proveedor) {
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getSucursal() {
        return sucursal_id;
    }

    public void setSucursal(String sucursal) {
        this.sucursal_id = sucursal;
    }

    public String getProveedor() {
        return proveedor_id;
    }

    public void setProveedor(String proveedor) {
        this.proveedor_id = proveedor;
    }


}
