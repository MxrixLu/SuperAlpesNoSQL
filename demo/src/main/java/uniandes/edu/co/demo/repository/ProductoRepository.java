package uniandes.edu.co.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;

import uniandes.edu.co.demo.modelo.Producto;

public interface ProductoRepository  extends MongoRepository<Producto, Integer>{

    
    
    @Query(value = "{}", fields = "{ }")
    List<Producto> buscarTodosLosProductos();

    // Consultar bar por su ID
    @Query("")
    List<Producto> buscarPorId(int id);

    // Crear un nuevo bar
    @Query("")
    void insertarProducto();

    // Actualizar un bar por su ID
    @Query("")
    @Update("")
    void actualizarProducto();

    // Eliminar un bar por su ID
    @Query(value = "", delete = true)
    void eliminarProductoPorId(int id);

    
}
