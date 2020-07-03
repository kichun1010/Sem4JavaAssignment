package Command;


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
public class DeliverProductCommand implements Command {

    private Scanner sc;
    Vector<CoffeeProduct> product;
    private int index, num, calories;
    private double weight;
    String name,qtyS;
    int qty,productID,recordQty;
    CoffeeProduct p;
    boolean pass = true;

    public DeliverProductCommand(Scanner sc, Vector<CoffeeProduct> product) {
        this.sc = sc;
        this.product = product;
    }

    public void execute() {
        try {
            System.out.println("Enter code:");
            String id = sc.nextLine();
            productID = Integer.parseInt(id);
            CoffeeProduct cp = CoffeeProduct.searchProduct(product, productID);
            if (cp == null) {
                System.out.println("The required item has not been created!");
                return;
            } else {
                System.out.println("Quantity to ship:");
                qtyS = sc.nextLine();
                qty = Integer.parseInt(qtyS);
                for (CoffeeProduct coffeeProduct : product) {
                    String[] record = coffeeProduct.toString().split("\n");
                    int recordID = Integer.parseInt(getRecord(record[0]));
                    name = getRecord(record[1]);
                    recordQty = Integer.parseInt(getRecord(record[2]));
                    if (record.length > 4) {
                        num = Integer.parseInt(getRecord(record[3]));
                        calories = Integer.parseInt(getRecord(record[4]));
                    } else {
                        weight = Double.parseDouble(getRecord(record[3]));
                    }
                    if (recordID == productID) {
                        p=coffeeProduct;
                        recordQty -= qty;
                        if (recordQty >= 0) {
                            System.out.println("Shipped " + qty + " packs of " + name + ". Current quantity is " + recordQty + ".");
                            coffeeProduct.setQty(recordQty);
                        } else {
                            System.out.println("Invalid quantity (current balance is less than required quantity). Try again!!!");
                            pass=false;
                            return;
                        }
                    }//1001,Premium Coffee Candy,50,15
                    //2001,Colombia Coffee,250
                    index++;
                }

            }
        } catch (NumberFormatException e) {
            System.out.println("The required item has not been created!");
        }
    }
    
    public boolean getPass(){
        return pass;
    }
    

    public String getRecord(String record) {
        String[] records = record.split(": ");
        return records[1];
    }

    public String toString(){
        return "Shipped "+qty + " " + p.getName() + "(" + p.getProductID() +")";
    }
    public void undo(){
        p.setQty(p.getQty()+qty);
    }
    public void redo(){
        p.setQty(p.getQty()-qty);
    }
}
//1001,Premium Coffee Candy,50,15
//2001,Colombia Coffee,250