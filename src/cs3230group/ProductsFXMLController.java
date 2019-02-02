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
public class ProductsFXMLController implements Initializable {

    @FXML
    private Pane dbPane;
    @FXML
    private AnchorPane summaryPane;
    @FXML
    private Button dltBtn;
    @FXML
    private Button editBtn;
    @FXML
    private Button updBtn;
    @FXML
    private TextField prodIdBox;
    @FXML
    private TextField prodBox;
    @FXML
    private TextField descBox;
    @FXML
    private TextField costBox;
    @FXML
    private TextField addProdIdBox;
    @FXML
    private TextField addProdBox;
    @FXML
    private TextField addDescBox;
    @FXML
    private TextField addCostBox;
    @FXML
    private Button saveBtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
