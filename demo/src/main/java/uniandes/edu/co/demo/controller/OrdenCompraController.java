package uniandes.edu.co.demo.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.demo.modelo.OrdenCompra;
import uniandes.edu.co.demo.modelo.OrdenCompraRequest;
import uniandes.edu.co.demo.repository.OrdenCompraRepository;

@RestController
@RequestMapping("/ordenes_compra")

public class OrdenCompraController {
    
    
        @Autowired
        private OrdenCompraRepository orden_compraRepository;
    
    
        @PostMapping("/new")
        public String insertarOrden(@RequestBody OrdenCompraRequest request
        ) {
            try {
                orden_compraRepository.insertarOrden(request.getSucursalId(), request.getProveedorId(), request.getFecha_entrega(), request.getProductos(), request.getCantidades(), request.getPrecios());
                return "Orden de compra creada exitosamente.";
            } catch (Exception e) {
                return "Error al crear la orden de compra: " + e.getMessage();
            }
        }
}
