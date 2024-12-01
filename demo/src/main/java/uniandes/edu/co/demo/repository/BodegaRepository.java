package uniandes.edu.co.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;

import uniandes.edu.co.demo.modelo.Bodega;

public interface BodegaRepository extends MongoRepository<Bodega, Integer>{

    @Query(value = "{}", fields = "{ }")
    List<Bodega> buscarTodosLosBodegaes();

    // Consultar bar por su ID
    @Query("")
    List<Bodega> buscarPorId(int id);

    // Crear un nuevo bar
    @Query("")
    void insertarBodega(int id, String nombre, Double tamano);

    // Actualizar un bar por su ID
    @Query("")
    @Update("")
    void actualizarBodega(int id, String nombre, Double tamano);

    // Eliminar un bar por su ID
    @Query(value = "", delete = true)
    void eliminarBodegaPorId(int id);


}