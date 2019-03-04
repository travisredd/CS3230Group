/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Customers.UI;

import Customers.Database.clsCustomersDB;
import Customers.Business.clsCustomers;
import Customers.Business.clsOrders;
import java.awt.Color;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author erict
 */
public class CustomersFXMLController implements Initializable {

    
    // <editor-fold defaultstate="collapsed" desc="SB Control Declarations">
    
    /**
     * Button that saves information as a new customer.
     */
    @FXML
    private Button saveBtn;
    
    
    /**
     * Text input box for a new customer's ID.
     */
    @FXML
    private TextField addCustBox;
    
    
    /**
     * Text input box for a new customer's name.
     */
    @FXML
    private TextField addNameBox;
    
    
    /**
     * Text input box for a new customer's company.
     */
    @FXML
    private TextField addCompBox;
    
    
    /**
     * Anchor pane that holds the summary table container.
     */
    @FXML
    private AnchorPane summaryPane;
    
    
    /**
     * Table that displays all orders from the current customer.
     */
    @FXML
    private TableView<clsOrders> sumTable;
    
    
    /**
     * Customer ID of the currently selected customer.
     */
    @FXML
    private TextField custBox;
    
    
    /**
     * Customer name of the currently selected customer.
     */
    @FXML
    private TextField nameBox;
    
    
    /**
     * Customer company of the currently selected customer.
     */
    @FXML
    private TextField compBox;
    
    
    /**
     * Button that deletes the current customer.
     */
    @FXML
    private Button dltBtn;
    
    
    /**
     * Button that allows you to edit the current customer.
     */
    @FXML
    private Button editBtn;
    
    
    /**
     * Button that updates the current customer's information.
     */
    @FXML
    private Button updBtn;
    
    
    /**
     * Table that displays all customers in the system.
     */
    @FXML
    private TableView<clsCustomers> table;
    
    
    /**
     * Error label that pops up when the user tries to save a new customer
     * but does not enter an ID.
     */
    @FXML
    private Label lblNewIDError;
    
    
    /**
     * Error label that pops up when the user tries to save a new customer
     * but does not enter a name.
     */
    @FXML
    private Label lblNewNameError;
    
    
    /**
     * Error label that pops up when the user tries to save a new customer
     * but does not enter a company.
     */
    @FXML
    private Label lblNewCompanyError;
    
    
    /**
     * Error label that pops up when the user tries to update an existing 
     * customer but does not enter a name
     */
    @FXML
    private Label lblNameError;
    
    
    /**
     * Error label that pops up when the user tries to update an existing 
     * customer but does not enter a company
     */
    @FXML
    private Label lblCompanyError;
    
    
    /**
     * Error label that displays when user tries to enter a customer ID that 
     * already exists in the database.
     */
    @FXML
    private Label lblExistingCustomerError;
    
    
    /**
     * Error label that displays when user tries to delete a customer that
     * has orders in the system
     */
    @FXML
    private Label lblDeleteError;
    
    
    /**
     * table column set to clsCustID and string
     */
    @FXML
    private TableColumn<clsCustomers, String> colCustID;
    
    
    /**
     * table column set to colCustName and string
     */
    @FXML
    private TableColumn<clsCustomers, String> colCustName;
    
    
    /**
     * table column set to colCustCompany and string
     */
    @FXML
    private TableColumn<clsCustomers, String> colCustCompany;
    
    
    /**
     * table column set to colOrderID and string
     */
    @FXML
    private TableColumn<clsOrders, String> colOrderID;
    
    
    /**
     * table column set to colOrderDate and string
     */
    @FXML
    private TableColumn<clsOrders, String> colOrderDate;
    
    /**
     * ObservableList that holds the orders to be displayed
     */
    private ObservableList<clsOrders> ordersToDisplay;
    
    /**
     * ObservableList that holds the customers to be displayed
     */
    private ObservableList<clsCustomers> customerList;

    
    // </editor-fold>
    
    
    
