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
public class ViewProductCommand implements Command {

    private Scanner sc;
    private int productID;
    Vector<CoffeeProduct> product;

    public ViewProductCommand(Scanner sc, Vector<CoffeeProduct> product) {
        this.sc = sc;
        this.product = product;
    }

    public void execute() {
        try {
            System.out.println("Enter product Id. (* to show all):");
            String id = sc.nextLine();
            if (id.equals("*")) {
                System.out.println("Coffee Product information");
//            System.out.println("ID\tName\tQuantity\tOther Info");
                System.out.printf("%5s %30s %15s %30s", "ID", "Name", "Quantity", "Other Info");
                System.out.println("");
                for (CoffeeProduct coffeeProduct : product) {
                    String[] record = coffeeProduct.toString().split("\n");
                    int productID = Integer.parseInt(getRecord(record[0]));
                    String name = getRecord(record[1]);
                    int qty = Integer.parseInt(getRecord(record[2]));
                    if (record.length > 4) {
                        int num = Integer.parseInt(getRecord(record[3]));
                        int calories = Integer.parseInt(getRecord(record[4]));
//                    System.out.println(productID+"\t"+name+"\t"+qty+"\t\t"+num+" candy per package("+calories+" calories each)");
                        System.out.format("%5s %30s %15s %60s", productID, name, qty, num + " candy per package(" + calories + " calories each)");
                        System.out.println("");
                    } else {
                        double weight = Double.parseDouble(getRecord(record[3]));
//                    System.out.println(productID+"\t"+name+"\t"+qty+"\t\t"+weight+"g");
                        System.out.format("%5s %30s %15s %30s", productID, name, qty, weight + "g");
                        System.out.println("");
                    }
                }
//            2010,Colombia Coffee,250
//1010,Premium Coffee Candy,50,15
            } else {
                productID = Integer.parseInt(id);
                CoffeeProduct coffeeProduct = CoffeeProduct.searchProduct(product, productID);
                if (coffeeProduct == null) {
                    System.out.println("The required item has not been created!");
                    return;
                }
                System.out.println("Product Information");
                System.out.println(coffeeProduct.toString());
            }
        } catch (NumberFormatException e) {
            System.out.println("The required item has not been created!");
        }
    }

    public String getRecord(String record) {
        String[] records = record.split(": ");
        return records[1];
    }

    public void undo() {
    }

    public void redo() {
    }

    public boolean getPass() {
        return true;
    }
}
