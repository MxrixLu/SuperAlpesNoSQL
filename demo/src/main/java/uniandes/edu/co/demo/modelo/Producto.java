package uniandes.edu.co.demo.modelo;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.bson.types.ObjectId;


import lombok.ToString;


@Document(collection="productos")
@ToString
public class Producto {

    @Id
    private ObjectId id;

    private String codigo_barras;
    private String nombre; 
    private Double costo_bodega; 
    private Double precio_unitario; 
    private String presentacion; 
    private Double cantidad_presentacion; 
    private String unidad_medida;
    private especificacion_empaque especificacion_empaque;
    private String fecha_expiracion; 
    private ObjectId categoria_id;

    public Producto(ObjectId id, String codigo_barras, String nombre, Double costo_bodega, Double precio_unitario, String presentacion,
            Double cantidad_presentacion, String unidad_medida, especificacion_empaque especificacion_empaque,
            String fecha_expiracion, ObjectId categoria_id) {
        this.id = id;
        this.codigo_barras = codigo_barras;
        this.nombre = nombre;
        this.costo_bodega = costo_bodega;
        this.precio_unitario = precio_unitario;
        this.presentacion = presentacion;
        this.especificacion_empaque = especificacion_empaque;
        this.cantidad_presentacion = cantidad_presentacion;
        this.unidad_medida = unidad_medida;
        this.fecha_expiracion = fecha_expiracion;
        this.categoria_id = categoria_id;
    }

    public Producto() 
    {;}

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getCodigoBarras() {
        return codigo_barras;
    }

    public void setCodigoBarras(String codigo_barras) {
        this.codigo_barras = codigo_barras;
    }
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getCostoBodega() {
        return costo_bodega;
    }

    public void setCostoBodega(Double costo_bodega) {
        this.costo_bodega = costo_bodega;
    }

    public Double getprecio_unitario() {
        return precio_unitario;
    }

    public void setprecio_unitario(Double precio_unitario) {
        this.precio_unitario = precio_unitario;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    public especificacion_empaque getespecificacion_empaque() {
        return especificacion_empaque;
    }

    public void setespecificacion_empaque(especificacion_empaque especificacion_empaque) {
        this.especificacion_empaque = especificacion_empaque;
    }

    public Double getCantidadPresentacion() {
        return cantidad_presentacion;
    }

    public void setCantidadPresentacion(Double cantidad_presentacion) {
        this.cantidad_presentacion = cantidad_presentacion;
    }

    public String getUnidadMedida() {
        return unidad_medida;
    }

    public void setUnidadMedida(String unidad_medida) {
        this.unidad_medida = unidad_medida;
    }

    
    public String getFechaExpiracion() {
        return fecha_expiracion;
    }

    public void setFechaExpiracion(String fecha_expiracion) {
        this.fecha_expiracion = fecha_expiracion;
    }


    public ObjectId getCategoria_id() {
        return categoria_id;
    }

    public void setCategoria_id(ObjectId categoria) {
        this.categoria_id = categoria;
    }


}
