package uniandes.edu.co.demo.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Date;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import uniandes.edu.co.demo.modelo.Producto;
import uniandes.edu.co.demo.repository.ProductoRepository;
import uniandes.edu.co.demo.repository.ProductoRepository.RespuestaDarProductosPorCaracteristica;
import uniandes.edu.co.demo.repository.ProductoRepository.RespuestaListarProductosReorden;


@RestController
public class ProductoController {

    @Autowired
    private ProductoRepository productoRepository;

    // Obtener todos los productos
    @GetMapping("/productos")
    public Collection<Producto> darProductos() {
        return productoRepository.darProductos();
    }


    //---------------CONSULTAS----------------//

    @GetMapping("/productos/consulta")
    public ResponseEntity<?> listarProductosReOrdenConsulta() {
        try {
            Collection<RespuestaListarProductosReorden> productos = productoRepository.listarProductosReorden();
            RespuestaListarProductosReorden info = productos.iterator().next();
            Map<String, Object> respuesta = new HashMap<>();
            respuesta.put("procentajeOcupacion", info.getNit_proveedor());
            respuesta.put("nombreProducto", info.getNombre_producto());
            respuesta.put("producto_id", info.getProducto_id());
            respuesta.put("nombreBodega", info.getNombre_bodega());
            respuesta.put("nombreSucursal", info.getNombre_sucursal());
            respuesta.put("cantidad_existente", info.getCantidad_existente());
            return ResponseEntity.ok(respuesta);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/productos/consultaCaracteristica")
    public ResponseEntity<?> darProductoPorCaracteristica(@RequestParam(required = false) Double precioMinimo,
                                                          @RequestParam(required = false) Double precioMaximo,
                                                          @RequestParam(required = false) String fechaInicio, 
                                                          @RequestParam(required = false) String fechaFin, 
                                                          @RequestParam(required = false) int idCategoria) throws ParseException{
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date fechaInicioDate = formatter.parse(fechaInicio);

            Date fechaFinDate = formatter.parse(fechaFin);

            Collection<RespuestaDarProductosPorCaracteristica> productos = productoRepository.darProductosPorCaracteristicas(precioMinimo, precioMaximo, fechaInicioDate, fechaFinDate, idCategoria);
            RespuestaDarProductosPorCaracteristica info = productos.iterator().next();
            Map<String, Object> respuesta = new HashMap<>();
            respuesta.put("nombre", info.getNombre());
            respuesta.put("codigo_barras", info.getCodigo_barras());
            respuesta.put("costo_bodega", info.getCosto_bodega());
            respuesta.put("precio_venta", info.getPrecio_venta());
            respuesta.put("presentacion", info.getPresentacion());
            respuesta.put("cantidad_presentacion", info.getCantidad_presentacion());
            respuesta.put("unidad_medida", info.getUnidad_medida());
            respuesta.put("volumen_empaque", info.getVolumen_empaque());
            respuesta.put("peso_empaque", info.getPeso_empaque());
            respuesta.put("fecha_expiracion", info.getFecha_expiracion());
            respuesta.put("categoria_id", info.getCategoria_id());
            return ResponseEntity.ok(respuesta);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    
    //---------------CRUD----------------//

    // Obtener un producto por su clave primaria compuesta
    @GetMapping("/productos/{codigo_barras}")
    public ResponseEntity<Producto> darProductoPorId(@PathVariable("codigo_barras") String codigo_barras) {
        List<Producto> productos = productoRepository.darPorCodigoBarras(codigo_barras);
        
        if (productos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            Producto producto = productos.get(0);  // Get the first match
            return new ResponseEntity<>(producto, HttpStatus.OK);
        }
    }
    

    // Insertar un nuevo producto
    @PostMapping("/productos/new/save")
    @Transactional
    public ResponseEntity<String> insertarProducto(@RequestBody Producto producto) {
        try {
            System.err.println("Empieza insertar productos");
            String codigo_barras = producto.getCodigoBarras();
            System.err.println(codigo_barras + "Este es el codigo de barras creado");
            productoRepository.insertarProducto(
                codigo_barras,
                producto.getNombre(),
                producto.getCostoBodega(),
                producto.getPrecioVenta(),
                producto.getPresentacion(),
                producto.getCantidadPresentacion(),
                producto.getUnidadMedida(),
                producto.getVolumenEmpaque(),
                producto.getPesoEmpaque(),
                producto.getFechaExpiracion(),
                producto.getCategoria().getId()
            );
            return new ResponseEntity<>("Producto creado exitosamente", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al crear el producto", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Actualizar un producto existente
    @PutMapping("/productos/{id}/{codigo_barras}/edit/save")
    @Transactional
    public ResponseEntity<String> actualizarProducto(@PathVariable("id") int id,
                                                     @PathVariable("codigo_barras") String codigo_barras,
                                                     @RequestBody Producto producto) {
        try {
            productoRepository.actualizarProducto(
                id,
                codigo_barras,
                producto.getNombre(),
                producto.getCostoBodega(),
                producto.getPrecioVenta(),
                producto.getPresentacion(),
                producto.getCantidadPresentacion(),
                producto.getUnidadMedida(),
                producto.getVolumenEmpaque(),
                producto.getPesoEmpaque(),
                producto.getFechaExpiracion(),
                producto.getCategoria().getId() 
            );
            return new ResponseEntity<>("Producto actualizado exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al actualizar el producto", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Borrar un producto por su clave primaria compuesta
    @DeleteMapping("/productos/{id}/{codigo_barras}/delete")
    @Transactional
    public ResponseEntity<String> borrarProducto(@PathVariable("id") int id, @PathVariable("codigo_barras") String codigo_barras) {
        try {
            productoRepository.borrarProducto(id, codigo_barras);
            return new ResponseEntity<>("Producto eliminado exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al eliminar el producto", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}