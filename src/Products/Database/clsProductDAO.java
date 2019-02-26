/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Products.Database;

import DB.clsDataAccess;
import Products.Business.clsProduct;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author eric
 */
public class clsProductDAO {
    
    public static ObservableList<clsProduct> getAllProducts() throws Exception
    {
        try{
            clsProductSQL sql = new clsProductSQL();
            List<clsProduct> list = new ArrayList<>();
            ObservableList<clsProduct> lstProduct = FXCollections.observableList(list); 
            ResultSet resultSet = clsDataAccess.ExecuteSQL_Query(sql.SelAll());
            
            while(resultSet.next())
            {
                int prodId = resultSet.getInt("PRODUCTID");
                String prod = resultSet.getString("PRODUCT");
                String desc = resultSet.getString("DESCRIPTION");
                String cat = resultSet.getString("CATEGORY");
                double cost = resultSet.getDouble("COST");
                
                clsProduct products = new clsProduct(prodId, prod, desc, cat, cost);
                lstProduct.add(products);
            }
            return lstProduct;
        }catch(Exception ex)
        {
            throw new Exception(Thread.currentThread().getStackTrace()[1].getClassName() + "."
                + Thread.currentThread().getStackTrace()[1].getMethodName() + " -> " + ex.getMessage());
        }
        finally
        {
            clsDataAccess.dbDisconnect();
        }
    }
    
    public static ObservableList<String> getAllCategories() throws Exception
    {
        try{
            clsProductSQL sql = new clsProductSQL();
            List<String> list = new ArrayList<>();
            ObservableList<String> lstCategory = FXCollections.observableList(list);
            ResultSet resultSet = clsDataAccess.ExecuteSQL_Query(sql.SelCategory());
            
            while(resultSet.next())
            {
                String cat = resultSet.getString("CATEGORY");
                
                lstCategory.add(cat);
            }
            return lstCategory;
        }catch(Exception ex)
        {
            throw new Exception(Thread.currentThread().getStackTrace()[1].getClassName() + "."
                + Thread.currentThread().getStackTrace()[1].getMethodName() + " -> " + ex.getMessage());
        }
        finally
        {
            clsDataAccess.dbDisconnect();
        }
    }
    
    public static ObservableList<clsProduct> getOrder(int prodId) throws Exception
    {
        try{
            clsProductSQL sql = new clsProductSQL();
            List<clsProduct> orderList = new ArrayList<>();
            ObservableList<clsProduct> order = FXCollections.observableList(orderList);
            ResultSet resultSet = clsDataAccess.ExecuteSQL_Query(sql.SelOrder(prodId));
            while(resultSet.next())
            {
                int ordId = resultSet.getInt("ORDERID");
                String name = resultSet.getString("NAME");
                Date date = resultSet.getDate("DATE");
                
                clsProduct ord = new clsProduct(ordId, name, date);
                
                order.add(ord);
            }
            return order;
        }catch(Exception ex) 
        {
            throw new Exception(Thread.currentThread().getStackTrace()[1].getClassName() + "."
            + Thread.currentThread().getStackTrace()[1].getMethodName() + " -> " + ex.getMessage());
        }
        finally
        {
            clsDataAccess.dbDisconnect();
        }
    }
    
    public static void DeleteProduct(int productId) throws Exception
    {
        try{
            clsProductSQL sql = new clsProductSQL();
            clsDataAccess.ExecuteNonQuerySQL(sql.DltProd(productId));
        }
        catch (Exception ex)
        {
            throw new Exception(Thread.currentThread().getStackTrace()[1].getClassName() + "."
            + Thread.currentThread().getStackTrace()[1].getMethodName() + " -> " + ex.getMessage());
        }
    }
    
    public static void InsertProduct(int prodId, String prod, String desc, String cat, double cost) throws Exception
    {
        try{
            clsProductSQL sql = new clsProductSQL();
            clsDataAccess.ExecuteNonQuerySQL(sql.InsProd(prodId, prod, desc, cat, cost));
        }
        catch (Exception ex)
        {
            throw new Exception(Thread.currentThread().getStackTrace()[1].getClassName() + "."
            + Thread.currentThread().getStackTrace()[1].getMethodName() + " -> " + ex.getMessage());
        }
    }
    
    public static void UpdateProduct(String newName, String newDesc, String newCat, double newCost, int newId) throws Exception
    {
        try{
            clsProductSQL sql = new clsProductSQL();
            clsDataAccess.ExecuteNonQuerySQL(sql.UpdProd(newName, newDesc, newCat, newCost, newId));
        }
        catch (Exception ex)
        {
            throw new Exception(Thread.currentThread().getStackTrace()[1].getClassName() + "."
            + Thread.currentThread().getStackTrace()[1].getMethodName() + " -> " + ex.getMessage());
        }
    }
}
