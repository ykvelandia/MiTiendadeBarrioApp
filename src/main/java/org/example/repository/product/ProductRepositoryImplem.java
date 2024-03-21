package org.example.repository.product;

import org.example.model.product.Producto;
import org.example.repository.product.mongo.ProductMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepositoryImplem  implements ProductRepository  {

    @Autowired
    private ProductMongoRepository productMongoRepository;

    @Override
    public List<Producto> getAllProduct() {
        return productMongoRepository.findAll();
    }

    @Override
    public Producto findProductById(String id) {
        return productMongoRepository.findById(id).get();
    }

    @Override
    public Producto saveProduct(Producto producto) {
        return productMongoRepository.save(producto);
    }

    @Override
    public Boolean updateProduct(String id, Producto producto) {
        Optional<Producto> foundOptionalProduct = Optional.ofNullable(findProductById(id));
        if (foundOptionalProduct.isPresent()){
            Producto existingProduct = foundOptionalProduct.get();
            existingProduct.setName(producto.getName());
            existingProduct.setDescription(producto.getDescription());
            existingProduct.setCategory(producto.getCategory());
            existingProduct.setTags(producto.getTags());
            existingProduct.setPrice(producto.getPrice());
            existingProduct.setUrlFoto(producto.getUrlFoto());

            productMongoRepository.save(existingProduct);
            return true;
        }
        return false;
    }

    @Override
    public Boolean deleteProductById(String id) {
        Producto foundProducto = findProductById(id);
        if (foundProducto != null){
            productMongoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