    // <editor-fold defaultstate="collapsed" desc="Global Variables">
    /**
     * Declaration of clsCustomersDB object which holds the business logic
     * for SQL statements
     */
    clsCustomersDB databaseDriver;
    
    // </editor-fold>
    
    
    
    // <editor-fold defaultstate="collapsed" desc="SB Control Methods">
    /**
     * Method that runs when the Save button is pressed. Saves the current
     * customer information and adds a new entry to the database.
     * @param event 
     */
    @FXML
    private void saveBtnPress(ActionEvent event) {
        try{
            boolean dataValidated = true;
            
            //Validate all user entered data. Display error if not valid
            if(!validateStringEntry(addCustBox.getText())){
                //If there's no string, do not pass and show error
                lblNewIDError.setVisible(true);
                
                dataValidated = false;
            }
            else{
                if(existingCustomerCheck(addCustBox.getText())){
                    dataValidated = false;
                    lblExistingCustomerError.setVisible(true);
                }
                else{
                    lblNewIDError.setVisible(false);
                    lblExistingCustomerError.setVisible(false);
                }
            }
            
            //Check to see if the entered ID number already exists in the database
            if(!addCustBox.getText().isEmpty()){
                
            }
            
            
            if(!validateStringEntry(addNameBox.getText())){
                //If there's no string, do not pass and show error
                lblNewNameError.setVisible(true);
                
                dataValidated = false;
            }
            else
                lblNewNameError.setVisible(false);
            
            
            if(!validateStringEntry(addCompBox.getText())){
                //If there's no string, do not pass and show error
                lblNewCompanyError.setVisible(true);
                
                dataValidated = false;
            }
            else
                lblNewCompanyError.setVisible(false);
            
            
            //If all data passes, save entry to the database
            if(dataValidated){
                databaseDriver.InsertCustomer(new clsCustomers(addCustBox.getText(),
                                                addNameBox.getText(), addCompBox.getText()));
                
                clearNewCustomerBox();
                
                updateCustomers();
            }
        }
        catch(Exception ex) 
        {
            HandleException(Thread.currentThread().getStackTrace()[1].getClassName(), Thread.currentThread().getStackTrace()[1].getMethodName(), ex.getMessage());
        }
    }

    /**
     * Method that runs when the Delete button is pressed. Deletes the selected
     * customer from the database. Will not work if the customer has current 
     * orders in the system.
     * @param event 
     */
    @FXML
    private void dltBtnPress(ActionEvent event) {
        try{
            //Check to see if customer has any orders in the system
            if(table.getSelectionModel().getSelectedItem() != null){
                clsCustomers selectedCustomer = table.getSelectionModel().getSelectedItem();
                
                //If the customer does have orders, do not allow them to be deleted
                if(databaseDriver.checkForOrders(selectedCustomer)){
                    lblDeleteError.setVisible(true);
                }
                //If the customer does not have orders, remove them from the 
                //database.
                else{
                    databaseDriver.DeleteCustomer(selectedCustomer);
                    updateCustomers();
                    custBox.setText("");
                    dltBtn.setDisable(true);
                    editBtn.setDisable(true);
                }
                    
            }
                

                 
        }
        catch(Exception ex) 
        {
            HandleException(Thread.currentThread().getStackTrace()[1].getClassName(), Thread.currentThread().getStackTrace()[1].getMethodName(), ex.getMessage());
        }
    }

    /**
     * Method that runs when the Edit button is pressed. Allows the user to edit
     * the customer's name and company, but not ID. 
     * @param event 
     */
    @FXML
    private void editBtnPress(ActionEvent event) {
        try{
            //Change the Name and Company text fields in the Selected Customer box
            //from read only to allow text entry.
            nameBox.setDisable(false);
            compBox.setDisable(false);
            
            //Enable Update button
            updBtn.setDisable(false);
        }
        catch(Exception ex) 
        {
            HandleException(Thread.currentThread().getStackTrace()[1].getClassName(), Thread.currentThread().getStackTrace()[1].getMethodName(), ex.getMessage());
        }
    }

