package uniandes.edu.co.demo.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bson.Document;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProductoRepositoryCustom {

    private final MongoTemplate mongoTemplate;

    public ProductoRepositoryCustom(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public List<Document> obtenerProductosSegunCaracteristicas(int precioInicial, int precioFinal, 
            Date fechaVencimientoMax, String nombreSucursal, 
            Integer categoriaId) {
            // Construir el pipeline de agregación
            List<Document> pipeline = List.of(
            // Vincular productos con la información de las sucursales
            new Document("$lookup", new Document()
                .append("from", "sucursales")
                .append("localField", "_id")
                .append("foreignField", "bodegas.productos.productoId")
                .append("as", "sucursal_data")),

            // Descomponer la matriz de sucursales
            new Document("$unwind", "$sucursal_data"),

            // Descomponer la matriz de bodegas
            new Document("$unwind", "$sucursal_data.bodegas"),

            // Descomponer la matriz de productos en bodegas
            new Document("$unwind", "$sucursal_data.bodegas.productos"),

            // Filtrar los documentos según las características
            new Document("$match", new Document()
                .append("precio_venta", new Document("$gte", precioInicial).append("$lte", precioFinal))
                .append("fecha_expiracion", new Document("$lte", fechaVencimientoMax))
                .append("sucursal_data.nombre", nombreSucursal)
                .append("sucursal_data.bodegas.productos.cantidad", new Document("$gt", 0))
                .append("categoria_id", categoriaId)),

            // Proyección para devolver solo los campos relevantes
            new Document("$project", new Document()
                .append("_id", 1)
                .append("nombre", 1)
                .append("precio_venta", 1)
                .append("fecha_expiracion", 1)
                .append("sucursal", "$sucursal_data.nombre")
                .append("categoria_id", 1))
            );

        // Ejecutar la consulta y devolver el resultado
        return mongoTemplate.getCollection("productos").aggregate(pipeline).into(new ArrayList<>());
        }

}
