package uniandes.edu.co.demo.modelo;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
 
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "recepciones")
public class Recepcion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String fecha_recepcion;

    @ManyToOne
    private Proveedor proveedor;

    @ManyToOne
    private Bodega bodega;

    public Recepcion(int id, String fecha_recepcion, Proveedor proveedor, Bodega bodega) {
        this.id = id;
        this.fecha_recepcion = fecha_recepcion;
        this.proveedor = proveedor;
        this.bodega = bodega;
    }

    public Recepcion() {
    ;}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFechaRecepcion() {
        return fecha_recepcion;
    }

    public void setFechaRecepcion(String fecha_recepcion) {
        this.fecha_recepcion = fecha_recepcion;
    }

    public Proveedor getId_proveedor() {
        return proveedor;
    }

    public void setId_proveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public Bodega getId_bodega() {
        return bodega;
    }

    public void setId_bodega(Bodega bodega) {
        this.bodega = bodega;
    }

    
}