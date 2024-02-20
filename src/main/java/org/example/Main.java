package org.example;

import org.example.model.*;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println(" ¡Bienvenid@ a Mi Tienda App!");
        System.out.println();

        ProductServiceArrayList productService  = new ProductServiceArrayList();
        productService.loadInventory("inventory.csv");

        ProductServiceI productServiceI = new ProductServiceArrayList();
        //Agregamos 2 productos
        Product product1 = new Product("Leche Entera Alpina",3100,20,"1");
        productServiceI.addProduct(product1);
        Product product2 = new Product("Yogurt Alpina Finesse Melocoton",10700,10,"2");
        productServiceI.addProduct(product2);
        System.out.println();
        //Obtenemos todos los productos
        List<Product> allProducts = productServiceI.getAllProducts();
        System.out.println("Todos los productos: ");
        allProducts.forEach(product -> System.out.println(product.getName()));
        System.out.println();
        //Encontrar por id
        String productIdToFind ="1";
        Product foundProduct = productServiceI.findById(productIdToFind);
        if (foundProduct == null){
            System.out.println("Producto encontrado " + productIdToFind + ":" + foundProduct.getName());
        }else {
            System.out.println("Producto no encontrado " + productIdToFind + ":" + foundProduct.getName());
        }
        System.out.println();
        //Eliminar por id
        String idToDelete ="2";
        productServiceI.deleteProduct(idToDelete);
        System.out.println();

        Main main = new Main();
        main.runMenu();

        //Instancia la clase creada ProductsArray en tu método main
        ProductsArray productsArray = new ProductsArray();
        productsArray.alphabeticOrder(productsArray.products);

        //Instancia de la clase Product en el Main y veritfica cada una de las funciones implementadas
        System.out.println();
        Product product = new Product("Arroz diana",2900,1,"01");
        System.out.println("Producto:" + product.getName());
        product.avaliableStock();
        product.higherPrice(2000);
        product.lowerPrice(80);
        product.containsWords("Prod");

        Inventario inventario = new Inventario();

        // Llamada al método para agregar un producto
        inventario.addProduct();

    }

    //Crea una función o método que te permita mostrar las opciones del menu:
    private void displayMenu() {

        System.out.println();
        System.out.println(
                """
                        |o|                         /////////////\\\\\\
                        |o|                        (((((((((((((   \\\\\\
                        |o|                        ))) ~~      ~~   (((
                        |o|                        ((( (*)     (*)  )))
                        |o|                        )))     <        (((\s
                        |o|                        ((( '\\______/`   )))\s
                        |o|                        )))\\___________/(((\s
                        |o|                        (((   _)  (_    )))\s\s
                        |o|                              /\\__/\\""");
        System.out.println("±----------------------------------------±");
        System.out.println("|   Administrador Mi Tienda de Barrio    |");
        System.out.println("±----------------------------------------±");
        System.out.println("---Ingrese una opcion de las siguientes:--");
        System.out.println("±----------------------------------------±");
        System.out.println("1. Agregar producto                      |");
        System.out.println("2. Eliminar producto                     |");
        System.out.println("3. Actualizar producto                   |");
        System.out.println("4. Ver todos los productos               |");
        System.out.println("5. Ver Inventario                        |");
        System.out.println("6. Ver productos en orden alfabético     |");
        System.out.println("7. Salir                                 |");
        System.out.println("±----------------------------------------±");
        System.out.print("   Ingresa tu opción:    (1 - 7)  ");

    }

    //Menu Opciones de App Mi Tienda de Barrio
    private  void handleUserChoice(int choice) {

        switch (choice) {
            case 1 -> Inventario.addProduct();
            case 2 -> RemoveProduct.removeProduct();
            case 3 -> UpdateProduct.updateProduct();
            case 4 -> ProductsArray.showProducts();
            case 5 -> Inventario.viewStock();
            case 6 -> ProductsArray.alphabeticOrder(ProductsArray.products);
            case 7 -> System.out.println("Saliendo...");
            default -> System.out.println("Opción invalida. Por favor intenta de nuevo.");
        }

    }

    //Implementa una función que te permita mostrar el menu y capturar la opción seleccionada por el usuario:
    public void runMenu() {
        int choice;
        Scanner scanner= new Scanner(System.in);
        do {
            displayMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            handleUserChoice(choice);
        } while (choice != 8);
    }

}