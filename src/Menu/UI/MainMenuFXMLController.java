package Menu.UI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author eric
 */
public class MainMenuFXMLController implements Initializable {
    
    private static final int MAX_WINDOWS = 1;
    /**
     * how many prod windows are open
     */
    private int prodWindowCount = 0;
    /**
     * how many cat windows are open
     */
    private int catWindowCount = 0;
    /**
     * how many cust windows are open
     */
    private int custWindowCount = 0;
    /**
     * products button
     */
    @FXML
    private Button mProductsBtn;
    /**
     * categories button
     */
    @FXML
    private Button mCategoriesBtn;
    /**
     * customers button
     */
    @FXML
    private Button mCustomersBtn;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    /**
     * load product window
     * @param event 
     */
    @FXML
    private void mProductsClicked(ActionEvent event) {
        //if(prodWindowCount < MAX_WINDOWS)
        //{
            try{
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Products/UI/ProductsFXML.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                root1.getStylesheets().add(getClass().getResource("darkTheme.css").toExternalForm());
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));  
                stage.setTitle("Products");
                stage.show();
                //prodWindowCount++;
                //if(stage.onCloseRequestProperty().equals(true))
                //    prodWindowCount--;
            }catch(Exception e){
                System.out.println("Can't load new window");
            }
        //}
    }

    /**
     * load category window
     * @param event 
     */
    @FXML
    private void mCategoriesClicked(ActionEvent event) {
        //if(catWindowCount < MAX_WINDOWS)
        //{
            try{
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Categories/UI/CategoriesFXML.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                root1.getStylesheets().add(getClass().getResource("darkTheme.css").toExternalForm());
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));  
                stage.setTitle("Categories");
                stage.show(); 
                //catWindowCount++;
                //if(stage.onCloseRequestProperty().equals(true))
                //    catWindowCount--;
            }catch(Exception e){
                System.out.println("Can't load new window");
            }
        //}
    }

    /**
     * load customer window
     * @param event 
     */
    @FXML
    private void mCustomersClicked(ActionEvent event) {
        //if(custWindowCount < MAX_WINDOWS)
        //{
            try{
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Customers/UI/CustomersFXML.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                root1.getStylesheets().add(getClass().getResource("darkTheme.css").toExternalForm());
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));  
                stage.setTitle("Customers");
                stage.show();
                //custWindowCount++;
                //if(stage.onCloseRequestProperty().equals(true))
                //    custWindowCount--;
            }catch(Exception e){
                System.out.println("Can't load new window");
            }
        //}
    }
    
}
