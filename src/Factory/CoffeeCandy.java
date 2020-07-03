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
public class CoffeeCandy extends CoffeeProduct{
    private int noOfCandy;
    private int caloriesPerCandy;
    
    public CoffeeCandy(String name,int productID,int noOfCandy,int caloriesPerCandy){
        super(name,productID);
        this.noOfCandy=noOfCandy;
        this.caloriesPerCandy = caloriesPerCandy;
    }
    
    public int getNoOfCandy(){
        return noOfCandy;
    }
    
    public void setNoOfCandy(int noOfCandy){
        this.noOfCandy=noOfCandy;
    }
    
    public int getCaloriesPerCandy(){
        return caloriesPerCandy;
    }
    
    public void setCaloriesPerCandy(int caloriesPerCandy){
        this.caloriesPerCandy=caloriesPerCandy;
    }
    
    public String toString(){
        return super.toString()+"\nNumber of candies per package: "+getNoOfCandy()+"\nCalories Per candy: "+getCaloriesPerCandy();
    }
}
