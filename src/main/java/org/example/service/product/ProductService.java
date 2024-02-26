package org.example.service.product;

import org.example.model.dto.product.ProductDto;
import org.example.model.dto.product.ProductResponseDto;

import java.util.List;

public interface ProductService {
    List<ProductResponseDto> getAllProduct();

    ProductResponseDto findProductById(String id);

    ProductResponseDto saveProduct(ProductDto productoDto);

    Boolean updateProduct(String id, ProductDto productDto);

    Boolean deleteProductById(String id);
}