    /**
     * Method that runs when the Update button is pressed. Saves the customer's
     * new name and company to the database. 
     * @param event 
     */
    @FXML
    private void updBtnPress(ActionEvent event) {
        try{
            //Boolean variable that
            boolean validData = true;
            
            //Validate a name has been entered
            if(!validateStringEntry(nameBox.getText())){
                //If there's no string, do not pass and show error
                lblNameError.setVisible(true);
                
                validData = false;
            }
            else
                lblNameError.setVisible(false);
            
            //Validate a company has been entered
            if(!validateStringEntry(compBox.getText())){
                //If there's no string, do not pass and show error
                lblCompanyError.setVisible(true);
                
                validData = false;
            }
            else
                lblCompanyError.setVisible(false);
            
            
            
            //If both fields have data, clear errors and save to database
            if(validData){
                databaseDriver.UpdateCustomer(custBox.getText(), nameBox.getText(), 
                                            compBox.getText());
                
                updateCustomers();
                
                clearSelectedCustomerBox();
                
                //Disable buttons and clear the customer ID text box
                dltBtn.setDisable(true);
                editBtn.setDisable(true);
                updBtn.setDisable(true);
                
                nameBox.setDisable(true);
                compBox.setDisable(true);
                custBox.setText("");
            }
        }
        catch(Exception ex) 
        {
            HandleException(Thread.currentThread().getStackTrace()[1].getClassName(), Thread.currentThread().getStackTrace()[1].getMethodName(), ex.getMessage());
        }
    }
    
    /**
     * Method that runs when a customer is clicked on in the TableView. Clicking
     * on a customer displays all current orders for them on the order TableView.
     * @param event
     * @throws Exception 
     */
    @FXML
    private void customerTableClicked(MouseEvent event) throws Exception{
        try{
            if(table.getSelectionModel().getSelectedItem() != null){
                //Get the currently selected customer
                clsCustomers selectedCustomer = table.getSelectionModel().getSelectedItem();
                
                //Display the customer's information
                custBox.setText(selectedCustomer.getCustID());
                nameBox.setText(selectedCustomer.getCustName());
                compBox.setText(selectedCustomer.getCustCompany());
                
                //Clear the 'cannot delete' error message
                lblDeleteError.setVisible(false);

                //Get list of orders from the currently selected customer
                ordersToDisplay = databaseDriver.getOrders(selectedCustomer);

                //Display the orders from the currently selected customer
                sumTable.setItems(ordersToDisplay);
                
                colOrderID.setCellValueFactory(cellData -> cellData.getValue().getOrderID());
                colOrderDate.setCellValueFactory(cellData -> cellData.getValue().getOrderDate());
                
                //Enable the Delete and Edit buttons
                dltBtn.setDisable(false);
                editBtn.setDisable(false);
            }
            
            
        }
        catch(Exception ex) 
        {
            HandleException(Thread.currentThread().getStackTrace()[1].getClassName(), Thread.currentThread().getStackTrace()[1].getMethodName(), ex.getMessage());
        }
    }
    // </editor-fold>
    
    
    
