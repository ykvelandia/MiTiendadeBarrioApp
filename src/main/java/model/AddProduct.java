package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddProduct {
    private static List<Product> productsList = new ArrayList<>();


    public AddProduct() {
       // this.productsList = new ArrayList<>();
    }
    public static void addProduct(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el nombre del producto: ");
        String name = scanner.nextLine();

        System.out.print("Ingrese el precio del producto: ");
        double price = scanner.nextDouble();

        System.out.print("Ingrese el stock del producto: ");
        int stock = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Ingrese el id del producto: ");
        String id = scanner.nextLine();

        Product newProduct = new Product(name, price, stock,id);
        productsList.add(newProduct);
        System.out.println("Producto agregado exitosamente.");
        for (Product product:productsList) {
            System.out.println(product.toString());

        }
    }

    public List<Product> getProductsList() {
        return productsList;

    }
}
