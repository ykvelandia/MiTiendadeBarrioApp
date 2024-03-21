package org.example.dto.product;

import org.example.model.product.Producto;

public class ProductMapper {
    public static ProductResponseDto Product_To_ProductResponseDto(Producto producto){
        if(producto==null){
            return null;
        }

        return new ProductResponseDto(
                producto.getId(),
                producto.getName(),
                producto.getDescription(),
                producto.getCategory(),
                producto.getTags(),
                producto.getPrice(),
                producto.getUrlFoto()

        );
    }

    public static Producto ProductDto_To_Product (ProductDto productDto){

        double price= (productDto.getPrice() == 0) ? 0.0 : productDto.getPrice();
        return new Producto(
                productDto.getName(),
                productDto.getDescription(),
                productDto.getCategory(),
                productDto.getTags(),
                price,
                productDto.getUrlFoto()
        );
    }
}
