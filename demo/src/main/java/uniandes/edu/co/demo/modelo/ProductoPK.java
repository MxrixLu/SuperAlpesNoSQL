package uniandes.edu.co.demo.modelo;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Embeddable
public class ProductoPK implements Serializable {
    
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    private String codigo_barras;

    public ProductoPK(int id, String codigo_barras) {
        this.id = id;
        this.codigo_barras = codigo_barras;
    }

    public ProductoPK() 
    {;}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigoBarras() {
        return codigo_barras;
    }

    public void setCodigoBarras(String codigo_barras) {
        this.codigo_barras = codigo_barras;
    }

    
}