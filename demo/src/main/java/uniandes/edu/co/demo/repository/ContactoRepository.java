package uniandes.edu.co.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;

import uniandes.edu.co.demo.modelo.Contacto;

public interface ContactoRepository extends MongoRepository<Contacto, String> {

    
    
    @Query(value = "{}", fields = "{ }")
    List<Contacto> buscarTodosLosContactoes();

    // Consultar bar por su ID
    @Query("")
    List<Contacto> buscarPorId(int id);

    // Crear un nuevo bar
    @Query("")
    void insertarContacto();

    // Actualizar un bar por su ID
    @Query("")
    @Update("")
    void actualizarContacto();

    // Eliminar un bar por su ID
    @Query(value = "", delete = true)
    void eliminarContactoPorId(int id);


}
