package uniandes.edu.co.demo.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.websocket.server.PathParam;
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
            productoRepository.insertarProducto( producto.getCodigoBarras(), producto.getNombre(), producto.getCostoBodega(), producto.getprecio_unitario(), producto.getPresentacion(), producto.getCantidadPresentacion(), producto.getUnidadMedida(), producto.getespecificacion_empaque(), producto.getFechaExpiracion(), producto.getCategoria_id());
            return ResponseEntity.ok("Producto creado exitosamente");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al crear el producto: " + e.getMessage());
        }
    }

    @GetMapping("/obtener/cod/{codigo}")
    public ResponseEntity<Producto> obtenerProductoPorCodigo(@PathVariable("codigo") String codigo) {
        // try{
            Producto producto = productoRepository.obtenerProductoPorCodigo(codigo);
            return new ResponseEntity<>(producto, HttpStatus.OK);
        // } catch (Exception e) {
        //     return new ResponseEntity<>(null , HttpStatus.INTERNAL_SERVER_ERROR);
        // }
    }

    @GetMapping("/obtener/nom/{nombre}")
    public ResponseEntity<Producto> obtenerProductoPorNombre(@PathVariable("nombre") String nombre) {
        try{
            System.out.println("Nombre: " + nombre);
            Producto producto = productoRepository.obtenerProductoPorNombre(nombre);
            return new ResponseEntity<>(producto, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null , HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/actualizar/{codigo}")
    public ResponseEntity<String> actualizarProducto(@PathVariable("codigo") String codigo, @RequestBody Producto producto) {
        try{
             productoRepository.actualizarProductoCodigo(codigo, producto.getNombre(), producto.getCostoBodega(), producto.getprecio_unitario(), producto.getPresentacion(), producto.getCantidadPresentacion(), producto.getUnidadMedida(), producto.getespecificacion_empaque(), producto.getFechaExpiracion(), producto.getCategoria_id());
            return ResponseEntity.ok("Producto actualizado exitosamente");
        } catch (Exception e) {
            return new ResponseEntity<>(null , HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/caracteristicas")
    public ResponseEntity<List<Document>> obtenerProductosSegunCaracteristicas(@RequestParam(required = false) int precioInicial, @RequestParam(required = false) int precioFinal, @RequestParam(required = false) String fechaVencimientoMax, @RequestParam(required = false) String sucursal, @RequestParam(required = false) ObjectId categoria) {
        try{
            System.out.println("Fecha: " + fechaVencimientoMax);
            System.out.println("Sucursal: " + sucursal);
            System.out.println("Categoria_id: " + categoria);
            System.out.println("Precio inicial: " + precioInicial);
            System.out.println("Precio final: " + precioFinal);

            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            Date fecha = formato.parse(fechaVencimientoMax);
            List<Document> productos = productoRepositoryCustome.obtenerProductosSegunCaracteristicas(precioInicial, precioFinal, fecha, sucursal, categoria);
            return ResponseEntity.ok(productos);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

}
