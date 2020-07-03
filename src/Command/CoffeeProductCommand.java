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
public class CoffeeProductCommand implements Command {
    private Scanner sc = new Scanner(System.in);
//    Stack<Command> commands = new Stack();
    Vector <CoffeeProduct> product;
    Command com;

    public CoffeeProductCommand(Vector <CoffeeProduct> product) {
        this.product=product;
    }
    
    public void execute() {
        System.out.println("Enter Coffee type (cc=Coffee Candy/cp=Coffee Powder):");
        String line = sc.nextLine();
        if(line.equals("cc")){
            com = new CoffeeCandyCommand(sc,product);
            com.execute();
//            commands.push(com);
        }else if(line.equals("cp")){
            com = new CoffeePowderCommand(sc,product);
            com.execute();
//            commands.push(com);
        }
    }
    
    public String toString(){
        return com.toString();
    }
    
    public void undo(){}
    public void redo(){}
    public boolean getPass(){
        return true;
    }
    
}
