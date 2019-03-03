/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Customers.Database;

/**
 *
 * @author Taylor Dawson
 */
public class clsSQLStatements {
    /**
     * Method that returns all data from the Customer table
     * @return 
     */
    public String returnAllCustomers(){
        return "SELECT * FROM CUSTOMER";
    }
    
    /**
     * Method that returns the OrderID and Date from orders from a specific
     * customer
     * @param custNumber
     * @return 
     */
    public String returnAllOrders(String custNumber){
        String returnStatement = "SELECT DISTINCT ORDERID, DATE FROM" +
                " ORDERS WHERE CUSTOMERID = " + custNumber;
        return returnStatement;
    }
    
    /**
     * Method that returns a statement to update a customer in the Customer table
     * @param ID
     * @param name
     * @param company
     * @return 
     */
    public String updateCustomer(String ID, String name, String company){
        return ("UPDATE CUSTOMER SET NAME = '" + name + "', COMPANY = '" + company 
                + "' WHERE CUSTOMERID = " + ID);
    }
    
    /**
     * Method that returns a statement to delete a customer from the Customer table
     * @param ID
     * @return 
     */
    public String deleteCustomer(String ID){
        return ("DELETE FROM CUSTOMER " +
                "WHERE CUSTOMERID = " + ID);
    }
    
    /**
     * Method that returns a statement to insert a customer into the Customer table
     * @param ID
     * @param name
     * @param company
     * @return 
     */
    public String insertCustomer(String ID, String name, String company){
        return ("INSERT INTO CUSTOMER (CUSTOMERID, NAME, COMPANY) " +
                "VALUES (" + ID + ", '" + name + "', '" + company + "')");                        
    }
}
