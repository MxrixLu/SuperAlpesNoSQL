package uniandes.edu.co.demo.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.demo.modelo.Recepcion;
import uniandes.edu.co.demo.repository.RecepcionRepository;


@RestController
public class RecepcionController {

    @Autowired
    private RecepcionRepository recepcionRepository;
    

    // Obtener todas las recepciones
    @GetMapping("/recepciones")
    public Collection<Recepcion> darRecepciones() {
        return recepcionRepository.darRecepciones();
    }

    // Obtener una recepción por su ID
    @GetMapping("/recepciones/{id}")
    public ResponseEntity<Recepcion> darRecepcionPorId(@PathVariable("id") int id) {
        try {
            Recepcion recepcion = recepcionRepository.darRecepcion(id);
            return new ResponseEntity<>(recepcion, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    // // Insertar una nueva recepción
    @PostMapping("/recepciones/new/save")
    @Transactional
    public ResponseEntity<String> insertarRecepcion(@RequestBody Recepcion recepcion) {
        try {
            recepcionRepository.insertarRecepcion(
                recepcion.getFechaRecepcion(),
                recepcion.getId_proveedor().getId(),
                recepcion.getId_bodega().getId()
            );
            return new ResponseEntity<>("Recepción creada exitosamente", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al crear la recepción", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/recepciones/hoy")
    public ResponseEntity<Recepcion> darRecepcionHoy(@Param("proveedor_id") int proveedor_id, @Param("bodega_id") int bodega_id, @Param("fechaString") String fechaString) {
        try {
            Recepcion recepcion = recepcionRepository.darRecepcionHoy(proveedor_id, bodega_id, fechaString);
            System.out.println(recepcion.getId());
            return new ResponseEntity<>(recepcion, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    
    // Actualizar una recepción existente
    @PutMapping("/recepciones/{id}/edit/save")
    @Transactional
    public ResponseEntity<String> actualizarRecepcion(@PathVariable("id") int id,
                                                     @RequestBody Recepcion recepcion) {
        try {
            recepcionRepository.actualizarRecepcion(
                id,
                recepcion.getFechaRecepcion(),
                recepcion.getId_proveedor().getId(),
                recepcion.getId_bodega().getId()
            );
            return new ResponseEntity<>("Recepción actualizada exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al actualizar la recepción", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Borrar una recepción por su ID
    @DeleteMapping("/recepciones/{id}/delete")
    @Transactional
    public ResponseEntity<String> borrarRecepcion(@PathVariable("id") int id) {
        try {
            recepcionRepository.borrarRecepcion(id);
            return new ResponseEntity<>("Recepción eliminada exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al eliminar la recepción", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}