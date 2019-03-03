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
    private String custID; //Int that holds the customer's id
    private String custName; //String to hold the customer's name
    private String custCompany; //String to hold the customer's company
    
    
    
    /**
     * @return the custID as a StringProperty
     */
    public StringProperty getCustIDStringProperty() {
        return new SimpleStringProperty(custID);
    }
    
    /**
     * Returns custID as a normal String
     * @return 
     */
    public String getCustID(){
        return custID;
    }

    /**
     * @param custID the custID to set
     */
    public void setCustID(String custID) {
        this.custID = custID;
    }

    /**
     * @return the custName as a StringProperty
     */
    public StringProperty getCustNameStringProperty() {
        return new SimpleStringProperty(custName);
    }
    
    /**
     * return custName as a simple String
     * @return 
     */
    public String getCustName(){
        return custName;
    }

    /**
     * @param custName the custName to set
     */
    public void setCustName(String custName) {
        this.custName = custName;
    }

    /**
     * @return the custCompany as a StringProperty
     */
    public StringProperty getCustCompanyStringProperty() {
        return new SimpleStringProperty(custCompany);
    }
    
    /**
     * Return custCompany as simple String
     * @return 
     */
    public String getCustCompany(){
        return custCompany;
    }

    /**
     * @param custCompany the custCompany to set
     */
    public void setCustCompany(String custCompany) {
        this.custCompany = custCompany;
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
