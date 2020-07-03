package Factory;


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
public class CoffeeProduct {
    private String name;
    private int productID;
    private int qty;
    
    public CoffeeProduct(String name,int productID){
        this.name=name;
        this.productID=productID;
    }
    
    public String toString(){
        return "ID: "+getProductID()+"\nName: "+getName()+"\nQuantity: "+getQty();
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public int getProductID(){
        return productID;
    }
    
    public void setProductID(int productID){
        this.productID=productID;
    }
    
    public int getQty(){
        return qty;
    }
    
    public void setQty(int qty){
        this.qty=qty;
    }
    
    public static CoffeeProduct searchProduct(Vector<CoffeeProduct>product,int productID){
        for(CoffeeProduct coffeeProduct:product){
            if(coffeeProduct.getProductID()==productID)
                return coffeeProduct;
            
        }
        return null;
    }
}
