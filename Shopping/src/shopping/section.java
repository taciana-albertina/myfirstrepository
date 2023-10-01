/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shopping;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Taciana Albertina
 */
public class section {

    String name = new String(); //variable
    ArrayList<Product> Products = new ArrayList<>();

   /**
   * Constructs a section with the given name.
   * 
   * @param name The name of the section.
   */
    
    public section(String name) {
        this.name = name;
    }
   /**
   * Returns the name of the section.
   * 
   * @return The name of the section.
   */
    public String getName() {
        return name;
    }

    /**
    * Sets the name of the section.
    * 
    * @param name The name of the section.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
    * Adds an item to the section.
    * 
    * @param new_item The item to be added.
    */
    public void addItem(Product new_item) {
        Products.add(new_item);
    }

    /**
    * Removes an item from the section.
    * 
    * @param remove_item The item to be removed.
    */
    public void removeItem(Product remove_item) {
        Products.remove(remove_item);
    }

    /**
   * show us the section name.
   */
    public void showSection() {
        System.out.println(this.name + "\n");
    }
    
    /**
    * Returns all the products in the section.
    * 
    * @return The list of products in the section.
    */
    public ArrayList<Product> getAllProducts() {
        return this.Products;
    }
    
 /**
 * Returns the product at the specified index in the section.
 * 
 * @param index The index of the product.
 * @return The product at the specified index.
 */
    public Product getProduct(int index) {
        Product selectedProduct = null;
        try {
            selectedProduct = this.Products.get(index);
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return selectedProduct;
    }

}




