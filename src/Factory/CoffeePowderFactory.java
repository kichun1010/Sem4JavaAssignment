package Factory;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kichu
 */
public class CoffeePowderFactory extends CoffeeProductFactory{
    private String name;
    private int productID;
    private double weight;
    
    public CoffeePowderFactory(String name,int productID,double weight){
        this.name=name;
        this.productID=productID;
        this.weight=weight;
    }
    
    public CoffeeProduct createProduct(){
        return new CoffeePowder(name,productID,weight);
    }
}
