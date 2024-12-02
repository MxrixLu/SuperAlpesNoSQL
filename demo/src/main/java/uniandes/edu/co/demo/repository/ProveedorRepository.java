package uniandes.edu.co.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;
import org.springframework.stereotype.Repository;

import uniandes.edu.co.demo.modelo.Contacto;
import uniandes.edu.co.demo.modelo.Proveedor;

@Repository
public interface ProveedorRepository extends MongoRepository<Proveedor, Integer> {

    
    // Crear un nuevo bar
    default void insertarProveedor(int id, String NIT, String direccion, Contacto contacto, List<String> productos){
        Proveedor proveedor = new Proveedor();
        proveedor.setId(id);
        proveedor.setNIT(NIT);
        proveedor.setDireccion(direccion);
        proveedor.setContacto(contacto);
        proveedor.setProductos(productos);
        save(proveedor);
    }
    // Actualizar un bar por su ID
    @Query("{NIT: ?0}")
    @Update("{$set: { direccion: ?1, contacto: ?2, productos: ?3}}")
    void actualizarProveedor( String NIT, String direccion, Contacto contacto, List<String> productos);

}
