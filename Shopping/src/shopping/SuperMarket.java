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
public class SuperMarket {

    /*The list called sections which is used to store the sections of the supermarket.
    *The list typeOfPayment which is used to store available payment types.*/
    ArrayList<section> sections = new ArrayList<>();
    ArrayList<String> typeOfPayment = new ArrayList<>();

    /*The superMarket constructor takes a list of payment types as a parameter and adds all elements from the provided list to the class's typeOfPayment list*/
    public SuperMarket(ArrayList<String> typeOfPayment) {
        this.typeOfPayment.addAll(typeOfPayment);
    }

    /**
    This method adds a new section to the SuperMarket.
    @param new_section The section to be added.
    */
    public void addSection(section new_section) {
        sections.add(new_section);
    }
    
    /** This method removes a section from the SuperMarket.
    @param old_section The section to be removed.
    */
    public void removeSection(section old_section) {
        sections.remove(old_section);
    }

    /*This method returns a list of payment types available in the SuperMarket.*/
    public List<String> getTypeOfPayments() {
        return typeOfPayment;
    }
    /*Returns the payment type at the specified index from the typeOfPayment list.*/
    public String getPayment(int index) {
        return this.typeOfPayment.get(index);
    }
    /*Returns the section at the specified index from the sections list.*/
    public section getSection(int index) {
        return this.sections.get(index);
    }
    /*Returns all sections in the supermarket.*/
    public ArrayList<section> getAllSections() {
        return this.sections;
    }
    
   

}







