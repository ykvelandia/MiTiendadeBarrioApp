

//Colección de productos y procesamiento de datos
/*Abre tu proyecto integrador en IntelliJ Idea.
 -Implementa una clase ProductsArray similar a la que implementaste en el laboratorio
 pero que almacene 20 productos(en vez de nombres).
 -Implementa una función para mostrar los productos que comienzan por una letra pasada por parámetro.
 -Implementa una función que imprima la lista de productos en orden alfabético.
 Instancia la clase creada ProductsArray en tu método main y prueba que funcione.
 Sube los cambios a tu repositorio y comparte el enalce:*/
package model;
import java.util.Arrays;

public class ProductsArray {


    private static String[] products;

    public ProductsArray() {

        String [] products = new String [20];

        products[0] = "Toalla Super Blanko";
        products[1] = "Lustramubles Pride ";
        products[2] = "Zen Bebida Frutos Rojos";
        products[3] = "Yuca Croqueta Calypso";
        products[4] = "Cigarrillos Malboro ";
        products[5] = "Pañal Pequeñin Etapa 5";
        products[6] = "Shampoo H&S Proteccion Caida";
        products[7] = "Jabon en Barra Vel Rosita";
        products[8] = "Kola Graulada Tarrito Rojo JGB Fresa";
        products[9] = "Aceite Gourmet ";
        products[10] = "Arroz Casanare";
        products[11] = "Tricompleto El Rey";
        products[12] = "Harina de Trigo Haz de Oros";
        products[13] = "Gelatina en Polvo Frutiño";
        products[14] = "Arequipe Alpina";
        products[15] = "Termo Imusa 1 Litro";
        products[16] = "Portacomida Darnel J2";
        products[17] = "Helado Popsy Tres Leches";
        products[18] = "Bombillo Led Phillips 4.5w";
        products[19] = "Comida Humeda Felix Carne Gatitos";
    }

    ProductsArray productsArray = new ProductsArray();
    public static void showProducts(){
        for(String product: products){
            if(product.startsWith("A")){
                System.out.print(product + " " );
            }
        }
    }

    public static void alphabeticOrder(){
        Arrays.sort(products);
        System.out.println("\nNombres de productos en orden alfabético");
        //System.out.println(Arrays.toString(products));
        for(String product: products){
            System.out.print(product + " ");
        }
    }
}