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

    public void updateStock(int quantity) {
        this.stockQuantity += quantity;
    }

    public double calculateDiscountPrice(double discountPercentage) {
        return price - (price * discountPercentage / 100);
    }
}



public class Garment_project {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
