/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Categories.UI;

import Categories.Business.clsCategories;
import Categories.Database.clsCategoriesDAO;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author erict
 */
public class CategoriesFXMLController implements Initializable {

    /**
     * 
     */
    @FXML
    private Button saveBtn;
    /**
     * 
     */
    @FXML
    private TextField addCatBox;
    /**
     * 
     */
    @FXML
    private TextField addDescBox;
    /**
     * 
     */
    @FXML
    private Pane dbPane;
    /**
     * 
     */
    @FXML
    private AnchorPane summaryPane;
    /**
     * 
     */
    @FXML
    private TextField catBox;
    /**
     * 
     */
    @FXML
    private TextField descBox;
    /**
     * 
     */
    @FXML
    private Button dltBtn;
    /**
     * 
     */
    @FXML
    private Button editBtn;
    /**
     * 
     */
    @FXML
    private Button updBtn;
    /**
     * 
     */
    @FXML
    private TableView<clsCategories> table;
    /**
     * 
     */
    @FXML
    private TableView<clsCategories> sumTable;
    /**
     * 
     */
    @FXML
    private TableColumn<clsCategories, String> colCategoryTable;
    /**
     * 
     */
    @FXML
    private TableColumn<clsCategories, String> colDescriptionTable;
    /**
     * 
     */
    @FXML
    private TableColumn<clsCategories, String> colProductIDSumTable;
    /**
     * 
     */
    @FXML
    private TableColumn<clsCategories, String> colProductSumTable;
    /**
     * 
     */
    @FXML
    private TableColumn<clsCategories, String> colDescriptionSumTable;
    
    /**
     * 
     */
    private ObservableList<clsCategories> lstCategories;
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        try
        {
            lstCategories = clsCategoriesDAO.getAllCategoriesInList();
            colCategoryTable.setCellValueFactory(new PropertyValueFactory<>("sCategory"));
            colDescriptionTable.setCellValueFactory(new PropertyValueFactory<>("sDesctiption"));
            table.setItems(lstCategories);
            
        }
        catch(Exception ex)
        {
            HandleException(Thread.currentThread().getStackTrace()[1].getClassName(), Thread.currentThread().getStackTrace()[1].getMethodName(), ex.getMessage());
        }
    }    

    /**
     * 
     * @param event 
     */
    @FXML
    private void saveBtnPress(ActionEvent event) {
        
    }

    /**
     * 
     * @param event 
     */
    @FXML
    private void dltBtnPress(ActionEvent event) {
    }

    /**
     * 
     * @param event 
     */
    @FXML
    private void editBtnPress(ActionEvent event) {
    }

    /**
     * 
     * @param event 
     */
    @FXML
    private void updBtnPress(ActionEvent event) {
    }
    
    /**
     * 
     * @param sClass
     * @param sMethod
     * @param sExceptionMessage 
     */
    private void HandleException(String sClass, String sMethod, String sExceptionMessage)
    {
        String sMessage = "Exception occured: " + sClass + "." + 
                sMethod + " -> " + sExceptionMessage;
        JOptionPane.showConfirmDialog(null, sMessage, "Exception", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
    }
    
}
