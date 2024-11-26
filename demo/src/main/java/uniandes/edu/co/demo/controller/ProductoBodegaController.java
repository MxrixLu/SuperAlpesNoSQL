package uniandes.edu.co.demo.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.demo.modelo.Bodega;
import uniandes.edu.co.demo.modelo.Producto;
import uniandes.edu.co.demo.modelo.ProductoBodega;
import uniandes.edu.co.demo.repository.ProductoBodegaRepository;

@RestController
public class ProductoBodegaController {

    @Autowired
    private ProductoBodegaRepository productoBodegaRepository;

    // Obtener todos los registros de ProductoBodega
    @GetMapping("/productoBodegas")
    public Collection<ProductoBodega> darProductoBodega() {
        return productoBodegaRepository.darProductoBodega();
    }

    // Obtener un registro específico de ProductoBodega por su clave primaria compuesta
    @GetMapping("/productoBodega/{producto_id}/{bodega_id}")
    public ResponseEntity<ProductoBodega> darProductoBodegaPorId(@PathVariable("producto_id") Producto producto_id,
                                                                 @PathVariable("bodega_id") Bodega bodega_id) {
        try {
            ProductoBodega productoBodega = productoBodegaRepository.darProductoBodega(producto_id, bodega_id);
            return new ResponseEntity<>(productoBodega, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    // Insertar un nuevo registro de ProductoBodega
    @PostMapping("/productoBodega/new/save")
    @Transactional
    public ResponseEntity<String> insertarProductoBodega(@RequestBody ProductoBodega productoBodega) {
        try {
            productoBodegaRepository.insertarProductoBodega(
                productoBodega.getPk().getId_producto(),
                productoBodega.getPk().getId_bodega(),
                productoBodega.getCantidadExistente(),
                productoBodega.getCostoPromedio(), 
                productoBodega.getCapacidadBodega()
            );
            return new ResponseEntity<>("ProductoBodega creada exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al crear el ProductoBodega", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Actualizar un registro existente de ProductoBodega
    @PutMapping("/productoBodega/{producto_id}/{bodega_id}/edit/save")
    @Transactional
    public ResponseEntity<String> actualizarProductoBodega(@PathVariable("producto_id") Producto producto_id,
                                                           @PathVariable("bodega_id") Bodega bodega_id,
                                                           @RequestBody ProductoBodega productoBodega) {
        try {
            productoBodegaRepository.actualizarProductoBodega(
                producto_id,
                bodega_id,
                productoBodega.getCantidadExistente(),
                productoBodega.getCostoPromedio(), 
                productoBodega.getCapacidadBodega()
            );
            return new ResponseEntity<>("ProductoBodega actualizada exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al actualizar el ProductoBodega", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Borrar un registro de ProductoBodega por su clave primaria compuesta
    @DeleteMapping("/productoBodega/{producto_id}/{bodega_id}/delete")
    @Transactional
    public ResponseEntity<String> borrarProductoBodega(@PathVariable("producto_id") Producto producto_id,
                                                       @PathVariable("bodega_id") Bodega bodega_id) {
        try {
            productoBodegaRepository.borrarProductoBodega(producto_id, bodega_id);
            return new ResponseEntity<>("ProductoBodega eliminada exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al eliminar el ProductoBodega", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Obtener productos en una bodega específica
    @GetMapping("/productoBodega/bodega/{bodega_id}")
    public ResponseEntity<Collection<ProductoBodega>> darProductosPorBodega(@PathVariable("bodega_id") Bodega bodega_id) {
        try {
            Collection<ProductoBodega> productosBodega = productoBodegaRepository.darProductosPorBodega(bodega_id);
            return new ResponseEntity<>(productosBodega, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    // Obtener bodegas que contienen un producto específico
    @GetMapping("/productoBodega/producto/{producto_id}")
    public ResponseEntity<Collection<ProductoBodega>> darBodegasPorProducto(@PathVariable("producto_id") Producto producto_id) {
        try {
            Collection<ProductoBodega> bodegasProducto = productoBodegaRepository.darBodegasPorProducto(producto_id);
            return new ResponseEntity<>(bodegasProducto, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

}