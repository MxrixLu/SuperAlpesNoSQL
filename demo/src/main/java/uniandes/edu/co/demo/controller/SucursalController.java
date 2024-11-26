package uniandes.edu.co.demo.controller;

import java.util.Collection;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import uniandes.edu.co.demo.modelo.Sucursal;
import uniandes.edu.co.demo.repository.SucursalRepository;
import uniandes.edu.co.demo.repository.SucursalRepository.RespuestaIndiceOcupacion;

@RestController
public class SucursalController {

    @Autowired
    private SucursalRepository sucursalRepository;

    // Obtener todas las sucursales
    @GetMapping("/sucursales")
    public Collection<Sucursal> darSucursales() {
        return sucursalRepository.darSucursales();
    }

    // Obtener una sucursal por su ID
    @GetMapping("/sucursales/{id}")
    public ResponseEntity<Sucursal> darSucursalPorId(@PathVariable("id") int id) {
        try {
            Sucursal sucursal = sucursalRepository.darSucursal(id);
            return new ResponseEntity<>(sucursal, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    // Insertar una nueva sucursal
    @PostMapping("/sucursales/new/save")
    public ResponseEntity<String> insertarSucursal(@RequestBody Sucursal sucursal) {
        try {
            sucursalRepository.insertarSucursal(
                sucursal.getNombre(),
                sucursal.getTelefono(),
                sucursal.getDireccion(),
                sucursal.getTamano(),
                sucursal.getCiudad().getId()
            );
            return new ResponseEntity<>("Sucursal creada exitosamente", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al crear la sucursal", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Actualizar una sucursal existente
    @PutMapping("/sucursales/{id}/edit/save")
    @Transactional
    public ResponseEntity<String> actualizarSucursal(@PathVariable("id") int id,
                                                    @RequestBody Sucursal sucursal) {
        try {
            sucursalRepository.actualizarSucursal(
                id,
                sucursal.getNombre(),
                sucursal.getTelefono(),
                sucursal.getDireccion(),
                sucursal.getTamano(),
                sucursal.getCiudad().getId()
            );
            return new ResponseEntity<>("Sucursal actualizada exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al actualizar la sucursal", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Borrar una sucursal por su ID
    @DeleteMapping("/sucursales/{id}/delete")
    @Transactional
    public ResponseEntity<String> borrarSucursal(@PathVariable("id") int id) {
        try {
            sucursalRepository.borrarSucursal(id);
            return new ResponseEntity<>("Sucursal eliminada exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al eliminar la sucursal", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/sucursales/consulta")
    public ResponseEntity<?> indiceOcupacionConsulta(@RequestBody List<Integer> listaDeProductos) {
        try {
            Collection<RespuestaIndiceOcupacion>  informacion = sucursalRepository.calcularIndiceOcupacion(listaDeProductos);
            RespuestaIndiceOcupacion info = informacion.iterator().next();
            Map<String, Object> respuesta = new HashMap<>();
            respuesta.put("procentajeOcupacion", info.getPorcentaje_ocupacion());
            return ResponseEntity.ok(respuesta);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }   
}