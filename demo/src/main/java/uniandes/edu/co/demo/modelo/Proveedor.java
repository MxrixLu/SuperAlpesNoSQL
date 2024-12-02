package uniandes.edu.co.demo.modelo;

import org.bson.types.ObjectId;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.ToString;


@Document(collection="proveedores")
@ToString
public class Proveedor {

    @Id
    private ObjectId id;

    private String nit; 
    private String nombre;
    private String direccion;
    private Contacto contacto;
    private List<ObjectId> productos_suministrados;

    public Proveedor(ObjectId id, String nit, String nombre,  String direccion, Contacto contacto, List<ObjectId> productos_suministrados) {
        this.id = id;
        this.nombre = nombre;
        this.nit = nit;
        this.direccion = direccion;
        this.contacto = contacto;
        this.productos_suministrados = productos_suministrados;
    } 
    
    public Proveedor() 
    {;}

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
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

    public List<ObjectId> getProductos_suministrados() {
        return productos_suministrados;
    }

    public void setProductos_suministrados(List<ObjectId> productos_suministrados) {
        this.productos_suministrados = productos_suministrados;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
