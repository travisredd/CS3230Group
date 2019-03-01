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
     * Declaration of clsSQLStatements object, which holds all relevant
     * SQL statements
     */
    clsSQLStatements sqlDriver = new clsSQLStatements();
    
    /**
     * Method that returns an ObservableList of all existing Customers
     * in the database.
     * @return
     * @throws Exception 
     */
    public ObservableList<clsCustomers> getCustomers() throws Exception 
    {
        try{
            //Create ArrayList of Customer objects
            List<clsCustomers> List = new ArrayList<>();
            
            //Create ObservableList of Customer objects
            ObservableList<clsCustomers> lstOfCustomers = FXCollections.observableList(List);
            
            //Use SQL statement to retrieve Customers from database
            ResultSet customerResults = clsDataAccess.ExecuteSQL_Query(sqlDriver.returnAllCustomers());
            
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
    public ObservableList<clsOrders> getOrders(clsCustomers customer) throws Exception {
        try{
            //Create list of Order objects
            List<clsOrders> List = new ArrayList<>();
            
            //Create ObservableList based off of existing List
            ObservableList<clsOrders> lstOfOrders = FXCollections.observableList(List);
            
            //Create ResultSet to hold results from Order table
            ResultSet orderResults = clsDataAccess.ExecuteSQL_Query(sqlDriver.returnAllOrders(customer.getCustID()));
            
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
     * Method that checks to see if a current customer has any orders left. Returns
     * true if the customer has any existing orders
     * @param customer
     * @return
     * @throws Exception 
     */
    public boolean checkForOrders(clsCustomers customer) throws Exception {
        try{
            //Create ResultSet to hold results from Order table
            ResultSet orderResults = clsDataAccess.ExecuteSQL_Query(sqlDriver.returnAllOrders(customer.getCustID()));
            
            //If there are any entries, return true
            if(orderResults.next())
                return true;
            else
                return false;
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
    public void UpdateCustomer(String custID, String newName, String newCompany) throws Exception {
        try{
            clsDataAccess.ExecuteNonQuerySQL(sqlDriver.updateCustomer(custID, newName, newCompany));
        }
        catch (Exception ex) 
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
     * Method that removes a customer from the database
     * @param customer
     * @throws Exception 
     */
    public void DeleteCustomer(clsCustomers customer) throws Exception{
        try{
            clsDataAccess.ExecuteNonQuerySQL(sqlDriver.deleteCustomer(customer.getCustID()));
        }
        catch (Exception ex) 
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
     * Method that adds a new Customer to the database.
     * @param customer
     * @throws Exception 
     */
    public void InsertCustomer(clsCustomers customer) throws Exception{
        try{
            clsDataAccess.ExecuteNonQuerySQL(sqlDriver.insertCustomer(customer.getCustID(), 
                                            customer.getCustName(), 
                                            customer.getCustCompany()));
        }
        catch (Exception ex) 
        {
            throw new Exception(Thread.currentThread().getStackTrace()[1].getClassName() + "."
            + Thread.currentThread().getStackTrace()[1].getMethodName() + " -> " + ex.getMessage());
        }
        finally
        {
            clsDataAccess.dbDisconnect();
        }
    }
}


