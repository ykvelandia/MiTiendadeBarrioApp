package org.example;

import org.example.model.product.Producto;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductServiceArrayList implements ProductServiceI{
    private List<Producto> productList;

    public ProductServiceArrayList() {
        this.productList = new ArrayList<>();
    }
    @Override
    public void addProduct(Producto product) {
        productList.add(product);
        System.out.println("Se ha agregado un producto " + product.getName());

    }
    @Override
    public void deleteProduct(String productId) {
        productList.removeIf(product -> product.getIdProduct().equals(productId));
        System.out.println("Producto eliminado con id: " +productId);

    }
    @Override
    public Producto findById(String productId) {
        return productList.stream()
                .filter((product -> product.getIdProduct().equals(productId)))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Producto> getAllProducts() {
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
