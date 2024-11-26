package uniandes.edu.co.demo.modelo;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
 
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ventas")
public class Venta {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String fecha; 
    private int cantidad; 
    private int precio_unitario;
    private int cedula; 

    @ManyToOne
    private Cliente cliente;

    @ManyToOne
    private Producto producto;

    public Venta(int id, String fecha, int cantidad, int precio_unitario, int cedula, Cliente cliente,
            Producto producto) {
        this.id = id;
        this.fecha = fecha;
        this.cantidad = cantidad;
        this.precio_unitario = precio_unitario;
        this.cedula = cedula;
        this.cliente = cliente;
        this.producto = producto;
    }

    public Venta() 
    {;}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getPrecioUnitario() {
        return precio_unitario;
    }

    public void setPrecioUnitario(int precio_unitario) {
        this.precio_unitario = precio_unitario;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    
}
