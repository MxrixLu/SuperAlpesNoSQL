package uniandes.edu.co.demo.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.demo.modelo.Recepcion;

public interface RecepcionRepository extends JpaRepository<Recepcion, Integer> {

    public interface respuestaConsultaIngresoProductoBodega_SERIALIZABLE {
        String getSucursal();
        String getBodega();
        int getNumero_recepcion();
        String getFecha_recepcion();
        String getNombre_proveedor();

    }

    public interface respuestaConsultaIngresoProductoBodega_READ_COMMITTED {
        String getSucursal();
        String getBodega();
        int getNumero_recepcion();
        String getFecha_recepcion();
        String getNombre_proveedor();
    }

    // Obtener todas las recepciones
    @Query(value = "SELECT * FROM recepciones", nativeQuery = true)
    Collection<Recepcion> darRecepciones();

    // Obtener una recepcion por su ID
    @Query(value = "SELECT * FROM recepciones WHERE id = :id", nativeQuery = true)
    Recepcion darRecepcion(@Param("id") int id);

    @Query(value = "SELECT * FROM recepciones WHERE proveedor_id = :proveedor_id AND bodega_id = :bodega_id AND fecha_recepcion = TO_DATE( :fecha_recepcion , 'YYYY-MM-DD')", nativeQuery = true)
    Recepcion darRecepcionHoy(@Param("proveedor_id") int proveedor_id, @Param("bodega_id") int bodega_id, @Param("fecha_recepcion") String fecha_recepcion);

    // Insertar una nueva recepcion
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO recepciones (id, fecha_recepcion, proveedor_id, bodega_id) VALUES (superandes_sequence.nextval, TO_DATE(:fecha_recepcion, 'yyyy-mm-dd'), :proveedor_id, :bodega_id )", nativeQuery = true)
    void insertarRecepcion( 
                           @Param("fecha_recepcion") String fecha_recepcion, 
                           @Param("proveedor_id") int proveedor_id, 
                           @Param("bodega_id") int bodega_id);

    // // Actualizar una recepcion existente
    @Modifying
    @Transactional
    @Query(value = "UPDATE recepciones SET fecha_recepcion = :fecha_recepcion, proveedor_id = :proveedor_id, bodega_id = :bodega_id WHERE id = :id", nativeQuery = true)
    void actualizarRecepcion(@Param("id") int id, 
                             @Param("fecha_recepcion") String fecha_recepcion, 
                             @Param("proveedor_id") int proveedor_id, 
                             @Param("bodega_id") int bodega_id);

    // Borrar una recepcion por su ID
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM recepciones WHERE id = :id", nativeQuery = true)
    void borrarRecepcion(@Param("id") int id);

    //Transacciones
    @Query(value =" SELECT s.nombre AS sucursal, " +
                "b.nombre AS bodega, " +
                "r.id AS Numero_recepcion, " +
                "r.fecha_recepcion AS Fecha_recepcion, " +
                "prov.nombre_personaC AS Nombre_proveedor " +
                "FROM recepciones r " +
                "INNER JOIN bodegas b ON b.id = r.bodega_id " +
                "INNER JOIN sucursales s ON s.id = b.sucursal_id " +
                "INNER JOIN proveedores prov ON prov.id=r.proveedor_id " +
                "WHERE r.fecha_recepcion >= SYSDATE - 30 " +
                "AND s.id = :sucursal_id AND b.id = :bodega_id ", nativeQuery=true)
    Collection<respuestaConsultaIngresoProductoBodega_SERIALIZABLE> consultaIngresoProductoBodega_SERIALIZABLE(@Param("sucursal_id") int sucursal_id, @Param("bodega_id") int bodega_id);

    @Query(value = "SELECT s.nombre AS sucursal, " +
                   "b.nombre AS bodega, " +
                   "r.id AS Numero_recepcion, " +
                   "r.fecha_recepcion AS Fecha_recepcion, " +
                   "prov.nombre_personaC AS Nombre_proveedor " +
                   "FROM recepciones r " +
                   "INNER JOIN bodegas b ON b.id = r.bodega_id " +
                   "INNER JOIN sucursales s ON s.id = b.sucursal_id " +
                   "INNER JOIN proveedores prov ON prov.id = r.proveedor_id " +
                   "WHERE r.fecha_recepcion >= SYSDATE - 30 " +
                   "AND s.id = :sucursal_id " +
                   "AND b.id = :bodega_id", nativeQuery = true)
    Collection<respuestaConsultaIngresoProductoBodega_READ_COMMITTED> consultaIngresoProductoBodega_READ_COMMITTED(
        @Param("sucursal_id") int sucursal_id,
        @Param("bodega_id") int bodega_id
    );
}