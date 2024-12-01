package uniandes.edu.co.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;

import uniandes.edu.co.demo.modelo.Proveedor;

public interface ProveedorRepository extends MongoRepository<Proveedor, Integer> {

    
    
    @Query(value = "{}", fields = "{ }")
    List<Proveedor> buscarTodosLosProveedores();

    // Consultar bar por su ID
    @Query("")
    List<Proveedor> buscarPorId(int id);

    // Crear un nuevo bar
    @Query("")
    void insertarProveedor();

    // Actualizar un bar por su ID
    @Query("")
    @Update("")
    void actualizarProveedor();

    // Eliminar un bar por su ID
    @Query(value = "", delete = true)
    void eliminarProveedorPorId(int id);

}
