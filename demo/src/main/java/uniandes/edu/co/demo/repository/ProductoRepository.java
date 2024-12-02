package uniandes.edu.co.demo.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;
import org.springframework.stereotype.Repository;

import uniandes.edu.co.demo.modelo.especificacion_empaque;
import uniandes.edu.co.demo.modelo.Producto;

@Repository
public interface ProductoRepository  extends MongoRepository<Producto, ObjectId>{

    // Crear un nuevo bar
    default void insertarProducto(String codigo_barras, String nombre, Double costo_bodega, Double precio_unitario, String presentacion, Double cantidad_presentacion, String unidad_medida, especificacion_empaque especificacion_empaque, String fecha_expiracion, ObjectId categoria_id){
        Producto producto = new Producto();
        producto.setCodigoBarras(codigo_barras);
        producto.setNombre(nombre);
        producto.setCostoBodega(costo_bodega);
        producto.setprecio_unitario(precio_unitario);
        producto.setPresentacion(presentacion);
        producto.setCantidadPresentacion(cantidad_presentacion);
        producto.setUnidadMedida(unidad_medida);
        producto.setespecificacion_empaque(especificacion_empaque);
        producto.setFechaExpiracion(fecha_expiracion);
        producto.setCategoria_id(categoria_id);
        save(producto);
    }

    @Query("{'codigo': ?0}")
    @Update("{ $set: {nombre: ?1, costo_bodega: ?2, precio_unitario: ?3, presentacion: ?4, cantidad_presentacion: ?5, unidad_medida: ?6, especificacion_empaque: ?7, fecha_expiracion: ?8, categoria_id: ?9}}")
    void actualizarProductoCodigo(String codigo_barras, String nombre, Double costo_bodega, Double precio_unitario, String presentacion, Double cantidad_presentacion, String unidad_medida, especificacion_empaque especificacion_empaque, String fecha_expiracion, ObjectId categoria_id);
    
    @Query("{'codigo': ?0}")
    Producto obtenerProductoPorCodigo(String codigo_barras);

    @Query("{'nombre': ?0}")
    Producto obtenerProductoPorNombre(String nombre);
}
