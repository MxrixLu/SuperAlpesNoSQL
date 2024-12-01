package uniandes.edu.co.demo.repository;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SucursalRepositoryCustom {

    private final MongoTemplate mongoTemplate;

    public SucursalRepositoryCustom(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public List<Document> inventarioSucursal(String nombreSucursal) {
        List<Document> pipeline = List.of(
                new Document("$match", new Document().append("nombre", nombreSucursal)),
                new Document("$project" , new Document().append("nombreBodega", "$nombre")
                            .append("productos.nombreProducto", "$productos.nombreProducto"))
        );
        return mongoTemplate.getCollection("sucursales").aggregate(pipeline).into(new ArrayList<>());
    }

}
