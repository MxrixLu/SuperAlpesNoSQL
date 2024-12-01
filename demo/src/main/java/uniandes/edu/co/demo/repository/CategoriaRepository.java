package uniandes.edu.co.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;

import uniandes.edu.co.demo.modelo.Categoria;

public interface CategoriaRepository extends MongoRepository<Categoria, Integer> {

    
    @Query(value = "{}", fields = "{ }")
    List<Categoria> buscarTodosLosCategoriaes();

    // Consultar bar por su ID
    @Query("")
    List<Categoria> buscarPorId(int id);

    // Crear un nuevo bar
    @Query("")
    void insertarCategoria();

    // Actualizar un bar por su ID
    @Query("")
    @Update("")
    void actualizarCategoria();

    // Eliminar un bar por su ID
    @Query(value = "", delete = true)
    void eliminarCategoriaPorId(int id);

}
