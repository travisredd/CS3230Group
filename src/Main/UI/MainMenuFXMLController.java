package Main.UI;

import Categories.UI.CategoriesFXMLController;
import Customers.UI.CustomersFXMLController;
import Products.UI.ProductsFXMLController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author eric
 */
public class MainMenuFXMLController implements Initializable {

    private ProductsFXMLController productWindow;
    private CategoriesFXMLController categoryWindow;
    private CustomersFXMLController customerWindow;
    
    @FXML
    private Button mProductsBtn;
    @FXML
    private Button mCategoriesBtn;
    @FXML
    private Button mCustomersBtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        FXMLLoader proLoader = new FXMLLoader(getClass().getResource("ProductsFXML.fxml"));
        FXMLLoader catLoader = new FXMLLoader(getClass().getResource("CategoriesFXML.fxml"));
        FXMLLoader custLoader = new FXMLLoader(getClass().getResource("CustomersFXML.fxml"));
        
    }    
    
    @FXML
    private void mProductsClicked(ActionEvent event) {
        
    }

    @FXML
    private void mCategoriesClicked(ActionEvent event) {
        
    }

    @FXML
    private void mCustomersClicked(ActionEvent event) {
        
    }
    
}
