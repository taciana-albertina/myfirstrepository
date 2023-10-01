/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shopping;

import java.util.ArrayList;

/**
 * A simple ShoppingBag
 * 
 * Stores items in an ArrayList
 * 
 * Possible to add  items
 * Also can "empty" the bag
 * 
 * You should NOT need to amend this code at all!
 * 
 * NOTE: 'Object' is the main base class for everything in Java. This means that everything 'is an' Object
 * ANy class you create will work with the shipping bag - you don't need to change this code!
 * 
 * @author Ken
 */
public class ShoppingBag {
    
    private ArrayList<Product> items;
    
    /**
     * Create a shopping bag by initialising the items to an empty arraylist
     */
    public ShoppingBag(){
        
        items = new ArrayList<Product>();
    }
    
    /**
     * Add an item to the shopping bag
     * @param someItem the item that has been bought
     */
    public void buyItem(Product someItem){
        this.items.add(someItem);
         //adds an item to the shopping bag
    }
    
 
    /**
     * create a formatted String containing all the items in the ShoppingBag
     * @return the formatted String
     * Also clears the items list -- 'empties the bag'
     */
    public String emptyBag(){
        
        String itemList = ""; //creates a formatted string containing all the items in the shopping bag.
        
        for(Product item: this.items){
            
            itemList = itemList + item.toString() + "\n";
        }
        
        this.items.clear(); //clears the list of items using the clear() and returns the itemList string.
        
        return itemList;
    }
    
    
    //chenge and add
  /**
  * here add new method to remove product from bag shopping
  * Removes a product from the shopping bag based on the given index.
  * @param index the index of the product to be removed
  */
    public void removeProduct(int index) {
        try {
            items.remove(index);
            
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }
  /**
  * Returns the number of products in the shopping bag.
  * @return the number of products in the shopping bag
  */
    public int getNumOfProducts() {
        return this.items.size();
    }
    
 /**
  * Returns the product from the shopping bag based on the given index.
  * @param index the index of the product
  * @return the product from the shopping bag
  */
    public Product getProduct(int index) {
        return this.items.get(index);
    }
/*here was added a getItems() method that returns the list of shopping bag items as an ArrayList. 
This allows other parts of the code to access the list of items and perform further operations if needed.*/
    public ArrayList<Product> getItems() {
        return items;
    }   
}
