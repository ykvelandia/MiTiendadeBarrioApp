/*https://learn.ada-school.org/courses/63acef63f53e8a9a14f0fe81/cohorts/652e86a7583f80a7181f881c/sessions/6426493172dd2249f693ae87/content?moduleId=63ae4653bf1fbbcc6a9cd98c
1.Abre tu Proyecto Integrador en IntelliJ Idea
  2.Crea un nuevo paquete llamado model.
  3.Crea una nueva clase llamada Product:
  4.Implementa 4 nuevas funciones o métodos en la clase Product para:
    -Determinar si tu producto se quedo sin inventario.
    -Determinar si el precio de un producto es mayor a un valor pasado por parametro.
    -Determinar si el precio de un producto es menor o igual a un valor pasado por parametro.
    -Determinar si el nombre del producto contiene una palabra pasada por parametro.
    5.Crea una nueva instancia de la clase Product en el Main y
    veritfica cada una de las funciones implementadas .
    6.Has commit de tus cambios y subelos a tu repositorio remoto.
    7.Envía el enlace con tu solución.*/

package model;


public class Product {
    private String name;
    private double price;
    private int stock;

    public Product(String name, double price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    //-Determinar si tu producto se quedo sin inventario.
    public void avaliableStock(){
        if(stock <= 0){
            System.out.println("El producto no se encuentra en Stock.");
        } else {
            System.out.println("Hay " + stock + " item(s) en stock");
        }
    }
    // -Determinar si el precio de un producto es mayor a un valor pasado por parametro.
    public boolean higherPrice (double comparePrice){
        return  price > comparePrice;
    }

    //-Determinar si el precio de un producto es menor o igual a un valor pasado por parametro.
    public boolean lowerPrice (double comparePrice){
        return  price <= comparePrice;
    }

    //-Determinar si el nombre del producto contiene una palabra pasada por parametro.
    public boolean containsWords(String words) {
        return this.name.toLowerCase().contains(words.toLowerCase());
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "{ 'name':" + name + ", price:" + price + ", stock:" + stock + "}";
    }
}


