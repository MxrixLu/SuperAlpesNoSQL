package uniandes.edu.co.demo.repository;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.demo.modelo.NivelReOrden;
import uniandes.edu.co.demo.modelo.Producto;
import uniandes.edu.co.demo.modelo.Sucursal;

public interface NivelReOrdenRepository extends JpaRepository<NivelReOrden, Integer> {

    // Obtener todos los niveles de reorden
    @Query(value = "SELECT * FROM niveles_reorden", nativeQuery = true)
    Collection<NivelReOrden> darNivelesReOrden();

    // Obtener un nivel de reorden por su ID
    @Query(value = "SELECT * FROM niveles_reorden WHERE id = :id", nativeQuery = true)
    NivelReOrden darNivelReOrden(@Param("id") int id);

    @Query(value = "SELECT * FROM niveles_reorden WHERE producto_id = :producto_id AND sucursal_id = :sucursal_id", nativeQuery = true)
    NivelReOrden darNivelReOrdenProductoSucursal(@Param("producto_id") int producto_id, @Param("sucursal_id") int sucursal_id);

    // Insertar un nuevo nivel de reorden
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO niveles_reorden (id, nivel_minimo, sucursal_id, producto_id) VALUES (superandes_sequence.nextval, :sucursal_id, :producto_id, :nivel_minimo)", nativeQuery = true)
    void insertarNivelReOrden(@Param("nivel_minimo") int nivel_minimo, 
                              @Param("sucursal_id") Sucursal sucursal, 
                              @Param("producto_id") Producto producto);

    // Actualizar un nivel de reorden existente
    @Modifying
    @Transactional
    @Query(value = "UPDATE niveles_reorden SET nivel_minimo = :nivel_minimo, sucursal_id = :sucursal_id, producto_id = :producto_id WHERE id = :id", nativeQuery = true)
    void actualizarNivelReOrden(@Param("id") int id, 
                                @Param("nivel_minimo") int nivel_minimo, 
                                @Param("sucursal_id") Sucursal sucursal, 
                                @Param("producto_id") Producto producto);

    // Borrar un nivel de reorden por su ID
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM niveles_reorden WHERE id = :id", nativeQuery = true)
    void borrarNivelReOrden(@Param("id") int id);
}