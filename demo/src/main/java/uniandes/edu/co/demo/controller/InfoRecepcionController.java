package uniandes.edu.co.demo.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.demo.modelo.InfoRecepcion;
import uniandes.edu.co.demo.modelo.Producto;
import uniandes.edu.co.demo.modelo.Recepcion;
import uniandes.edu.co.demo.repository.InfoRecepcionRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
public class InfoRecepcionController {

    @Autowired
    private InfoRecepcionRepository infoRecepcionRepository;

    @GetMapping("/infoRecepcion")
    public Collection<InfoRecepcion> infoRecepciones() {
        return infoRecepcionRepository.darInfoRecepcion();
    }

    @GetMapping("/infoRecepcion/{recepcion_id}/{producto_id}")
    public ResponseEntity<InfoRecepcion> obtenerInfoRecepcionPorId(@PathVariable("recepcion_id") int recepcion_id,
                                                                   @PathVariable("producto_id") int producto_id) {
        try {
            InfoRecepcion infoRecepcion = infoRecepcionRepository.darInfoRecepcionPorId(recepcion_id, producto_id);
            return new ResponseEntity<>(infoRecepcion, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/infoRecepcion/new/save")
    public ResponseEntity<String> insertarInfoRecepcion(@RequestBody InfoRecepcion infoRecepcion) {
        try {
            infoRecepcionRepository.insertarInfoRecepcion(
                infoRecepcion.getPk().getRecepcion().getId(),
                infoRecepcion.getPk().getProducto().getId(),
                infoRecepcion.getCantidadRecibida(),
                infoRecepcion.getCostoRecibido()
            );
            return new ResponseEntity<>("Info de Recepción creada exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al crear la info de recepción", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/infoRecepcion/{recepcion_id}/{producto_id}/edit/save")
    public ResponseEntity<String> actualizarInfoRecepcion(@PathVariable("recepcion_id") Recepcion recepcion_id,
                                                          @PathVariable("producto_id") Producto producto_id,
                                                          @RequestBody InfoRecepcion infoRecepcion) {
        try {
            infoRecepcionRepository.actualizarInfoRecepcion(
                recepcion_id,
                producto_id,
                infoRecepcion.getCantidadRecibida(),
                infoRecepcion.getCostoRecibido()
            );
            return new ResponseEntity<>("Info de Recepción actualizada exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al actualizar la info de recepción", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/infoRecepcion/{recepcion_id}/{producto_id}/delete")
    public ResponseEntity<String> borrarInfoRecepcion(@PathVariable("recepcion_id") Recepcion recepcion_id,
                                                      @PathVariable("producto_id") Producto producto_id) {
        try {
            infoRecepcionRepository.borrarInfoRecepcion(recepcion_id, producto_id);
            return new ResponseEntity<>("Info de Recepción eliminada exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al eliminar la info de recepción", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}