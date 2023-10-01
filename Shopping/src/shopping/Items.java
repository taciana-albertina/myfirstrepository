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

/**
 * Class to represent an item in a shopping system.
 * It contains information about the name, price, size, and additional information of an item.
 */
public class Items {

    String name_item;  //Item name
    float price; //Item price
    float size; //Item Size
    String information; //Additional information about the item

/**
* Constructor for the Items class.
* Initializes the item with the provided name, price, size, and information.
 */ 
    public Items(String name_item, float price, float size, String information) {
         /* Constructor of the Items class */
        this.name_item = name_item;
        this.price = price;
        this.information = information;
        this.size = size;

    }

/**
* Sets the price to the given value if it is higher than the current price.
*
* @param price The new price to set.
*/  
    public void high_price(float price) {
        if (price > this.price) {
            this.price = price;
        }
    }

/**
* Sets the price to the given value if it is lower than the current price.
*
* @param price The new price to set.
*/
    public void down_price(float price) {
        if (price < this.price) {
            this.price = price;
        }
    }

}

