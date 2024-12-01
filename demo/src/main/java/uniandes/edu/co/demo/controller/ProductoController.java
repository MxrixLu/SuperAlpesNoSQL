package uniandes.edu.co.demo.controller;

import java.util.Date;
import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.demo.modelo.Producto;
import uniandes.edu.co.demo.repository.ProductoRepository;
import uniandes.edu.co.demo.repository.ProductoRepositoryCustom;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private ProductoRepositoryCustom productoRepositoryCustome;

    @PostMapping("/nuevo")
    public ResponseEntity<String> crearProducto(@RequestBody Producto producto) {
        try{
            productoRepository.insertarProducto( producto.getCodigoBarras(), producto.getNombre(), producto.getCostoBodega(), producto.getPrecioVenta(), producto.getPresentacion(), producto.getCantidadPresentacion(), producto.getUnidadMedida(), producto.getEspecificaciones(), producto.getFechaExpiracion(), producto.getCategoria());
            return ResponseEntity.ok("Producto creado exitosamente");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al crear el producto: " + e.getMessage());
        }
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Producto> obtenerProductoPorCodigo(@PathVariable("codigo") String codigo) {
        try{
            Producto producto = productoRepository.obtenerProductoPorCodigo(codigo);
            return new ResponseEntity<>(producto, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null , HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{nombre}")
    public ResponseEntity<Producto> obtenerProductoPorNombre(@PathVariable("nombre") String nombre) {
        try{
            Producto producto = productoRepository.obtenerProductoPorNombre(nombre);
            return new ResponseEntity<>(producto, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null , HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/actualizar/{codigo}")
    public ResponseEntity<Producto> actualizarProducto(@PathVariable("codigo") String codigo, @RequestBody Producto producto) {
        try{
            Producto productoActualizado = productoRepository.actualizarProductoCodigo(codigo, producto.getNombre(), producto.getCostoBodega(), producto.getPrecioVenta(), producto.getPresentacion(), producto.getCantidadPresentacion(), producto.getUnidadMedida(), producto.getEspecificaciones(), producto.getFechaExpiracion(), producto.getCategoria());
            return new ResponseEntity<>(productoActualizado, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null , HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/caracteristicas")
    public ResponseEntity<List<Document>> obtenerProductosSegunCaracteristicas(Double precioInicial, Double precioFinal, Date fechaVencimientoMax, String sucursal, String categoria) {
        try{
            List<Document> productos = productoRepositoryCustome.obtenerProductosSegunCaracterisitas(precioInicial, precioFinal, fechaVencimientoMax, sucursal, categoria);
            return ResponseEntity.ok(productos);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

}
