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
     * 
     */
    clsCategories newCategory;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        // TODO
        try
        {
            newCategory = new clsCategories();
            
            lstCategories = clsCategoriesDAO.getAllCategoriesInList();
            colCategoryTable.setCellValueFactory(new PropertyValueFactory<>("sCategory"));
            colDescriptionTable.setCellValueFactory(new PropertyValueFactory<>("sDescription"));
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
            //tied to clsCategoriesDAO to edit the selected category
            clsCategoriesDAO.InsertCategory(newCategory);
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
            //tied to clsCategoriesDAO to update the selected category
            clsCategoriesDAO.UpdateCategory(newCategory);
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
    
}
