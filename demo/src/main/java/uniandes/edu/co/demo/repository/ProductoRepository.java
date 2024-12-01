package uniandes.edu.co.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;

import uniandes.edu.co.demo.modelo.Especificaciones;
import uniandes.edu.co.demo.modelo.Producto;

public interface ProductoRepository  extends MongoRepository<Producto, Integer>{

    // Crear un nuevo bar
    @Query("{$insert: {  codigo_barras: ?0, nombre: ?1, costo_bodega: ?2, precio_venta: ?3, presentacion: ?4, cantidad_presentacion: ?5, unidad_medida: ?6, especificaciones: ?7, fecha_expiracion: ?8, categoria: ?9}}")
    void insertarProducto( String codigo_barras, String nombre, Double costo_bodega, Double precio_venta, String presentacion, Double cantidad_presentacion, int unidad_medida, Especificaciones especificaciones, String fecha_expiracion, String categoria);

    @Query("{codigo_barras: ?0}")
    @Update("{ $set: {nombre: ?1, costo_bodega: ?2, precio_venta: ?3, presentacion: ?4, cantidad_presentacion: ?5, unidad_medida: ?6, especificaciones: ?7, fecha_expiracion: ?8, categoria: ?9}}")
    Producto actualizarProductoCodigo(String codigo_barras, String nombre, Double costo_bodega, Double precio_venta, String presentacion, Double cantidad_presentacion, int unidad_medida, Especificaciones especificaciones, String fecha_expiracion, String categoria);
    
    @Query("{codigo_barras: ?0}")
    Producto obtenerProductoPorCodigo(String codigo_barras);

    @Query("{nombre: ?0}")
    Producto obtenerProductoPorNombre(String nombre);
}
