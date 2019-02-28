/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Customers.Business;

/**
 *
 * @author w01214771
 */
public class clsOrders {
    /**
     * Class-Level Variables
     */
    private String ID; //Variable to hold the order's ID
    private String date; //Variable to hold the order's date
    
    
    /**
     * @return the ID
     */
    public String getID() {
        return ID;
    }

    /**
     * @param ID the ID to set
     */
    public void setID(String ID) {
        this.ID = ID;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }
    
    
    
    /**
     * Constructor that sets all class-level values
     * @param orderID
     * @param orderDate 
     */
    public clsOrders(String orderID, String orderDate){
        setID(orderID);
        setDate(orderDate);
    }
}