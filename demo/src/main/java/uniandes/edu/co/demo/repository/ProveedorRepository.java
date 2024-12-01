package uniandes.edu.co.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;

import uniandes.edu.co.demo.modelo.Contacto;
import uniandes.edu.co.demo.modelo.Proveedor;

public interface ProveedorRepository extends MongoRepository<Proveedor, Integer> {

    
    // Crear un nuevo bar
    @Query("{$insert: { NIT: ?0, direccion: ?1, contacto: ?2, productos: ?3}}")
    void insertarProveedor(String NIT, String direccion, Contacto contacto, List<String> productos);

    // Actualizar un bar por su ID
    @Query("{NIT: ?0}")
    @Update("{$set: { direccion: ?1, contacto: ?2, productos: ?3}}")
    void actualizarProveedor( String NIT, String direccion, Contacto contacto, List<String> productos);

}
