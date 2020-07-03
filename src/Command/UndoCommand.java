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
public class UndoCommand implements Command {

    private Vector<Command> commands, redoList;

    public UndoCommand(Vector<Command> commands, Vector<Command> redoList) {
        this.commands = commands;
        this.redoList = redoList;
    }

    public void execute() {
        Command c = commands.get(commands.size() - 1);
        c.undo();
        commands.remove(c);
        redoList.add(c);
        System.out.println("undo completed");
    }

    public void undo() {
    }

    public void redo() {
    }

    public boolean getPass() {
        return true;
    }
}
