package uniandes.edu.co.demo.repository;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.demo.modelo.Ciudad;

public interface CiudadRepository extends JpaRepository<Ciudad, Integer> {

    // Obtener todas las ciudades
    @Query(value= "SELECT * FROM ciudades", nativeQuery = true)
    Collection<Ciudad> darCiudades();

    // Obtener una ciudad por su ID
    @Query(value= "SELECT * FROM ciudades WHERE id = :id", nativeQuery = true)
    Ciudad darCiudad(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value= "INSERT INTO CIUDADES (id, codigo, nombre) VALUES (superandes_sequence.nextval, :codigo, :nombre)", nativeQuery = true)
    void insertarCiudad(@Param("codigo") int codigo, @Param("nombre") String nombre);

    @Modifying
    @Transactional
    @Query(value = "UPDATE ciudades SET codigo = :codigo, nombre = :nombre WHERE id = :id", nativeQuery = true)
    void actualizarCiudad(@Param("id") int id, @Param("codigo") int codigo, @Param("nombre") String nombre);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM ciudades WHERE id = :id", nativeQuery = true)
    void borrarCiudad(@Param("id") int id);
}
