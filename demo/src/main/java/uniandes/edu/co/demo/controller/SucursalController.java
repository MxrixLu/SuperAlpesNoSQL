package uniandes.edu.co.demo.controller;

import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.support.Repositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.demo.modelo.Bodega;
import uniandes.edu.co.demo.modelo.Sucursal;
import uniandes.edu.co.demo.repository.SucursalRepository;
import uniandes.edu.co.demo.repository.SucursalRepositoryCustom;
@RestController
@RequestMapping("/sucursales")
public class SucursalController {

    @Autowired
    private SucursalRepository sucursalRepository;

    @Autowired
    private SucursalRepositoryCustom sucursalRepositoryCustom;

    //Crear sucursal
    @PostMapping("/nuevo")
     public ResponseEntity<String> crearSucursal(@RequestBody Sucursal sucursal) {
        try {
            sucursalRepository.insertarSucursal(sucursal.getNombre(), sucursal.getTelefono(), sucursal.getDireccion(), sucursal.getTamano(), sucursal.getCiudad(), sucursal.getBodegas());
            return new ResponseEntity<>("Sucursal creada exitosamente", HttpStatus.CREATED);
        } catch (Exception e) {;
            return new ResponseEntity<>("Error al crear la sucursal: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{nombre}")
    public ResponseEntity<Sucursal> obtenerSucursalPorNombre(@PathVariable("nombre") String nombre) {
        try {
            Sucursal sucursal = sucursalRepository.encontrarPorNombre(nombre);
            if (sucursal != null) {
                return ResponseEntity.ok(sucursal);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    //Crear Bodega
    @PostMapping("/{sucursalId}/bodega/new")
     public ResponseEntity<String> crearBodega(@RequestBody Bodega bodega, @PathVariable("sucursalId") String sucursalId) {
        try {
            sucursalRepository.agregarBodega(sucursalId, bodega);
            return new ResponseEntity<>("Bodega creada exitosamente", HttpStatus.CREATED);
        } catch (Exception e) {;
            return new ResponseEntity<>("Error al crear la bodega: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Eliminar Bodega
    @DeleteMapping("/{sucursalId}/bodegas/{bodegaId}/delete")
    public ResponseEntity<String> eliminarBodega(@PathVariable("sucursalId") String sucursalId, @PathVariable("bodegaId") String bodegaId) {
        try {
            sucursalRepository.eliminarBodega(sucursalId, bodegaId);
            return new ResponseEntity<>("Bodega eliminada exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al eliminar la bodega: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/caracteristicas")
    public ResponseEntity<List<Document>> obtenerInventarioSucursales(String nombreSucursal) {
        try {
            List<Document> sucursales = sucursalRepositoryCustom.inventarioSucursal(nombreSucursal);
            return new ResponseEntity<>(sucursales, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
