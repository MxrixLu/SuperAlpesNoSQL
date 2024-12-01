package uniandes.edu.co.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;

import uniandes.edu.co.demo.modelo.DetalleOrdenCompra;

public interface DetalleOrdenCompraRepository extends MongoRepository<DetalleOrdenCompra, Integer> {

    
    
    @Query(value = "{}", fields = "{ }")
    List<DetalleOrdenCompra> buscarTodosLosDetalleOrdenCompraes();

    // Consultar bar por su ID
    @Query("")
    List<DetalleOrdenCompra> buscarPorId(int id);

    // Crear un nuevo bar
    @Query("")
    void insertarDetalleOrdenCompra();

    // Actualizar un bar por su ID
    @Query("")
    @Update("")
    void actualizarDetalleOrdenCompra();

    // Eliminar un bar por su ID
    @Query(value = "", delete = true)
    void eliminarDetalleOrdenCompraPorId(int id);

    
}
