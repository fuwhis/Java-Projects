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
        m1.add("Create Student");
        m1.add("Find and Sort (Not available)");
        m1.add("Update and Delete (Not available)");
        m1.add("Report (Not available)");
        m1.add("Exit");
        Menu m2 = new Menu();
        m2.add("Create Student");
        m2.add("Find and Sort");
        m2.add("Update and Delete");
        m2.add("Report");
        m2.add("Exit");

        StudentManager std = new StudentManager();
        int choice;
        do {
            System.out.println("-----STUDENT MANAGE PROGRAM----");
            if (std.isEmpty()) {
                m1.display();
            } else {
                m2.display();
            }
            choice = Menu.getChoice();
            switch (choice) {
                case 1:
                    std.create();
                    break;
                case 2:
                    if (std.isEmpty()) {
                        System.out.println("Empty list, not available!");
                        break;
                    }
                    std.findSort();
                    break;
                case 3:
                    if (std.isEmpty()) {
                        System.out.println("Empty list, not available!");
                        break;
                    }
                    std.updateDelete();
                    break;
                case 4:
                    if (std.isEmpty()) {
                        System.out.println("Empty list, not available!");
                        break;
                    }
                    std.report();
                    break;
                case 5: 
                    System.out.println("Exiting, Gooodbye....");
                    return;
                default:
                    System.out.println("Invalid choice!");
                    break;
            }
        } while (choice > 0 && choice < 5);
    }

}
