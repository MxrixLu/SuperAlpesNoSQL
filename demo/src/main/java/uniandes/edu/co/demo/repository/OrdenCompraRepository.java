package uniandes.edu.co.demo.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;

import uniandes.edu.co.demo.modelo.DetalleOrdenCompra;
import uniandes.edu.co.demo.modelo.OrdenCompra;

public interface OrdenCompraRepository extends MongoRepository<OrdenCompra, Integer> {

    // Crear un nuevo bar

    default void insertarOrden(int sucursalId, int proveedorId, Date fecha_entrega, List<Integer> productos, List<Integer> cantidades, List<Integer> precios){
        OrdenCompra orden = new OrdenCompra();
        orden.setSucursal(sucursalId);
        orden.setProveedor(proveedorId);
        orden.setFechaEsperadaEntrega(fecha_entrega);
        orden.setEstado("VIGENTE");
        orden.setFechaCreacion(new Date());
        List<DetalleOrdenCompra> detalles = new ArrayList<>();
        DetalleOrdenCompra detalleOrden = new DetalleOrdenCompra();
        for(int i = 0; i < productos.size(); i++){
            detalleOrden.setProductoId(productos.get(i));
            detalleOrden.setCantidad(cantidades.get(i));
            detalleOrden.setPrecioUnitario(precios.get(i));
            detalles.add(detalleOrden);
        }
        orden.setDetallesOrdenCompra(detalles);
        save(orden);
    }


    // Encontrar por id
    @Query("{id: ?0}")
    OrdenCompra obtenerOrdenPorId(int id);
    
}
