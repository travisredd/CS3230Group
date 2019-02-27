/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Customers.UI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
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
    private TableView<?> sumTable;
    
    
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
    private TableView<?> table;
    
    
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

    
    // </editor-fold>
    
    
    
    // <editor-fold defaultstate="collapsed" desc="Global Variables">
    
    
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
            else
                lblNewIDError.setVisible(false);
            
            
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
                clearNewCustomerBox();
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
                //If the customer does have orders, do not allow them to be deleted

                //If the customer does not have orders, remove them from the 
                //database. 
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
                clearSelectedCustomerBox();
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
            
            //Disable existing customer text fields
            custBox.setDisable(true);
            nameBox.setDisable(true);
            compBox.setDisable(true);
        }
        catch(Exception ex) 
        {
            HandleException(Thread.currentThread().getStackTrace()[1].getClassName(), Thread.currentThread().getStackTrace()[1].getMethodName(), ex.getMessage());
        }
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
