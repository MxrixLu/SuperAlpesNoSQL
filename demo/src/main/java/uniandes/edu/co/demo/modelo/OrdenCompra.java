package uniandes.edu.co.demo.modelo;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
 
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Entity
@Table(name = "ordenes_compra")
public class OrdenCompra {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String fechaEsperadaEntrega; 
    private Double precio_acordado;
    private String estado; 
    private String fechaCreacion; 

    @ManyToOne
    private Sucursal sucursal;

    @ManyToOne
    private Proveedor proveedor;

    public OrdenCompra(int id, String fechaEsperadaEntrega, Double precio_acordado, String estado, String fechaCreacion,
            Sucursal sucursal, Proveedor proveedor) {
        this.id = id;
        this.fechaEsperadaEntrega = fechaEsperadaEntrega;
        this.precio_acordado = precio_acordado;
        this.estado = estado;
        this.fechaCreacion = fechaCreacion;
        this.sucursal = sucursal;
        this.proveedor = proveedor;
    }

    public OrdenCompra() 
    {;}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFechaEsperadaEntrega() {
        return fechaEsperadaEntrega;
    }

    public void setFechaEsperadaEntrega(String fechaEsperadaEntrega) {
        this.fechaEsperadaEntrega = fechaEsperadaEntrega;
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

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    
}