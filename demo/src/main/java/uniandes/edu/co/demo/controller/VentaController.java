package uniandes.edu.co.demo.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import uniandes.edu.co.demo.modelo.Venta;
import uniandes.edu.co.demo.repository.VentaRepository;

@RestController
public class VentaController {

    @Autowired
    private VentaRepository ventaRepository;

    // Obtener todas las ventas
    @GetMapping("/ventas")
    public Collection<Venta> darVentas() {
        return ventaRepository.darVentas();
    }

    // Obtener una venta por su ID
    @GetMapping("/ventas/{id}")
    public ResponseEntity<Venta> darVentaPorId(@PathVariable("id") int id) {
        try {
            Venta venta = ventaRepository.darVenta(id);
            return new ResponseEntity<>(venta, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    // Insertar una nueva venta
    @PostMapping("/ventas/new/save")
    @Transactional
    public ResponseEntity<String> insertarVenta(@RequestBody Venta venta) {
        try {
            ventaRepository.insertarVenta(
                venta.getId(),
                venta.getFecha(),
                venta.getCantidad(),
                venta.getPrecioUnitario(),
                venta.getCedula(),
                venta.getCliente(),
                venta.getProducto()
            );
            return new ResponseEntity<>("Venta creada exitosamente", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al crear la venta", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Actualizar una venta existente
    @PutMapping("/ventas/{id}/edit/save")
    @Transactional
    public ResponseEntity<String> actualizarVenta(@PathVariable("id") int id,
                                                  @RequestBody Venta venta) {
        try {
            ventaRepository.actualizarVenta(
                id,
                venta.getFecha(),
                venta.getCantidad(),
                venta.getPrecioUnitario(),
                venta.getCedula(),
                venta.getCliente(),
                venta.getProducto()
            );
            return new ResponseEntity<>("Venta actualizada exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al actualizar la venta", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Borrar una venta por su ID
    @DeleteMapping("/ventas/{id}/delete")
    @Transactional
    public ResponseEntity<String> borrarVenta(@PathVariable("id") int id) {
        try {
            ventaRepository.borrarVenta(id);
            return new ResponseEntity<>("Venta eliminada exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al eliminar la venta", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
