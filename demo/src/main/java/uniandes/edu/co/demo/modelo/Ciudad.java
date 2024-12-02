package uniandes.edu.co.demo.modelo;

import org.springframework.data.annotation.Id;
import org.bson.types.ObjectId;


public class Ciudad {

    @Id
    private ObjectId id;

    private int codigo;
    
    private String nombre;

    public Ciudad(ObjectId id, int codigo, String nombre) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public Ciudad() 
    {;}

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
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

}
