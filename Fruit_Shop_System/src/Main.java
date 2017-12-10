/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Quy Nguyen
 */
public class Main {

    public static void main(String[] args) {
        Menu m1 = new Menu();
        m1.add("Create Fruit.");
        m1.add("View Orders. (not available)");
        m1.add("Shopping. (not available)");
        m1.add("Exit.");
        Menu m2 = new Menu(); 
        m2.add("Create Fruit. (continue)");
        m2.add("View Orders.");
        m2.add("Shopping. (for buyer)");
        m2.add("Exit.");
        
        FruitList f = new FruitList();
        int choice; 
        do {       
            System.out.println("---FRUIT SHOPPING---");
            if(f.isEmpty()){
                m1.display();
            }else{
                m2.display();
            }
            choice = Menu.getChoice();
            switch(choice){
                case 1: 
                    f.createFruit();
                    break; 
                case 2: 
                    if (f.isEmpty()){
                        System.out.println("No fruit in list??? Please select option 1 at first to create list!");
                    }else{
                        f.viewOrder();
                    }
                    break; 
                case 3: 
                    if(f.isEmpty()){
                        System.out.println("No fruit in list??? Please select option 1 at first to create list!");
                    }else{
                        f.shopping();
                    }
                    break; 
                    default:
                        System.out.println("Program is exiting...");
                        System.out.println("See you later!!!");
                        break;
            }
        } while (choice > 0 && choice < 4);
    }
}
