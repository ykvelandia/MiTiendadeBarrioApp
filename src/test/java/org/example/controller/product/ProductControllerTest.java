package org.example.controller.product;

import org.example.dto.product.ProductResponseDto;
import org.example.service.product.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class ProductControllerTest {

    @Mock
    private ProductService productService;

    @InjectMocks
    private ProductController productController;
    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void getAllProducts(){
        List<ProductResponseDto> productResponseDtos = Arrays.asList(new ProductResponseDto("12","Leche Alpina Entera","Paca x 6 und","Lacteo/Huevos y refrigerados","Leches",16.200,"https://metrocolombiafood.vteximg.com.br/arquivos/ids/266047-750-750/7702001041411.jpg?v=637230837843670000"));
        when(productService.getAllProduct()).thenReturn(productResponseDtos);

        ResponseEntity<List<ProductResponseDto>> responseEntity = productController.getAllProduct();
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(productResponseDtos, responseEntity.getBody());
    }
}