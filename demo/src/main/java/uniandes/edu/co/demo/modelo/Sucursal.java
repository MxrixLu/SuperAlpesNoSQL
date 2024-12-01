package uniandes.edu.co.demo.modelo;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.ToString;

@Document(collection="sucursales")
@ToString
public class Sucursal {

    @Id
    private int id;

    private String nombre; 
    private String telefono; 
    private String direccion;
    private Double tamano; 
    private String ciudad;
    private List<Bodega> bodegas;

    public Sucursal(int id, String nombre, String telefono, String direccion, Double tamano, String ciudad, List<Bodega> bodegas) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.tamano = tamano;
        this.ciudad = ciudad;
        this.bodegas = bodegas;
    }

    public Sucursal() {;}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Double getTamano() {
        return tamano;
    }

    public void setTamano(Double tamano) {
        this.tamano = tamano;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad_id) {
        this.ciudad = ciudad_id;
    }

    public List<Bodega> getBodegas() {
        return bodegas;
    }

    public void setBodegas(List<Bodega> bodegas) {
        this.bodegas = bodegas;
    }
}
