package uniandes.edu.co.demo.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.demo.modelo.Ciudad;
import uniandes.edu.co.demo.repository.CiudadRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
public class CiudadController {

    @Autowired
    private CiudadRepository ciudadRepository;

    @GetMapping("/ciudades")
    public Collection<Ciudad> ciudades() {
        return ciudadRepository.darCiudades();
    }

    @PostMapping("/ciudades/new/save")
    public ResponseEntity<String> insertarCiudad(@RequestBody Ciudad ciudad) {
        try {
            ciudadRepository.insertarCiudad(
                ciudad.getCodigo(),
                ciudad.getNombre()
            );
            return new ResponseEntity<>("Ciudad creada exitosamente", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al crear la ciudad", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/ciudades/{id}/edit/save")
    public ResponseEntity<String> actualizarCiudad(@PathVariable("id") Integer id, @RequestBody Ciudad ciudad) {
        try {
            ciudadRepository.actualizarCiudad(
                id,
                ciudad.getCodigo(),
                ciudad.getNombre()
            );
            return new ResponseEntity<>("La ciudad se actualizó exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al actualizar la ciudad", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/ciudades/{id}/delete")
    public ResponseEntity<String> borrarCiudad(@PathVariable("id") Integer id) {
        try {
            ciudadRepository.borrarCiudad(id);
            return new ResponseEntity<>("La ciudad se eliminó exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al eliminar la ciudad", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
