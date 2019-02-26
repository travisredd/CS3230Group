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
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author taylor
 */
public class CustomersFXMLController implements Initializable {

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
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    /**
     * Method that runs when the Save button is pressed. Saves the current
     * customer information and adds a new entry to the database.
     * @param event 
     */
    @FXML
    private void saveBtnPress(ActionEvent event) {
        //Retrieve text entered in the addCustBox text field
        
        
        //Retrieve text entered in the addNameBox text field
        
        
        //Retrieve text entered in the addCompBox text field
        
        
        //Validate all user entered data
        
        
        //If all data passes, save entry to the database
    }

    /**
     * Method that runs when the Delete button is pressed. Deletes the selected
     * customer from the database. Will not work if the customer has current 
     * orders in the system.
     * @param event 
     */
    @FXML
    private void dltBtnPress(ActionEvent event) {
        //Check to see if customer has any orders in the system
            //If the customer does have orders, do not allow them to be deleted
            
            //If the customer does not have orders, remove them from the 
            //database. 
    }

    /**
     * Method that runs when the Edit button is pressed. Allows the user to edit
     * the customer's name and company, but not ID. 
     * @param event 
     */
    @FXML
    private void editBtnPress(ActionEvent event) {
        //Change the Name and Company text fields in the Selected Customer box
        //from read only to allow text entry.
    }

    /**
     * Method that runs when the Update button is pressed. Saves the customer's
     * new name and company to the database. 
     * @param event 
     */
    @FXML
    private void updBtnPress(ActionEvent event) {
        //Ensure valid text in both Name and Company fields in the Selected
        //Customer box
            //If data is valid, update the current entry in the database
            
            //If data is not valid, do not allow entry to be updated
    }
    
}
