/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Customers.Database;
import Customers.Business.clsCustomers;
import Customers.Business.clsOrders;
import DB.clsDataAccess;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


/**
 * Class that holds SQL statements pertaining to the Customers window
 * 
 * @author Taylor Dawson
 */
public class clsCustomersDB {
    
    /**
     * Method that returns an ObservableList of all existing Customers
     * in the database.
     * @return
     * @throws Exception 
     */
    public static ObservableList<clsCustomers> getCustomers() throws Exception 
    {
        try{
            //Create ArrayList of Customer objects
            List<clsCustomers> List = new ArrayList<>();
            
            //Create ObservableList of Customer objects
            ObservableList<clsCustomers> lstOfCustomers = FXCollections.observableList(List);
            
            //Use SQL statement to retrieve Customers from database
            ResultSet customerResults = clsDataAccess.ExecuteSQL_Query("SELECT * FROM CUSTOMER");
            
            //If there are any results in the database, create a customer for
            //each entry and add it to the list
            while(customerResults.next()){
                String ID = customerResults.getString("CUSTOMERID");
                String name = customerResults.getString("NAME");
                String company = customerResults.getString("COMPANY");
                
                lstOfCustomers.add(new clsCustomers(ID, name, company));
            }
            
            //Return the ObservableList
            return lstOfCustomers;
        }
        catch(Exception ex) 
        {
            throw new Exception(Thread.currentThread().getStackTrace()[1].getClassName() + "."
            + Thread.currentThread().getStackTrace()[1].getMethodName() + " -> " + ex.getMessage());
        }
        finally
        {
            clsDataAccess.dbDisconnect();
        }
    }
    
    /**
     * Method that returns all orders from a specific customer, which is accepted
     * as an argument. 
     * @param customer
     * @return
     * @throws Exception 
     */
    public static ObservableList<clsOrders> getOrders(clsCustomers customer) throws Exception {
        try{
            //Create list of Order objects
            List<clsOrders> List = new ArrayList<>();
            
            //Create ObservableList based off of existing List
            ObservableList<clsOrders> lstOfOrders = FXCollections.observableList(List);
            
            //Create ResultSet to hold results from Order table
            ResultSet orderResults = clsDataAccess.ExecuteSQL_Query("SELECT " + 
                    "DISTINCT ORDERID, DATE FROM ORDERS WHERE CUSTOMERID = " + 
                    customer.getCustID());
            
            //If there are any results, create an Order object for each row and
            //Add it to the ObservableList
            while(orderResults.next()){
                String ID = orderResults.getString("ORDERID");
                String Date = orderResults.getString("DATE");
                
                lstOfOrders.add(new clsOrders(ID, Date));
            }
            
            //Return the list
            return lstOfOrders;
        }
        catch(Exception ex) 
        {
            throw new Exception(Thread.currentThread().getStackTrace()[1].getClassName() + "."
            + Thread.currentThread().getStackTrace()[1].getMethodName() + " -> " + ex.getMessage());
        }
        finally
        {
            clsDataAccess.dbDisconnect();
        }
    }
    
    /**
     * Updates a customer's name and company, but will not update Customer ID
     * @param custID
     * @param newName
     * @param newCompany
     * @throws Exception 
     */
    public static void UpdateCustomer(String custID, String newName, String newCompany) throws Exception {
        try{
            clsDataAccess.ExecuteNonQuerySQL("UPDATE CUSTOMER " + 
                                             "SET NAME = '" + newName + "', " + 
                                             "COMPANY = '" + newCompany + " " +
                                             "WHERE CUSTOMER_ID = " + custID);
        }
        catch (Exception ex) 
        {
            throw new Exception(Thread.currentThread().getStackTrace()[1].getClassName() + "."
            + Thread.currentThread().getStackTrace()[1].getMethodName() + " -> " + ex.getMessage());
        }
    }
    
    /**
     * Method that removes a customer from the database
     * @param customer
     * @throws Exception 
     */
    public static void DeleteCustomer(clsCustomers customer) throws Exception{
        try{
            clsDataAccess.ExecuteNonQuerySQL("DELETE FROM CUSTOMER " + 
                                            "WHERE CUSTOMER_ID = " + customer.getCustID());
        }
        catch (Exception ex) 
        {
            throw new Exception(Thread.currentThread().getStackTrace()[1].getClassName() + "."
            + Thread.currentThread().getStackTrace()[1].getMethodName() + " -> " + ex.getMessage());
        }
    }
    
    /**
     * Method that adds a new Customer to the database.
     * @param customer
     * @throws Exception 
     */
    public static void InsertCustomer(clsCustomers customer) throws Exception{
        try{
            clsDataAccess.ExecuteNonQuerySQL("INSERT INTO CUSTOMER (CUSTOMERID, NAME, COMPANY) " + 
                                            "VALUES (" + customer.getCustID() + ", '" + 
                                            customer.getCustName() + "', '" + 
                                            customer.getCustCompany() + "')");
        }
        catch (Exception ex) 
        {
            throw new Exception(Thread.currentThread().getStackTrace()[1].getClassName() + "."
            + Thread.currentThread().getStackTrace()[1].getMethodName() + " -> " + ex.getMessage());
        }
    }
}


