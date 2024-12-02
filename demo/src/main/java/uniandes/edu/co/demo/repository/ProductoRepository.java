package uniandes.edu.co.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;
import org.springframework.stereotype.Repository;

import uniandes.edu.co.demo.modelo.Especificaciones;
import uniandes.edu.co.demo.modelo.Producto;

@Repository
public interface ProductoRepository  extends MongoRepository<Producto, Integer>{

    // Crear un nuevo bar
    default void insertarProducto(String codigo_barras, String nombre, Double costo_bodega, Double precio_venta, String presentacion, Double cantidad_presentacion, String unidad_medida, Especificaciones especificaciones, String fecha_expiracion, String categoria){
        Producto producto = new Producto();
        producto.setCodigoBarras(codigo_barras);
        producto.setNombre(nombre);
        producto.setCostoBodega(costo_bodega);
        producto.setPrecioVenta(precio_venta);
        producto.setPresentacion(presentacion);
        producto.setCantidadPresentacion(cantidad_presentacion);
        producto.setUnidadMedida(unidad_medida);
        producto.setEspecificaciones(especificaciones);
        producto.setFechaExpiracion(fecha_expiracion);
        producto.setCategoria(categoria);
        save(producto);
    }
    @Query("{'codigo': ?0}")
    @Update("{ $set: {nombre: ?1, costo_bodega: ?2, precio_venta: ?3, presentacion: ?4, cantidad_presentacion: ?5, unidad_medida: ?6, especificaciones: ?7, fecha_expiracion: ?8, categoria: ?9}}")
    void actualizarProductoCodigo(String codigo_barras, String nombre, Double costo_bodega, Double precio_venta, String presentacion, Double cantidad_presentacion, String unidad_medida, Especificaciones especificaciones, String fecha_expiracion, String categoria);
    
    @Query("{'codigo': ?0}")
    Producto obtenerProductoPorCodigo(String codigo_barras);

    @Query("{'nombre': ?0}")
    Producto obtenerProductoPorNombre(String nombre);
}
