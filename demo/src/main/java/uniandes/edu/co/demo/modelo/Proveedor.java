package uniandes.edu.co.demo.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "proveedores")
public class Proveedor {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String NIT; 
    private String direccion;
    private String nombre_personac;
    private String telefono_personac;

    public Proveedor(int id, String nIT, String direccion, String nombre_personac, String telefono_personac) {
        this.id = id;
        this.NIT = nIT;
        this.direccion = direccion;
        this.nombre_personac = nombre_personac;
        this.telefono_personac = telefono_personac;
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

    public String getNombrePersonaC() {
        return nombre_personac;
    }

    public void setNombrePersonaC(String nombre_personac) {
        this.nombre_personac = nombre_personac;
    }

    public String getTelefonoPersonaC() {
        return telefono_personac;
    }

    public void setTelefonoPersonaC(String telefono_personac) {
        this.telefono_personac = telefono_personac;
    }

    
    
}