package uniandes.edu.co.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;

import uniandes.edu.co.demo.modelo.Especificaciones;

public interface EspecificacionesRepository extends MongoRepository<Especificaciones, Integer> {

    
    
    @Query(value = "{}", fields = "{ }")
    List<Especificaciones> buscarTodosLosEspecificaciones();

    // Consultar bar por su ID
    @Query("")
    List<Especificaciones> buscarPorId(int id);

    // Crear un nuevo bar
    @Query("")
    void insertarEspecificaciones();

    // Actualizar un bar por su ID
    @Query("")
    @Update("")
    void actualizarEspecificaciones();

    // Eliminar un bar por su ID
    @Query(value = "", delete = true)
    void eliminarEspecificacionesPorId(int id);

}
