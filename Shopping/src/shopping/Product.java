/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shopping;

import java.util.ArrayList;

/**
 *
 * @author Taciana Albertina
 */
public class Product extends Items {
    
    String type;
    int qtd;
    float wieght;
    
    
  /**
  * Product class constructor
  * The constructor creates a new Product object and initializes its members with the values passed as parameters. 
  * The quantity is set to zero, indicating that initially the product has no defined quantity.
  * 
  */
    public Product(String name_item, float price, float size, String information, String type, float wieght) {
        super(name_item, price, size, information);
        this.type = type;
        this.qtd = 0;
    }
    
     /**
      * public constructor for the Product class. It accepts parameters that represent the information needed to create a new product: 
      * new_name (name), new_price (price), new_size (size), new_information (information/detail), new_type (type) and new_qtd (quantity).
      * The call super(new_name, new_price, new_size, new_information) invokes the constructor of the parent class and passes the basic information to it
      */
    public Product(String new_name, float new_price, float new_size, String new_information, String new_type, int new_qtd) {
        super(new_name, new_price, new_size, new_information);
        
        this.type = new_type;
        this.qtd = new_qtd;

    }
    
  /**
  * Clone the Product object
  * @return the cloned Product object
  * This cloneOject() function creates a new Product object based on the basic information for the current product. 
  * It extracts the product information, creates a new Product object with that information, and returns it. 
  * The function also displays some informational messages during its execution.
  */
    public Product cloneOject() {
        System.out.println("Aqui no método");
        ArrayList<String> basicInformations = this.getBasicInformations(); //
        System.out.println("Basic informations obtained");
        
        
        return new Product(basicInformations.get(0), //creates and returns a new Product object. The object is initialized with the values obtained from the basicInformations list
                /*Each value is retrieved from the list using the get() method and converted 
                to the appropriate data type (such as float or integer) when necessary.*/
                Float.parseFloat(basicInformations.get(1)),
                Float.parseFloat(basicInformations.get(2)),
                basicInformations.get(3),
                basicInformations.get(4),
                Integer.parseInt(basicInformations.get(5)) 
        );
    }
    
    /*This getProperty() function returns a string representation of the product's properties.*/
    public String getProperty() {
        /*qtd_converted which will be used to store the converted quantity in string format.
        If the value of this.qtd is greater than 0, otherwise it evaluates to an empty string "".*/
        String qtd_converted = this.qtd > 0 ? ("\nAmount: " + Integer.toString(this.qtd))  : "";
        
        /*creates a string called Property that contains information about the product.
        Information includes name, price, details, size and, converted to string format*/
        String Property = "Name: " + this.name_item + 
                          "\nPrice: " + this.price + 
                          "\nDetail: " + this.information + 
                          "\nSize: " + this.size + 
                           qtd_converted;
        return Property; //returns the string Property,
    }
/**
  * Defines the quantity of the product
     * @param qtd
  */
    public void setQtd(int qtd) {
        this.qtd = qtd;
    }
    
/**
  * Gets the quantity of the product
  * @return the quantity of the product
  */
    public int getQtd() {
        return this.qtd;
    }
    
    public float getTotalValue() {
        return this.qtd * this.price;
    }
    
    /*private method called get Basic Informations() that returns a list of strings (ArrayList<String>). 
     *It also creates a new list called informations to store the basic information.
     */
    private ArrayList<String> getBasicInformations() {
        ArrayList<String> informations = new ArrayList<>();
        informations.add(this.name_item);
        informations.add( Float.toString(this.price) );//convert to String
        informations.add( Float.toString(this.size) ); //convert to String
        informations.add( information);
        informations.add(this.type);
        informations.add(Integer.toString(this.qtd) );
        
        return informations; //returns the informations list containing all the basic product information.
    }
    
}
