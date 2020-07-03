/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kichu
 */
public class DeliverProductMemento implements Memento{
    private DeliverProductCommand product;
    private String name;
    private int qty,productID;
    
    public DeliverProductMemento(DeliverProductCommand product){
        this.product=product;
        this.name = product.name;
        this.qty = product.qty;
        this.productID = product.productID;
    }
    
    public void restore(){
        product.name = this.name;
        product.qty = this.qty;
        product.productID = this.productID;
    }
}
