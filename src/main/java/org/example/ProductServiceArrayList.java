package org.example;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import model.Product;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

    public void loadInventory(String csvFilePath){
        try {
            File file = new File("resources/inventory.csv");
            Scanner fileScanner = new Scanner(file);
            fileScanner.nextLine();
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] productInfo = line.split(",");
                System.out.println(productInfo[0]);
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

}
