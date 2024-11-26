package uniandes.edu.co.demo.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "categorias")
public class Categoria {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    private int codigo;

    @Column(nullable = false) 
    private String nombre; 
    private String descripcion;
    private String caracteristicas_almacenamiento;

    public Categoria(int id, int codigo, String nombre, String descripcion,
            String caracteristicas_almacenamiento) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.caracteristicas_almacenamiento = caracteristicas_almacenamiento;
    }

    public Categoria() 
    {;}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCaracteristicasAlmacenamiento() {
        return caracteristicas_almacenamiento;
    }

    public void setCaracteristicasAlmacenamiento(String caracteristicas_almacenamiento) {
        this.caracteristicas_almacenamiento = caracteristicas_almacenamiento;
    }

    
    
}