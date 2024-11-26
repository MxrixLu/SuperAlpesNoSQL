package uniandes.edu.co.demo.repository;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.demo.modelo.Venta;
import uniandes.edu.co.demo.modelo.Cliente;
import uniandes.edu.co.demo.modelo.Producto;

public interface VentaRepository extends JpaRepository<Venta, Integer> {

    // Obtener todas las ventas
    @Query(value = "SELECT * FROM ventas", nativeQuery = true)
    Collection<Venta> darVentas();

    // Obtener una venta por su ID
    @Query(value = "SELECT * FROM ventas WHERE id = :id", nativeQuery = true)
    Venta darVenta(@Param("id") int id);

    // Insertar una nueva venta
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO ventas (id, fecha, cantidad, precio_unitario, cedula, cliente_id, producto_id) VALUES (:id, TO_DATE(:fecha, 'YYYY-MM-DD'), :cantidad, :precio_unitario, :cedula, :cliente_id, :producto_id)", nativeQuery = true)
    void insertarVenta(@Param("id") int id, 
                       @Param("fecha") String fecha, 
                       @Param("cantidad") int cantidad, 
                       @Param("precio_unitario") int precio_unitario, 
                       @Param("cedula") int cedula, 
                       @Param("cliente_id") Cliente cliente, 
                       @Param("producto_id") Producto producto);

    // Actualizar una venta existente
    @Modifying
    @Transactional
    @Query(value = "UPDATE ventas SET fecha = :fecha, cantidad = :cantidad, precio_unitario = :precio_unitario, cedula = :cedula, cliente_id = :cliente_id, producto_id = :producto_id WHERE id = :id", nativeQuery = true)
    void actualizarVenta(@Param("id") int id, 
                         @Param("fecha") String fecha, 
                         @Param("cantidad") int cantidad, 
                         @Param("precio_unitario") int precio_unitario, 
                         @Param("cedula") int cedula, 
                         @Param("cliente_id") Cliente cliente, 
                         @Param("producto_id") Producto producto);

    // Borrar una venta por su ID
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM ventas WHERE id = :id", nativeQuery = true)
    void borrarVenta(@Param("id") int id);
}
