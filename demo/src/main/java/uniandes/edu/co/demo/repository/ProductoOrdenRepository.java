package uniandes.edu.co.demo.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.demo.modelo.OrdenCompra;
import uniandes.edu.co.demo.modelo.Producto;
import uniandes.edu.co.demo.modelo.ProductoOrden;
import uniandes.edu.co.demo.modelo.ProductoOrdenPK;

public interface ProductoOrdenRepository extends JpaRepository<ProductoOrden, ProductoOrdenPK> {

    // Obtener todos los registros de ProductoOrden
    @Query(value = "SELECT * FROM producto_orden", nativeQuery = true)
    Collection<ProductoOrden> darProductoOrden();

    // Obtener un registro específico de ProductoOrden por su clave primaria compuesta
    @Query(value = "SELECT * FROM producto_orden WHERE producto_id = :producto_id AND orden_compra_id = :orden_compra_id", nativeQuery = true)
    ProductoOrden darProductoOrden(@Param("producto_id") int producto_id, @Param("orden_compra_id") int orden_compra_id);

    // Insertar un nuevo registro de ProductoOrden, utilizando las entidades asociadas
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO producto_orden (producto_id, orden_compra_id, precio_acordado, cantidad_solicitada) VALUES (:producto_id, :orden_compra_id, :precio_acordado, :cantidad_solicitada)", nativeQuery = true)
    void insertarProductoOrden(@Param("producto_id") Producto producto_id,
                               @Param("orden_compra_id") OrdenCompra orden_compra_id,
                               @Param("precio_acordado") Double precio_acordado,
                               @Param("cantidad_solicitada") int cantidad_solicitada);

    // Actualizar un registro existente de ProductoOrden
    @Modifying
    @Transactional
    @Query(value = "UPDATE producto_orden SET precio_acordado = :precio_acordado, cantidad_solicitada = :cantidad_solicitada WHERE producto_id = :producto_id AND orden_compra_id = :orden_compra_id", nativeQuery = true)
    void actualizarProductoOrden(@Param("producto_id") Producto producto_id,
                                 @Param("orden_compra_id") OrdenCompra orden_compra_id,
                                 @Param("precio_acordado") Double precio_acordado,
                                 @Param("cantidad_solicitada") int cantidad_solicitada);

    // Borrar un registro de ProductoOrden por su clave primaria compuesta
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM producto_orden WHERE producto_id = :producto_id AND orden_compra_id = :orden_compra_id", nativeQuery = true)
    void borrarProductoOrden(@Param("producto_id") Producto producto_id, @Param("orden_compra_id") OrdenCompra orden_compra_id);
    
    // Obtener productos en una orden específica
    @Query(value = "SELECT * FROM producto_orden WHERE orden_compra_id = :orden_compra_id ", nativeQuery = true)
    Collection<Integer> darProductosPorOrden(@Param("orden_compra_id") int orden_compra_id);

    // Obtener órdenes que contienen un producto específico
    @Query(value = "SELECT * FROM producto_orden WHERE producto_id = :producto_id", nativeQuery = true)
    Collection<ProductoOrden> darOrdenesPorProducto(@Param("producto_id") Producto producto_id);
}