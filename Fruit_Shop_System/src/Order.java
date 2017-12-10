/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Quy Nguyen
 */
public class Order {
    private String ID, name, origin;
    private double price, amount;
    private int quantity; 

//    public Order(String ID, String name, String origin, double price, double amount, int quantity) {
//        this.ID = ID;
//        this.name = name;
//        this.origin = origin;
//        this.price = price;
//        this.amount = amount;
//        this.quantity = quantity;
//    }

    Order(int choice, String name, int quantity, double price, double amount) {
        this.name = name; 
        this.quantity = quantity; 
        this.price = price; 
        this.amount = amount; 
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return this.name + " | " + this.quantity + " | " + this.price + "$ | " +  this.amount + "$";
    }
    
    
    
}
