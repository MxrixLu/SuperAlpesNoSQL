package uniandes.edu.co.demo.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.demo.modelo.Categoria;
import uniandes.edu.co.demo.repository.CategoriaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping("/categorias")
    public Collection<Categoria> categorias() {
        return categoriaRepository.darCategorias();
    }

    @GetMapping("/categorias/{id}")
    public Categoria darCategoria(@PathVariable("id") int id) {
        return categoriaRepository.darCategoria(id);
    }

    @PostMapping("/categorias/new/save")
    public ResponseEntity<String> insertarCategoria(@RequestBody Categoria categoria) {
        try {
            categoriaRepository.insertarCategoria(
                categoria.getCodigo(),
                categoria.getNombre(),
                categoria.getDescripcion(),
                categoria.getCaracteristicasAlmacenamiento()
            );
            return new ResponseEntity<>("Categoría creada exitosamente", HttpStatus.CREATED);
            
        } catch (Exception e) {
            return new ResponseEntity<>("Error al crear la categoría", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/categorias/{id}/edit/save")
    public ResponseEntity<String> actualizarCategoria(@PathVariable("id") Integer id, @RequestBody Categoria categoria) {
        try {
            categoriaRepository.actualizarCategoria(
                id,
                categoria.getCodigo(),
                categoria.getNombre(),
                categoria.getDescripcion(),
                categoria.getCaracteristicasAlmacenamiento()
            );
            return new ResponseEntity<>("La categoría se actualizó exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al actualizar la categoría", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/categorias/{id}/delete")
    public ResponseEntity<String> borrarCategoria(@PathVariable("id") Integer id) {
        try {
            categoriaRepository.borrarCategoria(id);
            return new ResponseEntity<>("La categoría se eliminó exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al eliminar la categoría", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}