package uniandes.edu.co.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import uniandes.edu.co.demo.modelo.Categoria;

public interface CategoriaRepository extends MongoRepository<Categoria, Integer> {


    // Crear un nuevo bar
    @Query("{$insert: {codigo: ?0, nombre: ?1, descripcion: ?2, caracteristicas_almacenamiento: ?3}}")
    void insertarCategoria(int codigo, String nombre, String descripcion, String caracteristicas_almacenamiento);

    @Query(value = "{}")
    List<Categoria> obtenerCategorias();

    @Query(value = "{nombre: ?0}")
    Categoria obtenerCategoriaPorNombre(String nombre);

    @Query(value = "{codigo: ?0}")
    Categoria obtenerCategoriaPorCodigo(int codigo);
}
