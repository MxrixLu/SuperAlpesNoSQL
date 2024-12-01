package uniandes.edu.co.demo.controller;

import java.lang.annotation.Repeatable;
import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.data.annotation.AccessType;
import org.springframework.data.repository.support.Repositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.websocket.server.PathParam;
import uniandes.edu.co.demo.modelo.Categoria;
import uniandes.edu.co.demo.repository.CategoriaRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @PostMapping("/nuevo")
    public ResponseEntity<String> crearCategoria(@RequestBody Categoria categoria) {
        try{
            categoriaRepository.insertarCategoria( categoria.getCodigo(), categoria.getNombre(), categoria.getDescripcion(), categoria.getCaracteristicas_almacenamiento());
            return ResponseEntity.ok("Categoria creada exitosamente");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al crear la categoria: " + e.getMessage());
        }
    }

    @GetMapping("")
    public ResponseEntity<List<Categoria>> obetenerCategorias() {
        try{
            List<Categoria> categorias = categoriaRepository.obtenerCategorias();
            return new ResponseEntity<>(categorias, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null , HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
    }

    @GetMapping("/{nombre}")
    public ResponseEntity<Categoria> obtenerCategoriaPorNombre(@PathVariable("nombre") String nombre) {
        try{
            Categoria categoria = categoriaRepository.obtenerCategoriaPorNombre(nombre);
            return new ResponseEntity<>(categoria, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null , HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Categoria> obtenerCategoriaPorCodigo(@PathVariable("codigo") int param) {
        try{
            Categoria categoria = categoriaRepository.obtenerCategoriaPorCodigo(param);
            return new ResponseEntity<>(categoria, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null , HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    
    

    
}
