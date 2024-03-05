package controller.product;

import org.apache.catalina.LifecycleState;
import org.example.controller.product.ProductController;
import org.example.dto.product.ProductResponseDto;
import org.example.service.product.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

public class ProductControllerTest {
    @Mock
    private ProductService productService;

    @InjectMocks
    private ProductController productController;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void get_all_products () {
        List<ProductResponseDto> products = new ArrayList<>();
        products.add(new ProductResponseDto("Leche Entera Alpina", "Bolsa x 1.100 ml", "Lacteo/Huevos y refrigerados", "Leches", 3100, "https://www.eurosupermercados.com/eurosupermercado2020//contenidos/images/ecommerce_productos/7702001041404.jpg"));
        products.add(new ProductResponseDto("Gelatina en Polvo Gel´'Hada ", "Pack x 3 und", "Dulces y Postres", "Gelatinas, flanes y pudines", 4700, "https://www.levapan.com/wp-content/uploads/2015/11/Prepack-de-3-Gelatina-Gel%C2%B4hada-40-g.jpg"));
        Mockito.when(productService.getAllProduct()).thenReturn(products);

        ResponseEntity<List<ProductResponseDto>> response = productController.getAllProduct();
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}