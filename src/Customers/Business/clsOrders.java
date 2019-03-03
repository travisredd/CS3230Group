/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Customers.Business;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author w01214771
 */
public class clsOrders {
    /**
     * Class-Level Variables
     */
    private StringProperty ID; //Variable to hold the order's ID
    private StringProperty date; //Variable to hold the order's date
    
    
    /**
     * @return the ID
     */
    public StringProperty getOrderID() {
        return ID;
    }

    /**
     * @param ID the ID to set
     */
    public void setID(String ID) {
        this.ID = new SimpleStringProperty(ID);
    }

    /**
     * @return the date
     */
    public StringProperty getOrderDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = new SimpleStringProperty(date);
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
