/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Categories.Database;
import Categories.Business.clsProductInfo;
import Categories.Business.clsCategories;
import DB.clsDataAccess;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.swing.JOptionPane;

/**
 *clsCategoriesDAO to hold the database business logic
 * @author reddt
 */
public class clsCategoriesDAO 
{
    
    /**
     * Create an obserableList to be able to load into the tableView, gets all categories from database with help of the dataAccessClass then creates a list of objects.
     * @return
     * @throws Exception 
     */
    public static ObservableList<clsCategories> getAllCategoriesInList() throws Exception 
    {
        try
        {
            List<clsCategories> List = new ArrayList<>();
            ObservableList<clsCategories> lstCategories = FXCollections.observableList(List);
            ResultSet resultSet = clsDataAccess.ExecuteSQL_Query("Select * From Category");
            while(resultSet.next())
            {
                String sCategory = resultSet.getString("CATEGORY");
                String sDescription = resultSet.getString("DESCRIPTION");
                clsCategories Categories = new clsCategories(sCategory, sDescription);
                lstCategories.add(Categories);
            }
            return lstCategories;
        }
        catch(Exception ex) 
        {
            throw new Exception(Thread.currentThread().getStackTrace()[1].getClassName() + "."
            + Thread.currentThread().getStackTrace()[1].getMethodName() + " -> " + ex.getMessage());
        }
        finally
        {
            clsDataAccess.dbDisconnect();
        }
    }
    
    /**
     * Create an obserableList to be able to load into the tableView, gets all product info from database with help of the dataAccessClass then creates a list of objects.
     * @return
     * @throws Exception 
     */
    public static ObservableList<clsProductInfo> getAllProductsInList(String sCategory) throws Exception 
    {
        try
        {
            List<clsProductInfo> ProductList = new ArrayList<>();
            ObservableList<clsProductInfo> lstProductInfo = FXCollections.observableList(ProductList);
            ResultSet resultSet = clsDataAccess.ExecuteSQL_Query("Select * From Product Where CATEGORY = '" + sCategory +  "'");
            while(resultSet.next())
            {
                String iProductID = resultSet.getString("PRODUCTID");
                String sProduct = resultSet.getString("PRODUCT");
                String sDescription = resultSet.getString("DESCRIPTION");
                clsProductInfo ProductData = new clsProductInfo(Integer.parseInt(iProductID), sProduct,sDescription);
          
                lstProductInfo.add(ProductData);
            }
            return lstProductInfo;
        }
        catch(Exception ex) 
        {
            throw new Exception(Thread.currentThread().getStackTrace()[1].getClassName() + "."
            + Thread.currentThread().getStackTrace()[1].getMethodName() + " -> " + ex.getMessage());
        }
        finally
        {
            clsDataAccess.dbDisconnect();
        }
    }
    
    /**
     * Uses clsDataAcccess class to delete specified category,if it is empty
     * @param sCategory 
     */
    public static void DeleteCategory(String sCategory) throws Exception
    {
        try
        {
            clsDataAccess.ExecuteNonQuerySQL("Delete From Category Where CATEGORY = '" + sCategory +  "'");
        }
        catch (Exception ex)
        {
            throw new Exception(Thread.currentThread().getStackTrace()[1].getClassName() + "."
            + Thread.currentThread().getStackTrace()[1].getMethodName() + " -> " + ex.getMessage());
        }
        
    }
    
    /**
     * Inserts specified category, using dataAccessClass to retrieve information from the DB
     * @param clsNewCategory 
     */
    public static void InsertCategory(clsCategories clsNewCategory) throws Exception
    {
        //testing
        //JOptionPane.showMessageDialog(null, clsNewCategory.getsCategory());
        try
        {
            clsDataAccess.ExecuteNonQuerySQL("INSERT INTO CATEGORY (CATEGORY, DESCRIPTION) VALUES ('"
                    + clsNewCategory.getsCategory() + "','" 
                    + clsNewCategory.getsDescription() + "')");
        }
        catch (Exception ex) 
        {
            throw new Exception(Thread.currentThread().getStackTrace()[1].getClassName() + "."
            + Thread.currentThread().getStackTrace()[1].getMethodName() + " -> " + ex.getMessage());
        }
    }
    
    /**
     * Updates specified category, using dataAccessClass to retrieve information from the DB
     * @param clsCategory 
     */
    public static void UpdateCategory(clsCategories clsSelectedCategory) throws Exception
    {
        try
        {
            clsDataAccess.ExecuteNonQuerySQL("UPDATE CATEGORY SET DESCRIPTION = '" + clsSelectedCategory.getsDescription() 
                    + "'WHERE CATEGORY = '" + clsSelectedCategory.getsCategory() + "'");

        }
        catch (Exception ex) 
        {
            throw new Exception(Thread.currentThread().getStackTrace()[1].getClassName() + "."
            + Thread.currentThread().getStackTrace()[1].getMethodName() + " -> " + ex.getMessage());
        }
    }
}
