package uniandes.edu.co.demo.repository;

import java.util.List;
import org.bson.types.ObjectId;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;
import org.springframework.stereotype.Repository;

import uniandes.edu.co.demo.modelo.Contacto;
import uniandes.edu.co.demo.modelo.Proveedor;

@Repository
public interface ProveedorRepository extends MongoRepository<Proveedor, ObjectId> {

    
    // Crear un nuevo bar
    default void insertarProveedor(ObjectId id, String nit, String nombre, String direccion, Contacto contacto, List<ObjectId> productos_suministrados){
        Proveedor proveedor = new Proveedor();
        proveedor.setId(id);
        proveedor.setNombre(nombre);
        proveedor.setNit(nit);
        proveedor.setDireccion(direccion);
        proveedor.setContacto(contacto);
        proveedor.setProductos_suministrados(productos_suministrados);
        save(proveedor);
    }
    // Actualizar un bar por su ID
    @Query("{nit: ?0}")
    @Update("{$set: { direccion: ?1, contacto: ?2, productos_suministrados: ?3}}")
    void actualizarProveedor( String nit, String direccion, Contacto contacto, List<ObjectId> productos_suministrados);

}
