package uniandes.edu.co.demo.repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import uniandes.edu.co.demo.modelo.Categoria;
@Repository
public interface CategoriaRepository extends MongoRepository<Categoria, ObjectId> {



    default void insertarCategoria(String codigo, String nombre, String descripcion, String caracteristicas_almacenamiento){
        Categoria categoria = new Categoria();
        categoria.setCodigo(codigo);
        categoria.setNombre(nombre);
        categoria.setDescripcion(descripcion);
        categoria.setCaracteristicas_almacenamiento(caracteristicas_almacenamiento);
        save(categoria);
    }

    @Query(value = "{}")
    List<Categoria> obtenerCategorias();

    @Query(value = "{'nombre': ?0}")
    Categoria obtenerCategoriaPorNombre(String nombreCat);

    @Query(value = "{'codigo': ?0}")
    Categoria obtenerCategoriaPorCodigo(String codigo);
}
