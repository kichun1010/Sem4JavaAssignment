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
public class RedoCommand implements Command {

    private Vector<Command> commands, redoList;
    private UndoCommand u;

    public RedoCommand(Vector<Command> commands, Vector<Command> redoList) {
        this.commands = commands;
        this.redoList = redoList;
    }

    public void execute() {
        Command c = redoList.get(redoList.size() - 1);
        c.redo();
        commands.add(c);
        redoList.remove(c);
        System.out.println("redo completed");
    }

    public void undo() {
    }

    public void redo() {
    }

    public boolean getPass() {
        return true;
    }
}
