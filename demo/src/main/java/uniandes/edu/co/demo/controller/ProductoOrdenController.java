package uniandes.edu.co.demo.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import uniandes.edu.co.demo.modelo.ProductoOrden;
import uniandes.edu.co.demo.modelo.Producto;
import uniandes.edu.co.demo.modelo.OrdenCompra;
import uniandes.edu.co.demo.repository.ProductoOrdenRepository;

@RestController
public class ProductoOrdenController {

    @Autowired
    private ProductoOrdenRepository productoOrdenRepository;

    // Obtener todos los registros de ProductoOrden
    @GetMapping("/productoOrdenes")
    public Collection<ProductoOrden> darProductoOrden() {
        return productoOrdenRepository.darProductoOrden();
    }

    // Obtener un registro específico de ProductoOrden por su clave primaria compuesta
    @GetMapping("/productoOrden/{producto_id}/{orden_compra_id}")
    public ResponseEntity<ProductoOrden> darProductoOrdenPorId(@PathVariable("producto_id") int producto_id,
                                                               @PathVariable("orden_compra_id") int orden_compra_id) {
        try {
            ProductoOrden productoOrden = productoOrdenRepository.darProductoOrden(producto_id, orden_compra_id);
            return new ResponseEntity<>(productoOrden, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    // Insertar un nuevo registro de ProductoOrden
    @PostMapping("/productoOrden/new/save")
    @Transactional
    public ResponseEntity<String> insertarProductoOrden(@RequestBody ProductoOrden productoOrden) {
        try {
            productoOrdenRepository.insertarProductoOrden(
                productoOrden.getPk().getId_producto(),
                productoOrden.getPk().getId_ordenCompra(),
                productoOrden.getPrecioAcordado(),
                productoOrden.getCantidadSolicitada()
            );
            return new ResponseEntity<>("ProductoOrden creada exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al crear el ProductoOrden", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Actualizar un registro existente de ProductoOrden
    @PutMapping("/productoOrden/{producto_id}/{orden_compra_id}/edit/save")
    @Transactional
    public ResponseEntity<String> actualizarProductoOrden(@PathVariable("producto_id") Producto producto_id,
                                                          @PathVariable("orden_compra_id") OrdenCompra orden_compra_id,
                                                          @RequestBody ProductoOrden productoOrden) {
        try {
            productoOrdenRepository.actualizarProductoOrden(
                producto_id,
                orden_compra_id,
                productoOrden.getPrecioAcordado(),
                productoOrden.getCantidadSolicitada()
            );
            return new ResponseEntity<>("ProductoOrden actualizada exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al actualizar el ProductoOrden", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Borrar un registro de ProductoOrden por su clave primaria compuesta
    @DeleteMapping("/productoOrden/{producto_id}/{orden_compra_id}/delete")
    @Transactional
    public ResponseEntity<String> borrarProductoOrden(@PathVariable("producto_id") Producto producto_id,
                                                      @PathVariable("orden_compra_id") OrdenCompra orden_compra_id) {
        try {
            productoOrdenRepository.borrarProductoOrden(producto_id, orden_compra_id);
            return new ResponseEntity<>("ProductoOrden eliminada exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al eliminar el ProductoOrden", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Obtener productos en una orden específica
    @GetMapping("/productoOrden/orden/{orden_compra_id}")
    public ResponseEntity<Collection<Integer>> darProductosPorOrden(@PathVariable("orden_compra_id") int orden_compra_id) {
        try {
            Collection<Integer> productosOrden = productoOrdenRepository.darProductosPorOrden(orden_compra_id);
            return new ResponseEntity<>(productosOrden, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    // Obtener órdenes que contienen un producto específico
    @GetMapping("/productoOrden/producto/{producto_id}")
    public ResponseEntity<Collection<ProductoOrden>> darOrdenesPorProducto(@PathVariable("producto_id") Producto producto_id) {
        try {
            Collection<ProductoOrden> ordenesProducto = productoOrdenRepository.darOrdenesPorProducto(producto_id);
            return new ResponseEntity<>(ordenesProducto, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}