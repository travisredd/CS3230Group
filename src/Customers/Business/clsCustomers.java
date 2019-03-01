/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Customers.Business;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Class that represents a Customer in the system
 * 
 * @author Taylor Dawson
 */
public class clsCustomers {
    /**
     * Class-Level Variables
     */
    private StringProperty custID; //Int that holds the customer's id
    private StringProperty custName; //String to hold the customer's name
    private StringProperty custCompany; //String to hold the customer's company
    
    
    
    /**
     * @return the custID
     */
    public StringProperty getCustID() {
        return custID;
    }

    /**
     * @param custID the custID to set
     */
    public void setCustID(String custID) {
        this.custID = new SimpleStringProperty(custID);
    }

    /**
     * @return the custName
     */
    public StringProperty getCustName() {
        return custName;
    }

    /**
     * @param custName the custName to set
     */
    public void setCustName(String custName) {
        this.custName = new SimpleStringProperty(custName);
    }

    /**
     * @return the custCompany
     */
    public StringProperty getCustCompany() {
        return custCompany;
    }

    /**
     * @param custCompany the custCompany to set
     */
    public void setCustCompany(String custCompany) {
        this.custCompany = new SimpleStringProperty(custCompany);
    }
    
    
    
    
    /**
     * Overloaded constructor capable of setting each value for the class.
     * @param ID
     * @param name
     * @param company 
     */
    public clsCustomers(String ID, String name, String company){
        setCustID(ID);
        setCustName(name);
        setCustCompany(company);
    }
}
