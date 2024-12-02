package uniandes.edu.co.demo.repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;
import org.springframework.stereotype.Repository;

import uniandes.edu.co.demo.modelo.Bodega;
import uniandes.edu.co.demo.modelo.Sucursal;

@Repository
public interface SucursalRepository extends MongoRepository<Sucursal, ObjectId> {

    default void insertarSucursal(String nombre, String direccion, String telefono, String ciudad, List<Bodega> bodegas){
        Sucursal sucursal = new Sucursal();
        sucursal.setNombre(nombre);
        sucursal.setDireccion(direccion);
        sucursal.setTelefono(telefono);
        sucursal.setCiudad(ciudad);
        sucursal.setBodegas(bodegas);
        save(sucursal);
    }
    //Encontrar por nombre 
    @Query("{ 'nombre': ?0 }")
    Sucursal encontrarPorNombre(String nombre);

    //Crear una bodega
    @Query("{ 'nombre': ?0 }")
    @Update("{$push:{'bodegas': ?1}}")
    void agregarBodega(String nombreSucursal, Bodega bodega);

    //Eliminar una bodega
    @Query("{ 'nombre': ?0 }")
    @Update("{$pull:{items:{'nombre': ?1}}}")
    void eliminarBodega(String nombreSucursal, String bodega_id);

    
}
