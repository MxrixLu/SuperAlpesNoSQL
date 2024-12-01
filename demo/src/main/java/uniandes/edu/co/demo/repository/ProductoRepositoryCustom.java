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

    public List<Document> obtenerProductosSegunCaracterisitas(Double precioInicial, Double precioFinal, Date fechaVencimientoMax, String sucursal, String categoria) {
    List<Document> pipeline = List.of(
            new Document("$match", new Document()
                    .append("precio", new Document("$gte", precioInicial).append("$lte", precioFinal))
                    .append("fecha_vencimiento", new Document("$lte", fechaVencimientoMax))
                    .append("sucursal", sucursal)
                    .append("categoria", categoria))
    );
    return mongoTemplate.getCollection("productos").aggregate(pipeline).into(new ArrayList<>());
}

}
