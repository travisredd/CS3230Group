/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Customers.Business;

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
     * @return the custID
     */
    public String getCustID() {
        return custID;
    }

    /**
     * @param custID the custID to set
     */
    public void setCustID(String custID) {
        this.custID = custID;
    }

    /**
     * @return the custName
     */
    public String getCustName() {
        return custName;
    }

    /**
     * @param custName the custName to set
     */
    public void setCustName(String custName) {
        this.custName = custName;
    }

    /**
     * @return the custCompany
     */
    public String getCustCompany() {
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
