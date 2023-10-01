/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package shopping;

import java.util.Scanner;
import java.io.IOException;
import java.util.ArrayList;

/**
 *The Shopping class represents a supermarket shopping simulation program.
 * Allows the user to select products, add to the shopping bag, remove items and complete the purchase.
 * 
 * @author Taciana Albertina
 */
public class Shopping {

    /**
     * Main method that starts the shopping program.
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args)  {

        /*Creating a new instance of the ShoppingBag class to represent my bag for shopping
        /*This bag will be used to store the items that the user buys.*/
        ShoppingBag userBag = new ShoppingBag(); //this is userBag. I can buy things to put in it

        /* This class contains methods for displaying menu options, receiving user input, and performing menu-related operations.*/
        IOUtils menuManager = new IOUtils();// new instance of the IOUtils class to manage the menu interactions

        /* Creating a list to store the types of payment options available
        *Three payment way: "credit card", "debit card" and "bank deposit slip". 
        *This list will be used later to display the payment options available to the user. 
         */
        ArrayList<String> typeOfPayment = new ArrayList<>();
        typeOfPayment.add("credit card"); //credit card
        typeOfPayment.add("debit card"); //debit card
        typeOfPayment.add("bank deposit slip"); //bank deposit

        /*creating a new instance of the SuperMarket class called BR, passing the typeOfPayment list as a parameter.
        *This creates a supermarket with the specified payment options.
         */
        SuperMarket BR = new SuperMarket(typeOfPayment);

        /* Creating a list to store the sections in the supermarket
        *This list will be used to store the different sections of the supermarket. 
        *Each section is represented by an object of the section class.
         */
        ArrayList<section> sections = new ArrayList<>();
        sections.add(new section("fresh food "));
        sections.add(new section("bakery"));
        sections.add(new section("drinks"));
        sections.add(new section("frozen food"));

        /*creating a list called fresh_food to store the products in the "fresh food" section of the supermarket. 
        The list is of type Product, indicating that it will store objects of the Product class.*/
        ArrayList<Product> fresh_food = new ArrayList<>();
        fresh_food.add(new Product("fish", (float) 2.99, 1, "healthy", "fresh food"));
        fresh_food.add(new Product("ice cream", (float) 2.99, 4, "sugar", "fresh food"));
        fresh_food.add(new Product("ice fruit", (float) 0.99, 500, "no sugar", "fresh food"));

        /*creating a list bakery to store the products in the "bakery" section of the supermarket. 
        The list is of type Product, indicating that it will store objects of the Product class.*/
        ArrayList<Product> bakery = new ArrayList<>();
        bakery.add(new Product("bread", (float) 0.99, 1 / 2, "whole grain", "bakery"));

        /*creating a list called drinks to store the products in the "drinks" section of the supermarket. 
        The list is of type Product, indicating that it will store objects of the Product class.*/
        ArrayList<Product> drinks = new ArrayList<>();
        drinks.add(new Product("DietCoke", (float) 1.39, 330, "no sugar", "drink"));

        /*creating a list called frozen_food to store the products in the "frozen food" section of the supermarket. 
        The list is of type Product, indicating that it will store objects of the Product class.*/
        ArrayList<Product> frozen_food = new ArrayList<>();
        frozen_food.add(new Product("cannelloni", (float) 2.99, 330, "lactose", "frozen food"));

        /*Adding the sections to the supermarket
        *Each section contains a list of specific products associated with it. 
        These products can be accessed later to view, purchase
         */
        BR.addSection(sections.get(0)); //"fresh food" section 
        BR.addSection(sections.get(1)); //"bakery" section
        BR.addSection(sections.get(2)); //"drinks" section
        BR.addSection(sections.get(3)); //"frozen food" section

        /* for used to add the products to the sections:
        It will go through the lists of products for each section and add these products to the respective sections using the addItem() method of the section class.
        This ensures that the correct products are associated with each section of the supermarket.
         */
        for (Product product : fresh_food) {
            sections.get(0).addItem(product);//"fresh food" section
        }

        for (Product product : bakery) {
            sections.get(1).addItem(product); //"bakery" section
        }

        for (Product product : drinks) {
            sections.get(2).addItem(product);//"drinks" section
        }

        for (Product product : frozen_food) {
            sections.get(3).addItem(product);//"frozen food" section
        }

