package uniandes.edu.co.demo.repository;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.demo.modelo.InfoRecepcion;
import uniandes.edu.co.demo.modelo.InfoRecepcionPK;
import uniandes.edu.co.demo.modelo.Recepcion;
import uniandes.edu.co.demo.modelo.Producto;

public interface InfoRecepcionRepository extends JpaRepository<InfoRecepcion, InfoRecepcionPK> {

    // Obtener todas las entradas de recepción
    @Query(value = "SELECT * FROM info_recepcion", nativeQuery = true)
    Collection<InfoRecepcion> darInfoRecepcion();

    // Obtener una entrada de recepción por su clave primaria compuesta
    @Query(value = "SELECT * FROM info_recepcion WHERE recepcion_id = :recepcion_id AND producto_id = :producto_id ", nativeQuery = true)
    InfoRecepcion darInfoRecepcionPorId(@Param("recepcion_id") int recepcion_id, @Param("producto_id") int producto_id);

    // Insertar una nueva entrada de recepción
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO info_recepcion (recepcion_id, producto_id, cantidad_recibida, costo_recibido) VALUES (:recepcion_id, :producto_id, :cantidad_recibida, :costo_recibido)", nativeQuery = true)
    void insertarInfoRecepcion(@Param("recepcion_id") int recepcion_id, 
                               @Param("producto_id") int producto_id, 
                               @Param("cantidad_recibida") int cantidad_recibida, 
                               @Param("costo_recibido") Double costo_recibido);

    // Actualizar una entrada de recepción existente
    @Modifying
    @Transactional
    @Query(value = "UPDATE info_recepcion SET cantidad_recibida = :cantidad_recibida, costo_recibido = :costo_recibido WHERE recepcion_id = :recepcion_id AND producto_id = :producto_id", nativeQuery = true)
    void actualizarInfoRecepcion(@Param("recepcion_id") Recepcion recepcion_id, 
                                  @Param("producto_id") Producto producto_id, 
                                  @Param("cantidad_recibida") int cantidad_recibida, 
                                  @Param("costo_recibido") Double costo_recibido);

    // Borrar una entrada de recepción por su clave primaria compuesta
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM info_recepcion WHERE recepcion_id = :recepcion_id AND producto_id = :producto_id", nativeQuery = true)
    void borrarInfoRecepcion(@Param("recepcion_id") Recepcion recepcion_id, @Param("producto_id") Producto producto_id);
}