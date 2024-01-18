package org.example;

import model.Product;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class ProductServiceArrayList implements ProductServiceI{
    private List<Product> productList;

    public ProductServiceArrayList() {
        this.productList = new ArrayList<>();
    }
    @Override
    public void addProduct(Product product) {
        productList.add(product);
        System.out.println("Se ha agregado un producto " + product.getName());

    }
    @Override
    public void deleteProduct(String productId) {
        productList.removeIf(product -> product.getId().equals(productId));
        System.out.println("Producto eliminado con id: " +productId);

    }
    @Override
    public Product findById(String productId) {
        return productList.stream()
                .filter((product -> product.getId().equals(productId)))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Product> getAllProducts() {
        return new ArrayList<>(productList);
    }

}
