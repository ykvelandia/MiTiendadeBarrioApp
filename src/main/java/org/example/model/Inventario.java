package org.example.model;

import org.example.model.product.Producto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Inventario {
    private static List<Producto> productsList = new ArrayList<>();

    public static void addProduct() {
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


    }
    public static void viewStock(){

        for (Producto product:productsList) {
            System.out.println(product.toString());

        }
    }

    public List<Producto> getProductsList() {
        return productsList;

    }
}
