/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.garment_project;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    public Fabric(String id, String type, String color, double pricePerMeter) {
        this.id = id;
        this.type = type;
        this.color = color;
        this.pricePerMeter = pricePerMeter;
    }

    public double calculateCost(double meters) {
        return pricePerMeter * meters;
    }
}
 class Customer {
    public String customerId;
    public String name;
    public String email;
    public String phone;
    public List<Order> orders;

    public Customer(String customerId, String name, String email, String phone) {
        this.customerId = customerId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.orders = new ArrayList<>();
    }
    public void placeOrder(Order order) {
        orders.add(order);
    }

    public List<Order> viewOrders() {
        return orders;
    }
}
 class Inventory {
    public List<Garment> garments;

    public Inventory() {
        this.garments = new ArrayList<>();
    }

    public void addGarment(Garment garment) {
        garments.add(garment);
    }

    public void removeGarment(String id) {
        garments.removeIf(g -> g.id.equals(id));
    }

    public Garment findGarment(String id) {
        for (Garment garment : garments) {
            if (garment.id.equals(id)) {
                return garment;
            }
        }
        return null;
    }
}
 class Order {
    public String orderId;
    public Date orderDate;
    public List<Garment> garments;
    public double totalAmount;

    public Order(String orderId, Date orderDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.garments = new ArrayList<>();
    }

    public void addGarment(Garment garment) {
        garments.add(garment);
        calculateTotalAmount();
    }

    public double calculateTotalAmount() {
        totalAmount = 0;
        for (Garment garment : garments) {
            totalAmount += garment.calculateDiscountPrice(0);
        }
        return totalAmount;
    }

    public void printOrderDetails() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Order Date: " + orderDate);
        System.out.println("Total Amount: $" + totalAmount);
        System.out.println("Garments in Order:");
        for (Garment garment : garments) {
            System.out.println(" - " + garment.id + ": " + garment.name);
        }
    }
}
 class RMGSystem {
    public static void main(String[] args) {
        Fabric cotton = new Fabric("F1", "Cotton", "White", 10.0);
        Fabric polyester = new Fabric("F2", "Polyester", "Blue", 8.0);

        Supplier supplier = new Supplier("S1", "Fabric Supplier Co.", "contact@fabricco.com");
        supplier.addFabric(cotton);
        supplier.addFabric(polyester);

        Garment tshirt = new Garment("G1", "T-shirt", "Comfortable cotton t-shirt", "M", "White", 15.0, 50, cotton);
        Garment pants = new Garment("G2", "Pants", "Stylish blue polyester pants", "L", "Blue", 25.0, 30, polyester);

        Inventory inventory = new Inventory();
        inventory.addGarment(tshirt);
        inventory.addGarment(pants);

        Customer customer = new Customer("C1", "John Doe", "johndoe@example.com", "123-456-7890");

        Order order = new Order("O1", new Date());
        order.addGarment(tshirt);
        order.addGarment(pants);

        customer.placeOrder(order);
        order.printOrderDetails();
    }
}

 class Supplier {
    public String id;
    public String name;
    public String contactInfo;
    public List<Fabric> suppliedFabrics;

    public Supplier(String id, String name, String contactInfo) {
        this.id = id;
        this.name = name;
        this.contactInfo = contactInfo;
        this.suppliedFabrics = new ArrayList<>();
    }

    public void addFabric(Fabric fabric) {
        suppliedFabrics.add(fabric);
    }

    public List<Fabric> getSuppliedFabrics() {
        return suppliedFabrics;
    }
}




