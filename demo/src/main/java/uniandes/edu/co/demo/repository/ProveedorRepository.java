package uniandes.edu.co.demo.repository;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.demo.modelo.Proveedor;

public interface ProveedorRepository extends JpaRepository<Proveedor, Integer> {

    // Obtener todos los proveedores
    @Query(value = "SELECT * FROM proveedores", nativeQuery = true)
    Collection<Proveedor> darProveedores();

    // Obtener un proveedor por su ID
    @Query(value = "SELECT * FROM proveedores WHERE id = :id", nativeQuery = true)
    Proveedor darProveedor(@Param("id") int id);

    // Insertar un nuevo proveedor
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO proveedores (id, NIT, direccion, nombre_personac, telefono_personac) VALUES (superandes_sequence.nextval, :NIT, :direccion, :nombre_personac, :telefono_personac)", nativeQuery = true)
    void insertarProveedor(
                           @Param("NIT") String NIT, 
                           @Param("direccion") String direccion, 
                           @Param("nombre_personac") String nombre_personac, 
                           @Param("telefono_personac") String telefono_personac);

    // Actualizar un proveedor existente
    @Modifying
    @Transactional
    @Query(value = "UPDATE proveedores SET NIT = :NIT, direccion = :direccion, nombre_personac = :nombre_personac, telefono_personac = :telefono_personac WHERE id = :id", nativeQuery = true)
    void actualizarProveedor(@Param("id") int id, 
                             @Param("NIT") String NIT, 
                             @Param("direccion") String direccion, 
                             @Param("nombre_personac") String nombre_personac, 
                             @Param("telefono_personac") String telefono_personac);

    // Borrar un proveedor por su ID
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM proovedores WHERE id = :id", nativeQuery = true)
    void borrarProveedor(@Param("id") int id);
}