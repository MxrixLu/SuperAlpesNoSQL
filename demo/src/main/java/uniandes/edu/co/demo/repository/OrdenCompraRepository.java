package uniandes.edu.co.demo.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.demo.modelo.OrdenCompra;

public interface OrdenCompraRepository extends JpaRepository<OrdenCompra, Integer> {

    // Obtener todas las órdenes de compra
    @Query(value = "SELECT * FROM ordenes_compra", nativeQuery = true)
    Collection<OrdenCompra> darOrdenesCompra();

    // Obtener una orden de compra por su ID
    @Query(value = "SELECT * FROM ordenes_compra WHERE id = :id", nativeQuery = true)
    OrdenCompra darOrdenCompra(@Param("id") int id);

    // Insertar una nueva orden de compra
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO ordenes_compra (id, fecha_esperada_entrega, precio_acordado, estado, fecha_creacion, sucursal_id, proveedor_id) VALUES (superandes_sequence.nextval, TO_DATE(:fechaEsperadaEntrega, 'YYYY-MM-DD'), :precio_acordado, :estado, TO_DATE(:fechaCreacion, 'YYYY-MM-DD'), :sucursal_id, :proveedor_id)", nativeQuery = true)
    void insertarOrdenCompra(@Param("fechaEsperadaEntrega") String fechaEsperadaEntrega,
                            @Param("precio_acordado") Double precio_acordado,
                            @Param("estado") String estado,
                            @Param("fechaCreacion") String fechaCreacion,
                            @Param("sucursal_id") int sucursal,
                            @Param("proveedor_id") int proveedor);

    // Actualizar una orden de compra existente
    @Modifying
    @Transactional
    @Query(value = "UPDATE ordenes_compra SET fecha_esperada_entrega = TO_DATE(:fechaEsperadaEntrega , 'YYYY-MM-DD'), precio_acordado = :precio_acordado , estado = :estado , fecha_creacion = TO_DATE(:fechaCreacion , 'YYYY-MM-DD'), sucursal_id = :sucursal_id , proveedor_id = :proveedor_id WHERE id = :id ", nativeQuery = true)
    void actualizarOrdenCompra(@Param("id") int id,
                            @Param("fechaEsperadaEntrega") String fechaEsperadaEntrega,
                            @Param("precio_acordado") Double precio_acordado,
                            @Param("estado") String estado,
                            @Param("fechaCreacion") String fechaCreacion,
                            @Param("sucursal_id") int sucursal,
                            @Param("proveedor_id") int proveedor);

    @Modifying
    @Transactional
    @Query(value = "UPDATE ordenes_compra SET estado = :estado WHERE id = :id", nativeQuery = true)
    void actualizarEstadoOrdenCompra(@Param("id") int id, @Param("estado") String estado);
    
    // Borrar una orden de compra por su ID
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM ordenes_compra WHERE id = :id", nativeQuery = true)
    void borrarOrdenCompra(@Param("id") int id);
}