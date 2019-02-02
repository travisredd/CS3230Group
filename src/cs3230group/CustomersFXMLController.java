/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs3230group;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author erict
 */
public class CustomersFXMLController implements Initializable {

    @FXML
    private TextField custIdBox;
    @FXML
    private TextField nameBox;
    @FXML
    private TextField compBox;
    @FXML
    private Button saveBtn;
    @FXML
    private TextField addCustBox;
    @FXML
    private TextField addNameBox;
    @FXML
    private TextField addCompBox;
    @FXML
    private Pane dbPane;
    @FXML
    private AnchorPane summaryPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
