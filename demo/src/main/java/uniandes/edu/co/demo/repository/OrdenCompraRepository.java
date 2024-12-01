package uniandes.edu.co.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;

import uniandes.edu.co.demo.modelo.OrdenCompra;

public interface OrdenCompraRepository extends MongoRepository<OrdenCompra, Integer> {

    
    
    @Query(value = "{}", fields = "{ }")
    List<OrdenCompra> buscarTodasLasOrdenCompras();

    // Consultar bar por su ID
    @Query("")
    List<OrdenCompra> buscarPorId(int id);

    // Crear un nuevo bar
    @Query("")
    void insertarOrdenCompra();

    // Actualizar un bar por su ID
    @Query("")
    @Update("")
    void actualizarOrdenCompra();

    // Eliminar un bar por su ID
    @Query(value = "", delete = true)
    void eliminarOrdenCompraPorId(int id);

    
}
