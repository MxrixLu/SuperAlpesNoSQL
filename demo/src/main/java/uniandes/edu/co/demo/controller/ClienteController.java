package uniandes.edu.co.demo.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.demo.modelo.Cliente;
import uniandes.edu.co.demo.repository.ClienteRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("/clientes")
    public Collection<Cliente> clientes() {
        return clienteRepository.darClientes();
    }

    @PostMapping("/clientes/new/save")
    public ResponseEntity<String> insertarCliente(@RequestBody Cliente cliente) {
        try {
            clienteRepository.insertarCliente(
                cliente.getCedula(),
                cliente.getNombre()
            );
            return new ResponseEntity<>("Cliente creado exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al crear el cliente", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/clientes/{id}/edit/save")
    public ResponseEntity<String> clienteEditarGuardar(@PathVariable("id") Integer id, @RequestBody Cliente cliente) {
        try {
            clienteRepository.actualizarCliente(
                id,
                cliente.getCedula(),
                cliente.getNombre()
            );
            return new ResponseEntity<>("El cliente se actualizó exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al actualizar el cliente", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/clientes/{id}/delete")
    public ResponseEntity<String> borrarCliente(@PathVariable("id") Integer id) {
        try {
            clienteRepository.borrarCliente(id);
            return new ResponseEntity<>("El cliente se eliminó exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al eliminar el cliente", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
