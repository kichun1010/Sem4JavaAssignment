
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
public class CareTaker {
   private Vector undoList,redoList;
   
//   
   public CareTaker(){
       undoList=new Vector();
       redoList=new Vector();
   }
//   
//   public Memento createMemento(CoffeeProduct product){
//       return new Memento(product);
//   }
//   
//   public void saveMemento(CoffeeProduct product){
//       undoList.add(createMemento(product));
//   }
//   
   
   public void identifyCreate(Vector<Command> commands){
       for(Command c:commands){
            if(c instanceof CollectProductCommand){
                createCollectProductMemento((CollectProductCommand)c);
            }else if(c instanceof DeliverProductCommand){
                createDeliverProductMemento((DeliverProductCommand)c);
            }
       }
   }
   
   public void identifySave(Vector<Command> commands){
       for(Command c:commands){
            if(c instanceof CollectProductCommand){
                saveCollectProductMemento((CollectProductCommand)c);
            }else if(c instanceof DeliverProductCommand){
                saveDeliverProductMemento((DeliverProductCommand)c);
            }
       }
   }
   
   
   public void saveCollectProductMemento(CollectProductCommand product){
        undoList.add(createCollectProductMemento(product));
    }
   
   public void saveCreateProductMemento(CoffeeProduct product){
        undoList.add(createCreateProductMemento(product));
    }
   
   public void saveDeliverProductMemento(DeliverProductCommand d){
        undoList.add(createDeliverProductMemento(d));
    }
   
   public Memento createCollectProductMemento(CollectProductCommand product){
        return new CollectProductMemento(product);
    }
   
   public Memento createDeliverProductMemento(DeliverProductCommand d){
        return new DeliverProductMemento(d);
    }
   
   public Memento createCreateProductMemento(CoffeeProduct product){
        return new CreateProductMemento(product);
    }
   
   public void undo(){
       if(!undoList.isEmpty()){
           Memento memento = (Memento)undoList.get(undoList.size()-1);
           redoList.add(memento);
           undoList.remove(memento);
           memento.restore();
       }else{
           System.out.println("No more memento");
       }
   }
   
   public void redo(){
       undoList.add(redoList.get(redoList.size()-1));
   }
}