        //The variables menuMain, and menu2 are strings that contain the menus displayed to the user.
        //menuMain is a main menu
        String menuMain = new String(
                  "*******************************************************************\n"
                + "*CHOOSE AN OPTION:                                                *\n"
                + "*******************************************************************\n"
                + "*0 - Start shop                                                   *\n"
                + "*1 - Show my bag                                                  *\n"
                + "*2 - Remove a product from my bag                                 *\n"       
                + "*3 - Checkout                                                     *\n"
                + "*******************************************************************\n");
        //The menu2 variable is a string containing the second menu displayed to the user.
        String menu2 = new String(
                  "*******************************************************************\n"
                + "*CHOOSE AN OPTION:                                                *\n"
                + "*******************************************************************\n");

        int option; //option variable, which will be used to store the option selected by the user in the menu.
        /*Main loop
        This part of the code implements an interactive menu to simulate a shopping process
        *do-while loop that continues until the user's option is 3 (check out). 
        Inside the loop, the code uses a switch structure to perform different actions based on the option selected by the user.
        */
        
        do {// Get user option from main menu
            option = menuManager.getUserInt(menuMain, 0, 3); //the code prompts the user to enter an integer using the getUserInt method of the menuManager object
            
            /*switch will be executed for the option chosen by the user
            Depending on the value of option, different blocks of code will be executed for options 0, 1 and 2.
            */
            switch (option) {
                case 0:  //option 0 - Option to select a section and add products to the shopping bag
                    int index = 0; //initialize with the value 0
                    int sectionOption; //variable
                    int productOption; //variable
                    int qtd = 1; //variable
                    
                    //Show available sections
                    for (section my_section : BR.getAllSections()) { //On each iteration, the my_section object represents a specific section.
                        System.out.print(index + " - "); //Prints the index value followed by a hyphen to the console. This is used to display an identifier number for each section.
                        my_section.showSection(); //Calls the showSection() method on the my_section object, which show the section's information.
                        index++; //Increment the index at each iteration
                    }
                    sectionOption = menuManager.getUserInt("Choose a section", 0, index - 1); //ask the user to choose a section by typing an int
                    

                    int choose = 1; //Declares the variable choose and initializes it with the value 1.

                    do { /*Starts a do-while loop. The block of code inside this loop will be executed at least once 
                        and will continue to be repeated as long as the specified condition (in this case, choose == 1) is true.*/
                        
                        ArrayList<Product> allProducts = BR.getSection(sectionOption).getAllProducts(); // Get the list of products in the selected section - using the getSection() method of the BR object SuperMarket
                        
                        // Display available products
                        showProducts(allProducts); //Calls the showProducts() method.  The allProducts variable contains the list of available products.
                        productOption = menuManager.getUserInt("What would you like to choose?", 0, allProducts.size() - 1); //ask the user to choose a product by typing an int
                        Product selectedProduct = BR.getSection(sectionOption).getProduct(productOption); //gets the selected product based on the option chosen by the user
                        qtd = menuManager.getUserInt("Selecione a quantidade.", 1, 99); //asks the user to select the quantity of the product. The user must enter an number (int) between 1 and 99.
                        
                         // Clones the selected product and sets the quantity
                        Product new_selectedProduct = selectedProduct.cloneOject(); //The cloneOject() method is responsible for creating an exact copy of the selectedProduct object.
                        new_selectedProduct.setQtd(qtd); //quantity of the selected product based on the amount entered by the user. The qty variable contains the chosen quantity.
                        userBag.buyItem(new_selectedProduct); //adds the selected new product to the user's shopping bag.
                        
                        /*asks the user if he wants to buy more items in the same section. 
                        The user must enter 1 for "Yes" and 2 for "No". 
                        The user's response is stored in the choose variable.*/
                        choose = menuManager.getUserInt("Do you want buy more itens in this section ?\n 1 - Yes\n 2 - No", 1, 2);
                        
                    } while (choose == 1); //If choose is equal to 1, the loop will repeat and ask the user to buy more items in the same section. Otherwise, the loop will be finished

                    break;
                    
                 
                case 1: //Option 1 - option to view products from the shopping bag. For it the method showBag() was used.
                    showBag(userBag);
                    
                    break;
                case 2: //option 2
                    
                /*Option to remove products from the shopping bag
                    */
                    int bagChoose; //variable
                    int productToRemove; //variable
                    int loopChoose = 1; //variable
                    bagChoose = menuManager.getUserInt("\nWhat do you want to do ?\n 1 - Remove a product.\n 2 - Cotinue buying.", 1, 2);
                    
                    /*checks if the option chosen by the user is equal to 1 and if the number of products in the shopping bag (userBag) is greater than 0.
                    If both conditions are true, the code block inside the if will be executed.*/
                    if (bagChoose == 1 && userBag.getNumOfProducts() > 0) {

                        do {
                            showBag(userBag); //the code checks for products in the bag shopping and then displays the products in the bag using the showBag() method.
                            
                            //The user selects the product he wants to remove from the bag
                            productToRemove = menuManager.getUserInt("Which products would you like to remove from your bag?", 0, userBag.getNumOfProducts() - 1); 
                            int qtdToRemove = 1;
                            
                            //user selects a product to remove and has the option to select the quantity to be removed. 
                            //The product is removed from the bag using the removeProduct() method of the ShoppingBag class. 
                            if (userBag.getProduct(productToRemove).getQtd() > 1) {
                                qtdToRemove = menuManager.getUserInt("Select how many product do you want remove.", 1, userBag.getProduct(productToRemove).getQtd());

                                if (qtdToRemove == userBag.getProduct(productToRemove).getQtd()) {
                                    userBag.removeProduct(productToRemove);
                                } else {
                                    userBag.getProduct(productToRemove).setQtd(userBag.getProduct(productToRemove).getQtd() - qtdToRemove);
                                }
                            } else {
                                userBag.removeProduct(productToRemove);
                            }

                            System.out.println("\nProduct removed with sucessful\n");
                            loopChoose = menuManager.getUserInt("Do want to remove more products?\n 1 - Yes \n 2 - No", 1, 2); //The user has the option to remove more products.
                            
                        } while (loopChoose == 1); //do-while loop that will be repeated as long as the loopChoose variable is equal to 1.

                    }
                    
                    break;
                    
                case 3:
                    // Option to finalize the purchase and select the payment method
                    showBag(userBag); //The code displays the contents of the shopping bag using the showBag() method.
                    howPay(menu2, BR, userBag,menuManager);//calls the howPay() function to display the available payment options and prompt the user to choose a payment method.
                    userBag.emptyBag();//After the payment is selected, the cart is emptied using the emptyBag() method of the ShoppingBag class.
                    System.exit(0);//the program exits.
                    break;

                default:
                    System.out.println("Error. Invalid option");//if the user type a number invaliable 
                    break;
            }
        } while (option != 3);

    }

    /*method called printMenu(String menuMain) which just prints the menuMain passed as an argument.*/
    public static void printMenu(String menuMain) {
        System.out.println(menuMain);
    }

    /*method called showBag(ShoppingBag userBag) that iterates over the items in the user's shopping bag and prints the properties of each product. */
    public static void showBag(ShoppingBag userBag) {
        int index = 0;
        for (Product product : userBag.getItems()) {
            System.out.println(index + " - ");
            System.out.println(product.getProperty());
            System.out.print("\n");
            index++;
        }
    }

