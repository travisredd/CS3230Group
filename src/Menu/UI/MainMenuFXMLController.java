package Menu.UI;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author eric
 */
public class MainMenuFXMLController implements Initializable {
    /*
    private ProductsFXMLController productWindow;
    private CategoriesFXMLController categoryWindow;
    private CustomersFXMLController customerWindow;
    private Stage proStage;
    private Stage catStage;
    private Stage custStage;
    private Scene proScene;
    private Scene catScene;
    private Scene custScene;*/
    
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
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));  
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
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));  
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
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));  
            stage.setTitle("Customers");
            stage.show();
        }catch(Exception e){
            System.out.println("Can't load new window");
        }
        //custStage.setScene(custScene);
    }
    
}
