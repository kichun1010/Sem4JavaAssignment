package Command;


import Factory.CoffeeCandyFactory;
import Factory.CoffeeProduct;
import java.util.Scanner;
import java.util.Stack;
import java.util.Vector;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kichu
 */
public class CoffeeCandyCommand extends CoffeeProductCommand {
    private Scanner sc = new Scanner(System.in);
    Stack<Command> commands = new Stack();
    String name;
    int productID;
    CoffeeProduct p;

    public CoffeeCandyCommand(Scanner sc,Vector <CoffeeProduct> product) {
        super(product);
    }
    
    public void execute() {
        System.out.println("Enter product Id,name,number of candy and calories per candy:");
        String line = sc.nextLine();
        String[] record = line.split(",");
        int productID = Integer.parseInt(record[0]);
        name = record[1];
        int noOfCandy = Integer.parseInt(record[2]);
        int caloriesPerCandy = Integer.parseInt(record[3]);
        p=new CoffeeCandyFactory(name,productID,noOfCandy,caloriesPerCandy).createProduct();
        product.add(p);
        System.out.println("New product record created.");
        
    }
    
    public void undo(){
        p = product.remove(product.size()-1);
    }
    
    public void redo(){
        product.add(p);
    }
    
    public String toString(){
        return "Add "+p.getProductID()+" "+p.getName();
    }

}
