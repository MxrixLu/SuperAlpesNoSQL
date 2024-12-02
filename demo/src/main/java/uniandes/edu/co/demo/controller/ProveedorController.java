package uniandes.edu.co.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.demo.modelo.Proveedor;
import uniandes.edu.co.demo.repository.ProveedorRepository;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/proveedores")
public class ProveedorController {

    @Autowired
    private ProveedorRepository proveedorRepository;

    //Crear proveedor
    @PostMapping("/nuevo")
    public ResponseEntity<String> crearProveedor(@RequestBody Proveedor proveedor) {
        try {
            proveedorRepository.insertarProveedor(proveedor.getId(), proveedor.getNIT(), proveedor.getDireccion(), proveedor.getContacto(), proveedor.getProductos());
            return new ResponseEntity<>("Proveedor creado exitosamente", HttpStatus.CREATED);
        } catch (Exception e) {;
            return new ResponseEntity<>("Error al crear el proveedor: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<String> actualizarProveedor(@PathVariable String id, @RequestBody Proveedor proveedor) {
        try{
            proveedorRepository.actualizarProveedor( id, proveedor.getDireccion(), proveedor.getContacto(), proveedor.getProductos());
            return new ResponseEntity<>("Proveedor actuualizado", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al actualizar el proveedor: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
