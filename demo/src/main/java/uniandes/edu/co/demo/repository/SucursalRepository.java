package uniandes.edu.co.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;

import uniandes.edu.co.demo.modelo.Bodega;
import uniandes.edu.co.demo.modelo.Sucursal;

public interface SucursalRepository extends MongoRepository<Sucursal, Integer> {

    //Crear una nueva sucursal
    @Query("{ $insert : { nombre: ?0, telefono: ?1, direccion: ?2, tamano: ?3, ciudad: ?4, bodegas: ?5}}")
    void insertarSucursal( String nombre, String telefono, String direccion, Double tamano, String ciudad, List<Bodega> bodegas);
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
    void eliminarBodega(String nombreSucursal, String bodegaId);

    
}
