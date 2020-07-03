/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kichu
 */
public class CreateProductMemento implements Memento{
    private CoffeeProduct product;
    private String name;
    private int ProductID;
    
    public CreateProductMemento(CoffeeProduct product){
        this.product=product;
        this.name = product.getName();
        this.ProductID= product.getProductID();
    }
    
    public void restore(){
        product.setName(name);
        product.setProductID(ProductID);
    }
}
