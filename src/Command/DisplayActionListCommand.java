package Command;

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
public class DisplayActionListCommand implements Command {

    private Vector<Command> commands, redoList;

    public DisplayActionListCommand(Vector<Command> commands, Vector<Command> redoList) {
        this.redoList = redoList;
        this.commands = commands;
    }

    public void execute() {
        System.out.println("Undo List:");
        if (commands.size() == 0) {
            System.out.println("Empty");
        }
        for (Command c : commands) {
            System.out.println(c.toString());
        }
        System.out.println("");
        System.out.println("Redo List:");
        if (redoList.size() == 0) {
            System.out.println("Empty");
        }
        for (Command c : redoList) {
            System.out.println(c.toString());
        }
    }

    public void undo() {
    }

    public void redo() {
    }

    public boolean getPass() {
        return true;
    }
}
