package uniandes.edu.co.demo.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import uniandes.edu.co.demo.modelo.NivelReOrden;
import uniandes.edu.co.demo.repository.NivelReOrdenRepository;

@RestController
public class NivelReOrdenController {

    @Autowired
    private NivelReOrdenRepository nivelReOrdenRepository;

    // Obtener todos los niveles de reorden
    @GetMapping("/nivelReOrden")
    public Collection<NivelReOrden> darNivelesReOrden() {
        return nivelReOrdenRepository.darNivelesReOrden();
    }

    // Obtener un nivel de reorden por su ID
    @GetMapping("/nivelReOrden/{id}")
    public ResponseEntity<NivelReOrden> darNivelReOrdenPorId(@PathVariable("id") int id) {
        try {
            NivelReOrden nivelReOrden = nivelReOrdenRepository.darNivelReOrden(id);
            return new ResponseEntity<>(nivelReOrden, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    // Insertar un nuevo nivel de reorden
    @PostMapping("/nivelReOrden/new/save")
    public ResponseEntity<String> insertarNivelReOrden(@RequestBody NivelReOrden nivelReOrden) {
        try {
            nivelReOrdenRepository.insertarNivelReOrden(
                nivelReOrden.getNivelMinimo(),
                nivelReOrden.getSucursal(),
                nivelReOrden.getProducto()
            );
            return new ResponseEntity<>("Nivel de reorden creado exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al crear el nivel de reorden", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Actualizar un nivel de reorden existente
    @PutMapping("/nivelReOrden/{id}/edit/save")
    public ResponseEntity<String> actualizarNivelReOrden(@PathVariable("id") int id, @RequestBody NivelReOrden nivelReOrden) {
        try {
            nivelReOrdenRepository.actualizarNivelReOrden(
                id,
                nivelReOrden.getNivelMinimo(),
                nivelReOrden.getSucursal(),
                nivelReOrden.getProducto()
            );
            return new ResponseEntity<>("Nivel de reorden actualizado exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al actualizar el nivel de reorden", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Borrar un nivel de reorden por su ID
    @DeleteMapping("/nivelReOrden/{id}/delete")
    public ResponseEntity<String> borrarNivelReOrden(@PathVariable("id") int id) {
        try {
            nivelReOrdenRepository.borrarNivelReOrden(id);
            return new ResponseEntity<>("Nivel de reorden eliminado exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al eliminar el nivel de reorden", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}