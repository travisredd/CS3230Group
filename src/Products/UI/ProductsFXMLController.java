/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Products.UI;

import Products.Business.clsProduct;
import Products.Database.clsProductDAO;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author eric
 */
public class ProductsFXMLController implements Initializable {

    private ObservableList<clsProduct> lstProduct;
    
    private ObservableList<clsProduct> lstOrder;
    
    private clsProduct product;
    
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
    private ComboBox<String> catBox;

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
    private ComboBox<String> addCatBox;

    @FXML
    private AnchorPane summaryPane;

    @FXML
    private TableView<clsProduct> sumTable;

    @FXML
    private TableColumn<clsProduct, String> colOrdId;

    @FXML
    private TableColumn<clsProduct, String> colCust;

    @FXML
    private TableColumn<clsProduct, String> colDate;

    @FXML
    private TableView<clsProduct> table;

    @FXML
    private TableColumn<clsProduct, String> colProdId;

    @FXML
    private TableColumn<clsProduct, String> colProd;

    @FXML
    private TableColumn<clsProduct, String> colDesc;

    @FXML
    private TableColumn<clsProduct, String> colCat;

    @FXML
    private TableColumn<clsProduct, String> colCost;
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try
        {
            product = new clsProduct();
            lstProduct = clsProductDAO.getAllProducts();
            Disable();
            updateCatBox();
            
            table.setItems(lstProduct);
            
            colOrdId.setCellValueFactory(new PropertyValueFactory<>(lstProduct.toString()));
            /*
            colOrdId.setCellValueFactory(new PropertyValueFactory<>("iProductId"));
            colCust.setCellValueFactory(new PropertyValueFactory<>("sCustomer"));
            colDate.setCellValueFactory(new PropertyValueFactory<>("sDate"));
            colProdId.setCellValueFactory(new PropertyValueFactory<>("iProductId"));
            colProd.setCellValueFactory(new PropertyValueFactory<>("sProduct"));
            colDesc.setCellValueFactory(new PropertyValueFactory<>("sDescription"));
            colCat.setCellValueFactory(new PropertyValueFactory<>("sCategory"));
            colCost.setCellValueFactory(new PropertyValueFactory<>("dCost"));*/

            
        }
        catch(Exception ex)
        {
            HandleException(Thread.currentThread().getStackTrace()[1].getClassName(), Thread.currentThread().getStackTrace()[1].getMethodName(), ex.getMessage());
        }
    }    

    @FXML
    private void dltBtnPress(ActionEvent event) {
        try
        {
            lstOrder = clsProductDAO.getOrder(table.getSelectionModel().getSelectedItem().GetiProductId());
            if(table.getSelectionModel().getSelectedItem().GetsProduct() != null && lstOrder.isEmpty())
            {
                clsProductDAO.DeleteProduct(table.getSelectionModel().getSelectedItem().GetiProductId());
                lstProduct = clsProductDAO.getAllProducts();
                table.setItems(lstProduct);
                sumTable.setItems(lstOrder);
                
                ClearProducts();
            }
            else {
                throw new Exception("Cannot delete Product with stuff");
            }

        }
        catch(Exception ex)
        {
            HandleException(Thread.currentThread().getStackTrace()[1].getClassName(), Thread.currentThread().getStackTrace()[1].getMethodName(), ex.getMessage());
        }
    }

    @FXML
    private void editBtnPress(ActionEvent event) {
        try
        {
            Enable();
        }
        catch(Exception ex) 
        {
            HandleException(Thread.currentThread().getStackTrace()[1].getClassName(), Thread.currentThread().getStackTrace()[1].getMethodName(), ex.getMessage());
        }
    }

    @FXML
    private void updBtnPress(ActionEvent event) {
        try
        {
            clsProduct selectedProduct = table.getSelectionModel().getSelectedItem();
            
            if(selectedProduct != null && !prodBox.getText().equals("") && !descBox.getText().equals("") &&
                    !costBox.getText().equals("") && !prodIdBox.getText().equals("")) 
            {
                //clsSelectedCategory.setsCategory(catBox.getText());
                selectedProduct.SetsDescription(descBox.getText());
                selectedProduct.SetdCost(Integer.parseInt(costBox.getText()));
                selectedProduct.SetiProductId(Integer.parseInt(prodIdBox.getText()));
                selectedProduct.SetsProduct(prodBox.getText());
                selectedProduct.SetsCategory(catBox.getValue());
                clsProductDAO.UpdateProduct(selectedProduct.GetsProduct(), selectedProduct.GetsDescription(),
                        selectedProduct.GetsCategory(), selectedProduct.GetdCost(), selectedProduct.GetiProductId());
                lstProduct = clsProductDAO.getAllProducts();
                table.setItems(lstProduct);
            }

        }
        catch(Exception ex) 
        {
            HandleException(Thread.currentThread().getStackTrace()[1].getClassName(), Thread.currentThread().getStackTrace()[1].getMethodName(), ex.getMessage());
        }
    }

    @FXML
    private void saveBtnPress(ActionEvent event) {
        try
        {
            //need to make sure there is stuff to delete
            if(addProdIdBox.getText().equals("") == false && addProdBox.getText().equals("") == false && addDescBox.getText().equals("") == false &&
                    addCatBox.getValue().equals("") == false && addCostBox.getText().equals("") == false) 
            {
                //clsProduct newProduct = new clsProduct(Integer.parseInt(prodIdBox.getText()), prodBox.getText(),
                  //      descBox.getText(), catBox.getValue(), Double.parseDouble(costBox.getText()));
                clsProductDAO.InsertProduct(Integer.parseInt(addProdIdBox.getText()), addProdBox.getText(),
                        addDescBox.getText(), addCatBox.getValue(), Double.parseDouble(addCostBox.getText()));
                lstProduct = clsProductDAO.getAllProducts();
                table.setItems(lstProduct);
                
                Disable();
                
                ClearProducts();
            }
        }
        catch(Exception ex)
        {
            HandleException(Thread.currentThread().getStackTrace()[1].getClassName(), Thread.currentThread().getStackTrace()[1].getMethodName(), ex.getMessage());
        }
    }
    
        /**
     * Handles the errors. 
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
     * Clears values in boxes.
     */
    private void ClearProducts()
    {
        prodIdBox.setText("");
        prodBox.setText("");
        descBox.setText("");
        catBox.setValue("");
        costBox.setText("");
    }
    
    /**
     * Mouse click event on the table. 
     * @param event 
     */
    @FXML
    private void tableClick(MouseEvent event) throws Exception 
    {
        Update();
    }

    /**
     * Key press event on the table. 
     * @param event 
     */
    @FXML
    private void tableKeyPress(KeyEvent event) throws Exception 
    {
        Update();
    }
    
    private void Update() throws Exception
    {
        prodIdBox.setText(Integer.toString(table.getSelectionModel().getSelectedItem().GetiProductId()));
        prodBox.setText(table.getSelectionModel().getSelectedItem().GetsProduct());
        descBox.setText(table.getSelectionModel().getSelectedItem().GetsDescription());
        catBox.setValue(table.getSelectionModel().getSelectedItem().GetsCategory());
        costBox.setText(Double.toString(table.getSelectionModel().getSelectedItem().GetdCost()));
        
        lstOrder = clsProductDAO.getOrder(table.getSelectionModel().getSelectedItem().GetiProductId());
        
        colOrdId.setCellValueFactory(new PropertyValueFactory<>("iOrderId"));
        colCust.setCellValueFactory(new PropertyValueFactory<>("sCustomer"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("sDate"));
            
        sumTable.setItems(lstOrder);
    }
    
    private void updateCatBox() throws Exception
    {
        ObservableList<String> categories = FXCollections.observableList(clsProductDAO.getAllCategories());

        catBox.getItems().addAll(categories);
        addCatBox.getItems().addAll(categories);
    }
    
    private void Enable()
    {
            prodBox.editableProperty().set(true);
            descBox.editableProperty().set(true);
            costBox.editableProperty().set(true);   
            catBox.disableProperty().set(false);
    }
    
    private void Disable()
    {
            prodIdBox.editableProperty().set(false);
            prodBox.editableProperty().set(false);
            descBox.editableProperty().set(false);
            costBox.editableProperty().set(false);
            catBox.disableProperty().set(true);
    }
}
