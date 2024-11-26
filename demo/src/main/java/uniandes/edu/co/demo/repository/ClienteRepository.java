package uniandes.edu.co.demo.repository;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.demo.modelo.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    @Query(value= "SELECT * FROM clientes", nativeQuery = true)
    Collection<Cliente> darClientes();

    @Query(value= "SELECT * FROM clientes WHERE id = :id", nativeQuery = true)
    Cliente darCliente(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value= "INSERT INTO clientes (id, cedula, nombre) VALUES (superandes_sequence.nextval, :cedula, :nombre)", nativeQuery = true)
    void insertarCliente(@Param("cedula") int cedula, @Param("nombre") String nombre);

    @Modifying
    @Transactional
    @Query(value = "UPDATE clientes SET cedula = :cedula, nombre = :nombre WHERE id = :id", nativeQuery = true)
    void actualizarCliente(@Param("id") int id, @Param("cedula") int cedula, @Param("nombre") String nombre);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM clientes WHERE id = :id", nativeQuery = true)
    void borrarCliente(@Param("id") int id);
}
