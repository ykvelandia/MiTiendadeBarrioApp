package org.example.repository.product.mongo;

import org.example.model.product.Producto;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductMongoRepository extends MongoRepository<Producto,String> {
}
