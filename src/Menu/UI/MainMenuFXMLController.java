package Menu.UI;

import Categories.UI.CategoriesFXMLController;
<<<<<<< HEAD:src/Menu/UI/MainMenuFXMLController.java
import java.io.IOException;
=======
import Customers.UI.CustomersFXMLController;
import Products.UI.ProductsFXMLController;
>>>>>>> Don't have to minimize main window:src/MainMenu/UI/MainMenuFXMLController.java
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 * FXML Controller class
 *
 * @author eric
 */
public class MainMenuFXMLController implements Initializable {
    
    private Stage main;
    final private ProductsFXMLController prod = new ProductsFXMLController();
    final private CategoriesFXMLController cat = new CategoriesFXMLController();
    final private CustomersFXMLController cust = new CustomersFXMLController();
    
    @FXML
    private Button mProductsBtn;
    @FXML
    private Button mCategoriesBtn;
    @FXML
    private Button mCustomersBtn;
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
/*
        FXMLLoader proLoader = new FXMLLoader(getClass().getResource("ProductsFXML.fxml"));
        FXMLLoader catLoader = new FXMLLoader(getClass().getResource("CategoriesFXML.fxml"));
        FXMLLoader custLoader = new FXMLLoader(getClass().getResource("CustomersFXML.fxml"));
        
        BorderPane BorderPaneForProWindow = null;
        BorderPane BorderPaneForCatWindow = null;
        BorderPane BorderPaneForCustWindow = null;
        
        try{
            BorderPaneForProWindow = proLoader.load();
            BorderPaneForCatWindow = catLoader.load();
            BorderPaneForCustWindow = custLoader.load();
        }
        catch(IOException ex){
            Logger.getLogger(MainMenuFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }

        proStage = new Stage();
        catStage = new Stage();
        custStage = new Stage();
        
        proStage.initModality(Modality.APPLICATION_MODAL);
        catStage.initModality(Modality.APPLICATION_MODAL);
        custStage.initModality(Modality.APPLICATION_MODAL);
        
        proScene = new Scene(BorderPaneForProWindow);
        catScene = new Scene(BorderPaneForCatWindow);
        custScene = new Scene(BorderPaneForCustWindow);*/
    }    

    
    @FXML
    private void mProductsClicked(ActionEvent event) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Products/UI/ProductsFXML.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            root.getStylesheets().add(getClass().getResource("darkTheme.css").toExternalForm());
            Stage stage = new Stage();
            stage.setScene(new Scene(root));  
            stage.setTitle("Products");
            stage.show();

        }catch(Exception e){
            System.out.println("Can't load new window");
        }
        //proStage.setScene(proScene);
    }

    @FXML
    private void mCategoriesClicked(ActionEvent event) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Categories/UI/CategoriesFXML.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            root.getStylesheets().add(getClass().getResource("darkTheme.css").toExternalForm());
            Stage stage = new Stage();
            stage.setScene(new Scene(root));  
            stage.setTitle("Categories");
            stage.show(); 
        }catch(Exception e){
            System.out.println("Can't load new window");
        }
        //catStage.setScene(catScene);
    }

    @FXML
    private void mCustomersClicked(ActionEvent event) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Customers/UI/CustomersFXML.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            root.getStylesheets().add(getClass().getResource("darkTheme.css").toExternalForm());
            Stage stage = new Stage();
            stage.setScene(new Scene(root));  
            stage.setTitle("Customers");
            stage.show();
        }catch(Exception e){
            System.out.println("Can't load new window");
        }
        //custStage.setScene(custScene);
    }
    
}
