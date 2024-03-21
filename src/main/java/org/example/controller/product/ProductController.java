package org.example.controller.product;

import org.example.dto.product.ProductDto;
import org.example.dto.product.ProductResponseDto;
import org.example.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("v1/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    public ResponseEntity<List<ProductResponseDto>>getAllProduct(){
        List<ProductResponseDto> responseDtos = productService.getAllProduct();
        System.out.println("Response: " + responseDtos);
        return new ResponseEntity<>(responseDtos, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDto> findProductById(@PathVariable String id){
        try{
            ProductResponseDto responseDto  = productService.findProductById(id);
            return new ResponseEntity<>(responseDto, HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping
    public ResponseEntity<ProductResponseDto> saveProduct(@RequestBody ProductDto productDto){
        return new ResponseEntity<>(productService.saveProduct(productDto),HttpStatus.CREATED);
    }
    @PutMapping("/{idProduct}")
    public ResponseEntity<Boolean> updateProduct(@PathVariable String id, @RequestBody ProductDto productDto){
        try{
            Boolean updateProduct = productService.updateProduct(id,productDto);
            if (updateProduct){
                return new ResponseEntity("The product update is ok",HttpStatus.OK);
            }else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }catch (NoSuchElementException e){
            return new ResponseEntity("The prouduct "+ id + "is not on the base ",HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{idProduct}")
    public ResponseEntity<Boolean> deleteProduct(@PathVariable String id){
        return new ResponseEntity<>(productService.deleteProductById(id),HttpStatus.OK);
    }

}
