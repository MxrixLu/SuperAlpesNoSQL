package uniandes.edu.co.demo.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import uniandes.edu.co.demo.modelo.OrdenCompra;
import uniandes.edu.co.demo.repository.OrdenCompraRepository;

@RestController
public class OrdenCompraController {

    @Autowired
    private OrdenCompraRepository ordenCompraRepository;

    // Obtener todas las órdenes de compra
    @GetMapping("/ordenesCompra")
    public Collection<OrdenCompra> darOrdenesCompra() {
        return ordenCompraRepository.darOrdenesCompra();
    }

    // Obtener una orden de compra por su ID
    @GetMapping("/ordenCompra/{id}")
    public ResponseEntity<OrdenCompra> darOrdenCompraPorId(@PathVariable("id") int id) {
        try {
            OrdenCompra ordenCompra = ordenCompraRepository.darOrdenCompra(id);
            return new ResponseEntity<>(ordenCompra, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    // Insertar una nueva orden de compra
    @PostMapping("/ordenCompra/new/save")
    public ResponseEntity<String> insertarOrdenCompra(@RequestBody OrdenCompra ordenCompra) {
        try {
        
            ordenCompraRepository.insertarOrdenCompra(
                ordenCompra.getFechaEsperadaEntrega(),
                ordenCompra.getPrecioAcordado(),
                ordenCompra.getEstado(),
                ordenCompra.getFechaCreacion(),
                ordenCompra.getSucursal().getId(),
                ordenCompra.getProveedor().getId()
            );
            return new ResponseEntity<>("Orden de compra creada exitosamente", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al crear la orden de compra", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Actualizar una orden de compra existente
    @PutMapping("/ordenCompra/{id}/edit/save")
    public ResponseEntity<String> actualizarOrdenCompra(@PathVariable("id") int id, @RequestBody OrdenCompra ordenCompra) {
        try {
            ordenCompraRepository.actualizarOrdenCompra(
                id,
                ordenCompra.getFechaEsperadaEntrega(),
                ordenCompra.getPrecioAcordado(),
                ordenCompra.getEstado(),
                ordenCompra.getFechaCreacion(),
                ordenCompra.getSucursal().getId(),
                ordenCompra.getProveedor().getId()
            );
            return new ResponseEntity<>("Orden de compra actualizada exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al actualizar la orden de compra", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Borrar una orden de compra por su ID
    @DeleteMapping("/ordenCompra/{id}/delete")
    public ResponseEntity<String> borrarOrdenCompra(@PathVariable("id") int id) {
        try {
            ordenCompraRepository.borrarOrdenCompra(id);
            return new ResponseEntity<>("Orden de compra eliminada exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al eliminar la orden de compra", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}