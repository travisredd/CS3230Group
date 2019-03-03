package Products.UI;

import Products.Business.clsProduct;
import Products.Database.clsProductDAO;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
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

    private boolean parseError = false;
    private int addTmpId = -1;
    
    /**
     * List for first table
     */
    private ObservableList<clsProduct> lstProduct;
    
    /**
     * List for second table
     */
    private ObservableList<clsProduct> lstOrder;
    
    /**
     * Business logic class
     */
    private clsProduct product;
    
    /**
     * Delete button
     */
    @FXML
    private Button dltBtn;

    /**
     * Edit button
     */
    @FXML
    private Button editBtn;

    /**
     * Update button
     */
    @FXML
    private Button updBtn;

    /**
     * Product Id text box
     */
    @FXML
    private TextField prodIdBox;

    /**
     * Product text box
     */
    @FXML
    private TextField prodBox;

    /**
     * Description text box
     */
    @FXML
    private TextField descBox;

    /**
     * Cost text box
     */
    @FXML
    private TextField costBox;
    
    /**
     * Category drop down box
     */
    @FXML
    private ComboBox<String> catBox;

    /**
     * Add product Id text box
     */
    @FXML
    private TextField addProdIdBox;

    /**
     * Add Product text box
     */
    @FXML
    private TextField addProdBox;

    /**
     * Add description text box
     */
    @FXML
    private TextField addDescBox;

    /**
     * Add cost text box
     */
    @FXML
    private TextField addCostBox;

    /**
     * Save button
     */
    @FXML
    private Button saveBtn;

    /**
     * Add category drop down box
     */
    @FXML
    private ComboBox<String> addCatBox;

    /**
     * A summary pane
     */
    @FXML
    private AnchorPane summaryPane;

    /**
     * Bottom table
     */
    @FXML
    private TableView<clsProduct> sumTable;

    /**
     * Column Order Id
     */
    @FXML
    private TableColumn<clsProduct, String> colOrdId;

    /**
     * Column Customer
     */
    @FXML
    private TableColumn<clsProduct, String> colCust;

    /**
     * Column Date
     */
    @FXML
    private TableColumn<clsProduct, String> colDate;

    /**
     * Top table
     */
    @FXML
    private TableView<clsProduct> table;

    /**
     * Column Product Id
     */
    @FXML
    private TableColumn<clsProduct, String> colProdId;

    /**
     * Column Product
     */
    @FXML
    private TableColumn<clsProduct, String> colProd;

    /**
     * Column Description
     */
    @FXML
    private TableColumn<clsProduct, String> colDesc;

    /**
     * Column Category
     */
    @FXML
    private TableColumn<clsProduct, String> colCat;

    /**
     * Column Cost
     */
    @FXML
    private TableColumn<clsProduct, String> colCost;
    
    /**
     * Error Label
     */
    @FXML
    private Label errLbl;
    
    /**
     * Error Label for adding
     */
    @FXML
    private Label addErrLbl;
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try
        {
            lstProduct = clsProductDAO.getAllProducts();
            Disable();
            DisableButtons();
            updateCatBox();
            
            table.setItems(lstProduct);

            colProdId.setCellValueFactory(cellData -> cellData.getValue().GetProductIdProperty().asString());
            colProd.setCellValueFactory(cellData -> cellData.getValue().GetProductProperty());
            colDesc.setCellValueFactory(cellData -> cellData.getValue().GetDescriptionProperty());
            colCat.setCellValueFactory(cellData -> cellData.getValue().GetCategoryProperty());
            colCost.setCellValueFactory(cellData -> cellData.getValue().GetCostProperty().asString());
            colOrdId.setCellValueFactory(cellData -> cellData.getValue().GetOrderIdProperty().asString());
            colCust.setCellValueFactory(cellData -> cellData.getValue().GetCustomerProperty());
            colDate.setCellValueFactory(cellData -> cellData.getValue().GetDateProperty());
        }
        catch(Exception ex)
        {
            HandleException(Thread.currentThread().getStackTrace()[1].getClassName(), 
                    Thread.currentThread().getStackTrace()[1].getMethodName(), ex.getMessage());
        }
    }    

    /**
     * Delete button pressed deletes the selected item
     * @param event 
     */
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
                ClearError();
                Disable();
            }
            else {
                String error = "This product is on these orders: ";
                
                for (int i = 0; i < lstOrder.size(); i++)
                {
                    error += lstOrder.get(i).GetiOrderId();
                    if (lstOrder.size() != i + 1)
                        error += ", ";
                    else
                        error += "!";
                }
                errLbl.setText(error);
            }
        }
        catch(Exception ex)
        {
            HandleException(Thread.currentThread().getStackTrace()[1].getClassName(), 
                    Thread.currentThread().getStackTrace()[1].getMethodName(), ex.getMessage());
        }
    }

    /**
     * Enables properties to be edited
     * @param event 
     */
    @FXML
    private void editBtnPress(ActionEvent event) {
        try
        {
            Enable();
            ClearError();
        }
        catch(Exception ex) 
        {
            HandleException(Thread.currentThread().getStackTrace()[1].getClassName(), 
                    Thread.currentThread().getStackTrace()[1].getMethodName(), ex.getMessage());
        }
    }

    /**
     * sets the new values in the boxes into the table and disables editing
     * @param event 
     */
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
                selectedProduct.SetdCost(Double.parseDouble(costBox.getText()));
                selectedProduct.SetiProductId(Integer.parseInt(prodIdBox.getText()));
                selectedProduct.SetsProduct(prodBox.getText());
                selectedProduct.SetsCategory(catBox.getValue());
                clsProductDAO.UpdateProduct(selectedProduct.GetsProduct(), selectedProduct.GetsDescription(),
                        selectedProduct.GetsCategory(), selectedProduct.GetdCost(), selectedProduct.GetiProductId());
                lstProduct = clsProductDAO.getAllProducts();
                table.setItems(lstProduct);
                Disable();
                ClearError();
            }

        }
        catch(Exception ex) 
        {
            HandleException(Thread.currentThread().getStackTrace()[1].getClassName(),
                    Thread.currentThread().getStackTrace()[1].getMethodName(), ex.getMessage());
        }
    }

    /**
     * saves a new product
     * @param event 
     */
    @FXML
    private void saveBtnPress(ActionEvent event) {
        try
        {
            parseError = false;
            if(addProdIdBox.getText().equals("") == false && addProdBox.getText().equals("") == false && 
                    addDescBox.getText().equals("") == false && addCatBox.getValue().equals("") == false &&
                    addCostBox.getText().equals("") == false) 
            {

                double addTmpCost = -1;
                try{
                    //parseInt vs parseUnsignedInt: parseInt makes this easier for this scenario
                    addTmpId = Integer.parseInt(addProdIdBox.getText());
                    if(addTmpId < 0)
                        SetError("id");
                }catch(Exception e){
                    SetError("id");
                }
                try{
                    addTmpCost = Double.parseDouble(addCostBox.getText());
                    if(addTmpCost < 0)
                        SetError("cost");
                }catch(Exception e){
                    SetError("cost");
                }
                if(!parseError)
                {
                    clsProductDAO.InsertProduct(addTmpId, addProdBox.getText(),
                            addDescBox.getText(), addCatBox.getValue(), addTmpCost);
                    lstProduct = clsProductDAO.getAllProducts();
                    table.setItems(lstProduct);

                    Disable();
                    ClearProducts();
                    ClearAddError();
                }    
            }
            else
            {
                addErrLbl.setText("One or more fields is empty!");
            }
        }
        catch(Exception ex)
        {
            boolean prodIdError = false;
            for(int i = 0; i < lstProduct.size(); i++)
            {
                if(lstProduct.get(i).GetiProductId() == addTmpId){
                    addErrLbl.setText("Product Id already used [" + addProdIdBox.getText() + "]!");
                    prodIdError = true;
                }
                if(!prodIdError)
                    addErrLbl.setText("Please fill in all fields");
            }
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
     * @throws Exception 
     */
    @FXML
    private void tableClick(MouseEvent event) throws Exception 
    {
        Update();
    }

    /**
     * Key press event on the table. 
     * @param event 
     * @throws Exception 
     */
    @FXML
    private void tableKeyPress(KeyEvent event) throws Exception 
    {
        Update();
    }
    
    /**
     * Updates the table
     * @throws Exception 
     */
    private void Update() throws Exception
    {
        dltBtn.setDisable(false);
        updBtn.setDisable(false);
        editBtn.setDisable(false);
        prodIdBox.setText(Integer.toString(table.getSelectionModel().getSelectedItem().GetiProductId()));
        prodBox.setText(table.getSelectionModel().getSelectedItem().GetsProduct());
        descBox.setText(table.getSelectionModel().getSelectedItem().GetsDescription());
        catBox.setValue(table.getSelectionModel().getSelectedItem().GetsCategory());
        costBox.setText(Double.toString(table.getSelectionModel().getSelectedItem().GetdCost()));
        
        lstOrder = clsProductDAO.getOrder(table.getSelectionModel().getSelectedItem().GetiProductId());
        
        colOrdId.setCellValueFactory(cellData -> cellData.getValue().GetOrderIdProperty().asString());
        colCust.setCellValueFactory(cellData -> cellData.getValue().GetCustomerProperty());
        colDate.setCellValueFactory(cellData -> cellData.getValue().GetDateProperty());
        ClearError();
        sumTable.setItems(lstOrder);
    }
    
    /**
     * updates drop down category box
     * @throws Exception 
     */
    private void updateCatBox() throws Exception
    {
        ObservableList<String> categories = FXCollections.observableList(clsProductDAO.getAllCategories());

        catBox.getItems().addAll(categories);
        addCatBox.getItems().addAll(categories);
    }
    
    /**
     * sets boxes to editable
     */
    private void Enable()
    {
            prodBox.setDisable(false);
            descBox.setDisable(false);
            costBox.setDisable(false);   
            catBox.disableProperty().set(false);
    }
    
    /**
     * sets boxes to non editable
     */
    private void Disable()
    {
            prodIdBox.setDisable(true);
            prodBox.setDisable(true);
            descBox.setDisable(true);
            costBox.setDisable(true);
            catBox.disableProperty().set(true);
    }
    
    private void DisableButtons()
    {
            dltBtn.setDisable(true);
            updBtn.setDisable(true);
            editBtn.setDisable(true);
    }
    
    private void ClearError()
    {
        errLbl.setText("");
    }
    
    private void ClearAddError()
    {
        addErrLbl.setText("");
    }
    
    private void SetError(String type)
    {
        parseError = true;
        addErrLbl.setText("Invalid " + type);
    }
}
