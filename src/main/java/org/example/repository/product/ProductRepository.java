package org.example.repository.product;

import org.example.model.product.Producto;

import java.util.List;

public interface ProductRepository {
    List<Producto> getAllProduct();

    Producto findProductById(String id);

    Producto saveProduct(Producto producto);

    Boolean updateProduct(String id, Producto producto);

    Boolean deleteProductById(String id);
}
