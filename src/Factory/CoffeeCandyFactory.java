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
public class CoffeeCandyFactory extends CoffeeProductFactory{
    private String name;
    private int productID;
    private int noOfCandy;
    private int caloriesPerCandy;
    
    public CoffeeCandyFactory(String name,int productID,int noOfCandy,int caloriesPerCandy){
        this.name=name;
        this.productID=productID;
        this.noOfCandy=noOfCandy;
        this.caloriesPerCandy=caloriesPerCandy;
    }
    
    public CoffeeProduct createProduct(){
        return new CoffeeCandy(name,productID,noOfCandy,caloriesPerCandy);
    }
}
