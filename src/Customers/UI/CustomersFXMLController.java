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

    @FXML
    private Button saveBtn;
    @FXML
    private TextField addCustBox;
    @FXML
    private TextField addNameBox;
    @FXML
    private TextField addCompBox;
    @FXML
    private AnchorPane summaryPane;
    @FXML
    private TableView<?> sumTable;
    @FXML
    private TextField custBox;
    @FXML
    private TextField nameBox;
    @FXML
    private TextField compBox;
    @FXML
    private Button dltBtn;
    @FXML
    private Button editBtn;
    @FXML
    private Button updBtn;
    @FXML
    private TableView<?> table;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void saveBtnPress(ActionEvent event) {
    }

    @FXML
    private void dltBtnPress(ActionEvent event) {
    }

    @FXML
    private void editBtnPress(ActionEvent event) {
    }

    @FXML
    private void updBtnPress(ActionEvent event) {
    }
    
}