    // <editor-fold defaultstate="collapsed" desc="Utility Methods">
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try{
            initializationMethod();
        }
        catch(Exception ex) 
        {
            HandleException(Thread.currentThread().getStackTrace()[1].getClassName(), Thread.currentThread().getStackTrace()[1].getMethodName(), ex.getMessage());
        }
    }  
    
    
    /**
     * Method that runs at start up to initialize the program and all
     * start-up values.
     */
    private void initializationMethod(){
        try{
            
            //Hide error labels
            lblNewIDError.setVisible(false);
            lblNewNameError.setVisible(false);
            lblNewCompanyError.setVisible(false);
            lblNameError.setVisible(false);
            lblCompanyError.setVisible(false);
            lblExistingCustomerError.setVisible(false);
            lblDeleteError.setVisible(false);
            
            //Disable existing customer text fields
            custBox.setDisable(true);
            nameBox.setDisable(true);
            compBox.setDisable(true);
            
            //Initialization of clsCustomersDB object
            databaseDriver = new clsCustomersDB();
            
            //Display the customers
            updateCustomers();
        }
        catch(Exception ex) 
        {
            HandleException(Thread.currentThread().getStackTrace()[1].getClassName(), Thread.currentThread().getStackTrace()[1].getMethodName(), ex.getMessage());
        }
    }
    
    /**
     * Method that runs to update the current list of customers
     */
    private void updateCustomers(){
        try{
            customerList = databaseDriver.getCustomers();
            table.setItems(customerList);
            
            //Set up the tableViews for display
            colCustID.setCellValueFactory(cellData -> cellData.getValue().getCustIDStringProperty());
            colCustName.setCellValueFactory(cellData -> cellData.getValue().getCustNameStringProperty());
            colCustCompany.setCellValueFactory(cellData -> cellData.getValue().getCustCompanyStringProperty());
        }
        catch(Exception ex) 
        {
            HandleException(Thread.currentThread().getStackTrace()[1].getClassName(), Thread.currentThread().getStackTrace()[1].getMethodName(), ex.getMessage());
        }
    }
    
    /**
     * Method that accepts a String as an argument and checks it against existing
     * customer IDs to see if it is in the system. Returns true if the customer
     * currently exists and false if not.
     * @param ID
     * @return 
     */
    private boolean existingCustomerCheck(String ID){
        try{
            ObservableList<clsCustomers> custList = databaseDriver.getCustomers();
            
            List<clsCustomers> temp = custList.stream().collect(Collectors.toList());
            
            for(int count = 0; count < custList.size(); count++){
                if(temp.get(count).getCustID().toString().equals(ID))
                    return true;
            }
        }
        catch(Exception ex) 
        {
            HandleException(Thread.currentThread().getStackTrace()[1].getClassName(), Thread.currentThread().getStackTrace()[1].getMethodName(), ex.getMessage());
        }
        
        return false;
    }
    
    /**
     * Method that accepts a string and checks to see if the string has any
     * text within.
     * @param toVerify
     * @return 
     */
    private boolean validateStringEntry(String toVerify){
        if(toVerify.isEmpty())
            return false;
        else
            return true;
    }
    
    /**
     * Method that clears all error messages and empties all text boxes
     * in the Selected Customer box
     */
    private void clearSelectedCustomerBox(){
        //Clear error messages
        lblNameError.setVisible(false);
        lblCompanyError.setVisible(false);

        //Empty text fields
        custBox.clear();
        nameBox.clear();
        compBox.clear();
        
        //Disable the Name and Company text fields
        nameBox.setDisable(true);
        compBox.setDisable(true);
    }
    
    /**
     * Method that clears all error messages and empties all text boxes in the
     * Add Customer box
     */
    private void clearNewCustomerBox(){
        //Hide all error messages
        lblNewIDError.setVisible(false);
        lblNewNameError.setVisible(false);
        lblNewCompanyError.setVisible(false);

        //Clear text boxes
        addCustBox.clear();
        addNameBox.clear();
        addCompBox.clear();
    }
    
    
    /**
     * Handles the errors. 
     * @param sClass
     * @param sMethod
     * @param sExceptionMessage 
     */
    private void HandleException(String sClass, String sMethod, 
            String sExceptionMessage)
    {
        String sMessage = "Exception occured: " + sClass + "." + 
                sMethod + " -> " + sExceptionMessage;
        JOptionPane.showConfirmDialog(null, sMessage, "Exception", 
                JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
    }
    
    
    
    // </editor-fold>
}
