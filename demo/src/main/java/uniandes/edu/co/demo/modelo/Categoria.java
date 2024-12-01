package uniandes.edu.co.demo.modelo;


import org.springframework.data.annotation.Id;

import lombok.ToString;

@ToString
public class Categoria {

    @Id
    private int id;
    private int codigo;
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

    public String getCaracteristicas_almacenamiento() {
        return caracteristicas_almacenamiento;
    }

    public void setCaracteristicas_almacenamiento(String caracteristicas_almacenamiento) {
        this.caracteristicas_almacenamiento = caracteristicas_almacenamiento;
    }

    

}
