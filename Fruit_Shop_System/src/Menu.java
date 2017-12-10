
import checkvalid.CheckValid;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Quy Nguyen
 */
public class Menu extends ArrayList{
    
    public static int getChoice(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your option: ");
        int choice = CheckValid.validPositionWithoutZero();
        return choice; 
    }
    
    public void display(){
        for(int i=0; i<this.size(); i++){
            System.out.println((i+1) + ": " + this.get(i));
        }
    }
}
