package org.example;

//https://learn.ada-school.org/courses/61ef5f536c7f00c6428b1fee/cohorts/652e86a7583f80a7181f881c/sessions/634b2053813c6b8c814ef5fb/content?moduleId=632dcf5bfb8aeeab418f55cb
import model.Inventario;
import model.Product;

import java.util.List;

public interface ProductServiceI {

    void addProduct(Product product );
    void deleteProduct(String productId);
    Product findById(String productId);
    List<Product> getAllProducts();
}
