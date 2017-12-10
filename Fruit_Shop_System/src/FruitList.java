
import checkvalid.CheckValid;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.Set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Quy Nguyen
 */
public class FruitList extends ArrayList<Fruit>{
    Hashtable<String, ArrayList<Order>> Orders = new Hashtable<>();
    
    public void display(){
        System.out.println("|| ID | Product | Quantity | Price ||");
        for(Fruit f: this){
            System.out.println(f.toString());
        }
        System.out.println("");
    }
    
    public void createFruit(){
        
        Scanner sc = new Scanner(System.in);
        do {   
            
            System.out.print("Please input fruit's ID: ");
            String id = sc.nextLine();
            System.out.print("Please input fruit's NAME: ");
            String name = sc.nextLine();
            System.out.print("Please input fruit's PRICE: ");
            double price = Double.parseDouble(sc.nextLine());
            System.out.print("Please input fruit's QUANTITY: ");
            int quantity = checkvalid.CheckValid.validPositive();
            System.out.print("Please input fruit's ORIGIN: ");
            String origin = sc.nextLine();
            this.add(new Fruit(id, name, origin, quantity, price));
            System.out.println("Do you want to continue? (Y/N)");
            String s = sc.nextLine().toUpperCase();
            if(s.equals("Y")){
                continue;
            }else if (s.equals("N")){
                break;
            }
        } while (true);
        display();
    }
    /**
     * Using Set<key> to browse all <key> of HashMap to view to Orders
     * @return each <key> of customer
     * @param key - Customer name, value - Order
     */
    public void viewOrder(){
        Set<String> key = Orders.keySet();
        for(String s: key){
            System.out.println("Customer: " + s);
            System.out.println(Orders.get(s));  
            double total = 0;
            for(int i = 0; i < Orders.get(s).size(); i++){
                total += Orders.get(s).get(i).getAmount();
            }
                System.out.println("Total: " + total + "$");
        }
    
    }
    
    /**
     * View the item that was chosen from list
     * @return the original size of item (selected - 1)
     */
    public int chooseItem(){
        while (true) {            
            System.out.print("Select the item:  ");
            int selected = CheckValid.validPositive();
            // Check selected item in list 
            if(selected == 0 || selected > this.size() + 1){
                System.out.println("Error! The item chosen that haven't been in list.");
            } else {
                return selected - 1;
            }
        }
    }
    /**
     * This function used to check the quantity of Fruit list. 
     * If the quantity < 0, return exception
     * @param choice
     */
    public int checkQuantity(int choice){
        while (true) {            
            int quantity = CheckValid.validPositive();
            if(quantity > this.get(choice).getQuantity()){
                System.out.println("Not enough the item, please try again!");
            } else {
                return choice; 
            }
        }   
    }
    
    public void shopping(){
        // display all fruit of list
        this.display();
        
        ArrayList<Order> bill = new ArrayList<>(); 
        
        while(true){
            int choice = this.chooseItem();
            System.out.println("You selected:  " + this.get(choice).getName());
            System.out.print("Please input the quantity:  ");
            int quantity = checkQuantity(choice);
            
            // Subtract the Amount of Order list. 
            this.get(choice).setQuantity(this.get(choice).getQuantity() - quantity);
            // Create order 
            Order o = new Order(choice, this.get(choice).getName(), quantity
                    , this.get(choice).getPrice(), (quantity*this.get(choice).getPrice()));
            // Add new order to bill
            bill.add(o);
            
            System.out.println("Do you want to order now? (Y/N)");
            Scanner sc = new Scanner(System.in);
            String s = sc.nextLine().toUpperCase();
            
            if(s.equals("Y") || s.equals("N")){
                if(s.equals("Y")){
                    System.out.println("|| Product || Quantity || Price || Amount ||");
                    for (int i = 0; i < bill.size(); i++){
                        System.out.println(bill.get(i).toString());
                    }
                    System.out.print("Please give customer name: ");
                    String name = sc.nextLine();
                    Orders.put(name, bill);  // Use name as key, bill like value
                    System.out.println("(^_^) Order sucessfull! (^_^)");
                    System.out.println("");
                    return; 
                } else if (s.equals("N")) {
                    continue;
                }
            }
        }
    }
}
