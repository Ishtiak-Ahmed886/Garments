/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.garment_project;

 class Garment {
    public String id;
    public String name;
    public String description;
    public String size;
    public String color;
    public double price;
    public int stockQuantity;
    public Fabric fabric;

    public Garment(String id, String name, String description, String size, String color, double price, int stockQuantity, Fabric fabric) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.size = size;
        this.color = color;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.fabric = fabric;
    }

    public void updateStock(int quantity) {
        this.stockQuantity += quantity;
    }

    public double calculateDiscountPrice(double discountPercentage) {
        return price - (price * discountPercentage / 100);
    }
}
  class Fabric {
    public String id;
    public String type;
    public String color;
    public double pricePerMeter;

  

    public double calculateCost(double meters) {
        return pricePerMeter * meters;
    }
}


public class Garment_project {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