/*method called howPay(String menu3, SuperMarket BR) that iterates over the payment options available in the supermarket and prints them.
    */
    public static void howPay(String menu, SuperMarket BR, ShoppingBag userBag,IOUtils menuManager) {
        System.out.println(menu);
        int index = 0;
        float subTotal = 0;
        
        //Calculate the subtotal of the items in the user's shopping bag
        for(Product bagProduct : userBag.getItems()) {
            subTotal += bagProduct.getTotalValue(); 
        }
        
        System.out.println("Subtotal: " + subTotal); //print subtotal
        
        //Display the available payment options
        for (String payment : BR.getTypeOfPayments()) {
            System.out.print(index + " - "); //numbers 
            System.out.println(payment);
            System.out.print("\n");
            index++;
        }
         //Prompt the user to select a payment method
        int selectedPayment = menuManager.getUserInt("Select a payment method", 0, index); //ask the users what way of payment they want
        System.out.println("\nSelected: " + BR.getPayment(selectedPayment) + "\n");
        menuManager.getUserInt("\nInsert your password.\n"); //ask for the user to enter their password *i just put it like a test, but i did not do code for check password
        System.out.println("\nPayment received successfully!\n"); //anything type user will be accepted in this test

    }
    
/*This method showProducts takes an ArrayList of Product objects as an argument. 
 It iterates over the products using a for-each loop and prints the properties of each product.
    */
    public static void showProducts(ArrayList<Product> products) {
        int index = 0;
        System.out.print("\n");
        for (Product product : products) {
            System.out.println(index + " - ");
            System.out.println(product.getProperty());
            System.out.print("\n");
            index++;
        }
    }
/*This method pause creates a Scanner object pause and waits for user input. 
 It is used to pause the program execution until the user presses the Enter key.*/
    public static void pause() {
        Scanner pause = new Scanner(System.in);
        pause.next();
    }

}

