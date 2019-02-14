<<<<<<< HEAD
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Products.UI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author erict
 */
public class ProductsFXMLController implements Initializable {

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
    @FXML
    private AnchorPane summaryPane;
    @FXML
    private TableView<?> sumTable;
    @FXML
    private TableView<?> table;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
=======
package Products.UI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ProductsFXMLController {

    private Stage main;
    private Stage prod;
    
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
    private ComboBox<?> catBox;

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

    @FXML
    private ComboBox<?> addCatBox;

    @FXML
    private AnchorPane summaryPane;

    @FXML
    private TableView<?> sumTable;

    @FXML
    private TableView<?> table;
    
    @FXML
    void dltBtnPress(ActionEvent event) {

    }

    @FXML
    void editBtnPress(ActionEvent event) {

    }

    @FXML
    void saveBtnPress(ActionEvent event) {

    }

    @FXML
    void updBtnPress(ActionEvent event) {

    }

}
>>>>>>> Don't have to minimize main window
