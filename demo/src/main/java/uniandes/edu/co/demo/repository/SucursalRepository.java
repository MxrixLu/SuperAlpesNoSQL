package uniandes.edu.co.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;

import uniandes.edu.co.demo.modelo.Sucursal;

public interface SucursalRepository extends MongoRepository<Sucursal, Integer> {

    
    
    @Query(value = "{}", fields = "{ }")
    List<Sucursal> buscarTodosLasSucursales();

    // Consultar bar por su ID
    @Query("")
    List<Sucursal> buscarPorId(int id);

    // Crear un nuevo bar
    @Query("")
    void insertarSucursal();

    // Actualizar un bar por su ID
    @Query("")
    @Update("")
    void actualizarSucursal();

    // Eliminar un bar por su ID
    @Query(value = "", delete = true)
    void eliminarSucursalPorId(int id);

}
