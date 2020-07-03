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
public class CoffeePowder extends CoffeeProduct{
    private double weight;
    
    public CoffeePowder(String name,int productID,double weight){
        super(name,productID);
        this.weight = weight;
    }
    
    public double getWeight(){
        return weight;
    }
    
    public void setWeight(double weight){
           this.weight=weight;
    }
    
    public String toString(){
        return super.toString()+"\nWeight: "+getWeight();
    }
    
    
}
