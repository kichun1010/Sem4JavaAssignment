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
public class CollectProductCommand implements Command {

    private Scanner sc;
    String name;
    Vector<CoffeeProduct> product;
    private int index, num, calories, recordQty;
    private double weight;
    int qty, productID;
    CoffeeProduct p;
    boolean pass = true;

    public CollectProductCommand(Scanner sc, Vector<CoffeeProduct> product) {
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
                System.out.println("Quantity to receive:");
                String qtyS = sc.nextLine();
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
                        p = coffeeProduct;
                        recordQty += qty;
                        System.out.println("Received " + qty + " packs of " + name + ". Current quantity is " + recordQty + ".");
                        coffeeProduct.setQty(recordQty);
                    }//1001,Premium Coffee Candy,50,15
                    //2001,Colombia Coffee,250
                    index++;
                }

            }
        } catch (NumberFormatException e) {
            System.out.println("The required item has not been created!");
            pass = false;
        }
    }

    public String getRecord(String record) {
        String[] records = record.split(": ");
        return records[1];
    }

    public String toString() {
        return "Received " + qty + " " + p.getName() + "(" + p.getProductID() + ")";
    }

    public void undo() {
        p.setQty(p.getQty() - qty);
    }

    public void redo() {
        p.setQty(p.getQty() + qty);
    }

    public boolean getPass() {
        return pass;
    }
}
