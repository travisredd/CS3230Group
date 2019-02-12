/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Categories.UI;
import Categories.Business.clsProductInfo;
import Categories.Business.clsCategories;
import Categories.Database.clsCategoriesDAO;
import com.sun.glass.ui.Cursor;
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
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author erict
 */
public class CategoriesFXMLController implements Initializable 
{

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
    private TableView<clsProductInfo> sumTable;
    
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
    private TableColumn<clsProductInfo, String> colProductIDSumTable;
    
    /**
     * 
     */
    @FXML
    private TableColumn<clsProductInfo, String> colProductSumTable;
    
    /**
     * 
     */
    @FXML
    private TableColumn<clsProductInfo, String> colDescriptionSumTable;
    
    /**
     * 
     */
    private ObservableList<clsCategories> lstCategories;
    
      /**
     * 
     */
    private ObservableList<clsProductInfo> lstProductInfo;
    
    
    /**
     * 
     */
    clsCategories newCategory;
    
    /**
     * 
     */
    clsProductInfo newProductInfo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        // TODO
        try
        {
            catBox.editableProperty().set(false);
            descBox.editableProperty().set(false);
            
            
            newCategory = new clsCategories();
            lstCategories = clsCategoriesDAO.getAllCategoriesInList();
            
            newProductInfo = new clsProductInfo();
            //lstProductInfo = clsCategoriesDAO.getAllProductsInList();
            
            colCategoryTable.setCellValueFactory(new PropertyValueFactory<>("sCategory"));
            colDescriptionTable.setCellValueFactory(new PropertyValueFactory<>("sDescription"));
            
            table.setItems(lstCategories);
            
            //colProductIDSumTable.setCellValueFactory(new PropertyValueFactory<>("iProductID"));
            //colProductSumTable.setCellValueFactory(new PropertyValueFactory<>("sProducts"));
            //colDescriptionSumTable.setCellValueFactory(new PropertyValueFactory<>("sDescription"));
            
            //sumTable.setItems(lstProductInfo);
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
    private void saveBtnPress(ActionEvent event) 
    {
        try
        {
            if(addCatBox.getText().equals("") == false && addDescBox.getText().equals("") == false) 
            {
                clsCategories clsNewCategory = new clsCategories(addCatBox.getText(), addDescBox.getText());
                clsCategoriesDAO.InsertCategory(clsNewCategory);
                lstCategories = clsCategoriesDAO.getAllCategoriesInList();
                table.setItems(lstCategories);
                
                addCatBox.setText("");
                addDescBox.setText("");
            }
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
    private void dltBtnPress(ActionEvent event) 
    {
        //Testing
        //JOptionPane.showConfirmDialog(null, table.getSelectionModel().getSelectedItem().getsCategory());
        try
        {
            if(table.getSelectionModel().getSelectedItem().getsCategory() != null)
            {
                //tied to clsCategoriesDAO to delete the selected category
                clsCategoriesDAO.DeleteCategory(table.getSelectionModel().getSelectedItem().getsCategory());
                lstCategories = clsCategoriesDAO.getAllCategoriesInList();
                table.setItems(lstCategories);
                sumTable.setItems(lstProductInfo);
                catBox.setText("");
                descBox.setText("");
            }

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
    private void editBtnPress(ActionEvent event) 
    {
        try
        {
            descBox.editableProperty().set(true);
            //catBox.editableProperty().set(true);
            //catBox.requestFocus();
            
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
    private void updBtnPress(ActionEvent event) 
    {
        
        try
        {
            clsCategories clsSelectedCategory = table.getSelectionModel().getSelectedItem();
            
            if(clsSelectedCategory != null && catBox.getText().equals("") == false && descBox.getText().equals("") == false) 
            {
                //clsSelectedCategory.setsCategory(catBox.getText());
                clsSelectedCategory.setsDescription(descBox.getText());
                clsCategoriesDAO.UpdateCategory(clsSelectedCategory);
                lstCategories = clsCategoriesDAO.getAllCategoriesInList();
                table.setItems(lstCategories);
            }

        }
        catch(Exception ex) 
        {
            HandleException(Thread.currentThread().getStackTrace()[1].getClassName(), Thread.currentThread().getStackTrace()[1].getMethodName(), ex.getMessage());
        }

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

    /**
     * 
     * @param event 
     */
    @FXML
    private void tableClick(MouseEvent event) throws Exception 
    {
        catBox.setText(table.getSelectionModel().getSelectedItem().getsCategory());
        descBox.setText(table.getSelectionModel().getSelectedItem().getsDescription());
        
        lstProductInfo = clsCategoriesDAO.getAllProductsInList(table.getSelectionModel().getSelectedItem().getsCategory());
        
        colProductIDSumTable.setCellValueFactory(new PropertyValueFactory<>("iProductID"));
        colProductSumTable.setCellValueFactory(new PropertyValueFactory<>("sProducts"));
        colDescriptionSumTable.setCellValueFactory(new PropertyValueFactory<>("sDescription"));
            
        sumTable.setItems(lstProductInfo);
    }

    
    /**
     * 
     * @param event 
     */
    @FXML
    private void tableKeyPress(KeyEvent event) 
    {
        catBox.setText(table.getSelectionModel().getSelectedItem().getsCategory());
        descBox.setText(table.getSelectionModel().getSelectedItem().getsDescription());
    }

}
