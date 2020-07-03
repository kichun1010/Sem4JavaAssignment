package Command;


import Factory.CoffeePowderFactory;
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
public class CoffeePowderCommand extends CoffeeProductCommand {
    private Scanner sc = new Scanner(System.in);
    private CoffeeProduct p;

    public CoffeePowderCommand(Scanner sc,Vector <CoffeeProduct> product) {
        super(product);
    }
    
    public void execute() {
        System.out.println("Enter product Id,name,weight of the powder:");
        String line = sc.nextLine();
        String[] record = line.split(",");
        int productID = Integer.parseInt(record[0]);
        String name = record[1];
        double weight = Double.parseDouble(record[2]);
        p=new CoffeePowderFactory(name,productID,weight).createProduct();
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
