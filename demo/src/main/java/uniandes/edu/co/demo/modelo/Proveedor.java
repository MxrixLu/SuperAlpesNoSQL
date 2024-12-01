package uniandes.edu.co.demo.modelo;


import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.ToString;


@Document(collection="proveedores")
@ToString
public class Proveedor {

    @Id
    private int id;

    private String NIT; 
    private String direccion;
    private Contacto contacto;
    private List<String> productos;

    public Proveedor(int id, String nIT, String direccion, Contacto contacto, List<String> productos) {
        this.id = id;
        this.NIT = nIT;
        this.direccion = direccion;
        this.contacto = contacto;
        this.productos = productos;
    } 
    
    public Proveedor() 
    {;}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNIT() {
        return NIT;
    }

    public void setNIT(String nIT) {
        this.NIT = nIT;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Contacto getContacto() {
        return contacto;
    }

    public void setContacto(Contacto contacto) {
        this.contacto = contacto;
    }

    public List<String> getProductos() {
        return productos;
    }

    public void setProductos(List<String> productos) {
        this.productos = productos;
    }
    
}
