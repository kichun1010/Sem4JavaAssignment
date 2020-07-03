
import Factory.CoffeeProduct;
import Command.ViewProductCommand;
import Command.RedoCommand;
import Command.DisplayActionListCommand;
import Command.DeliverProductCommand;
import Command.CoffeeProductCommand;
import Command.Command;
import Command.UndoCommand;
import Command.CollectProductCommand;
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
public class test {

    public static void main(String[] args) {
        boolean cont = true;
        Scanner sc = new Scanner(System.in);
        Vector<Command> commands = new Vector();
        Vector<CoffeeProduct> product = new Vector();
        Vector<Command> redoList = new Vector();

        try {
            while (cont) {
                System.out.println("\nCoffee Inventory Management System");
                System.out.println("Please enter command: [a | v | c | s | u | r | sl | x]");
                System.out.println("a = add product, v = view products, c = collect product, s = ship product,");
                System.out.println("u = undo, r = redo, sl = show list undo/redo, x = exit system");
                String line = sc.nextLine();
                if (line.equals("x")) {
                    cont = false;
                    System.out.println("Thanks for using Coffee Inventory Management System!!");
                } else if (line.equals("a")) {
                    Command com = new CoffeeProductCommand(product);
                    com.execute();
                    commands.add(com);
                } else if (line.equals("v")) {
                    Command com = new ViewProductCommand(sc, product);
                    com.execute();
                } else if (line.equals("c")) {
                    Command com = new CollectProductCommand(sc, product);
                    com.execute();
                    if (com.getPass()==true) {
                        commands.add(com);
                    }
                } else if (line.equals("s")) {
                    Command com = new DeliverProductCommand(sc, product);
                    com.execute();
                    if (com.getPass()==true) {
                        commands.add(com);
                    }
                } else if (line.equals("u")) {
                    Command com = new UndoCommand(commands, redoList);
                    com.execute();
                } else if (line.equals("r")) {
                    Command com = new RedoCommand(commands, redoList);
                    com.execute();
                } else if (line.equals("sl")) {
                    Command com = new DisplayActionListCommand(commands, redoList);
                    com.execute();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
